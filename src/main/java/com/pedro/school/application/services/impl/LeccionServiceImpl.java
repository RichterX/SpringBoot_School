package com.pedro.school.application.services.impl;

import com.pedro.school.application.dto.LeccionDto;
import com.pedro.school.application.mapper.LeccionMapper;
import com.pedro.school.application.services.LeccionService;
import com.pedro.school.domain.entity.Leccion;
import com.pedro.school.infrastructure.repository.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LeccionServiceImpl implements LeccionService
{
    private final LeccionRepository leccionRepository;
    private final LeccionMapper leccionMapper;

    @Autowired
    public LeccionServiceImpl(LeccionRepository leccionRepository, LeccionMapper leccionMapper)
    {
        this.leccionRepository = leccionRepository;
        this.leccionMapper = leccionMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LeccionDto> obtenerLeccionesDeUnCurso(Long cursoId)
    {
        List<Leccion> lecciones = leccionRepository.findAllByCurso_Id(cursoId);
        return leccionMapper.toDto(lecciones);
    }

    @Override
    public LeccionDto crearLeccion(Long cursoId, LeccionDto leccionDto)
    {
        leccionDto.setCursoId(cursoId);
        Leccion leccion = leccionMapper.toEntity(leccionDto);
        leccion = leccionRepository.save(leccion);
        return leccionMapper.toDto(leccion);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LeccionDto> obtenerLeccionDeUnCurso(Long cursoId, Long leccionId)
    {
        return leccionRepository
                .findOneByIdAndCurso_Id(leccionId, cursoId)
                .map(leccionMapper::toDto);
    }
}
