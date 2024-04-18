package com.pedro.school.application.services.impl;

import com.pedro.school.application.dto.AlumnoDto;
import com.pedro.school.application.dto.CalificacionDto;
import com.pedro.school.application.mapper.CalificacionMapper;
import com.pedro.school.application.services.AlumnoService;
import com.pedro.school.application.services.CalificacionService;
import com.pedro.school.domain.entity.Calificacion;

import com.pedro.school.infrastructure.repository.CalificacionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServiceImpl implements CalificacionService
{
    private final CalificacionRespository calificacionRepository;
    private final CalificacionMapper calificacionMapper;
    private final AlumnoService alumnoService;

    @Autowired
    public CalificacionServiceImpl(CalificacionRespository calificacionRepository,
                                   CalificacionMapper calificacionMapper,
                                   AlumnoService alumnoService)
    {
        this.calificacionRepository = calificacionRepository;
        this.calificacionMapper = calificacionMapper;
        this.alumnoService = alumnoService;
    }


    @Override
    @Transactional(readOnly = true)
    public List<CalificacionDto> obtenerCalificacionesDeUnAlumno(Long alumnoId)
    {
        List<Calificacion> calificaciones = calificacionRepository.findByAlumno_id(alumnoId);
        return calificacionMapper.toDto(calificaciones);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CalificacionDto> obtenerCalificacionDeUnAlumno(Long alumnoId, Long calificacionId)
    {
        return calificacionRepository
                .findOneByIdAndAlumno_id(calificacionId, alumnoId)
                .map(calificacionMapper::toDto);
    }

    @Override
    @Transactional
    public List<CalificacionDto> crearCalificacionDeAlumno(Long alumnoId, CalificacionDto calificacionDto)
    {
        calificacionDto.setAlumnoId(alumnoId);
        AlumnoDto alumnoDto = alumnoService.anadirCalificacion(alumnoId, calificacionDto);
        return alumnoDto.getCalificaciones();
    }
}
