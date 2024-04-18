package com.pedro.school.application.services.impl;

import com.pedro.school.application.dto.CuestionarioDto;
import com.pedro.school.application.dto.PreguntaCuestionarioDto;
import com.pedro.school.application.mapper.CuestionarioMapper;
import com.pedro.school.application.services.CuestionarioService;
import com.pedro.school.domain.entity.Cuestionario;
import com.pedro.school.infrastructure.repository.CuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CuestionarioServiceImpl implements CuestionarioService
{
    public final CuestionarioRepository cuestionarioRepository;
    public final CuestionarioMapper cuestionarioMapper;

    @Autowired
    public CuestionarioServiceImpl(CuestionarioRepository cuestionarioRepository, CuestionarioMapper cuestionarioMapper)
    {
        this.cuestionarioRepository = cuestionarioRepository;
        this.cuestionarioMapper = cuestionarioMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CuestionarioDto> obtenerCuestionarios()
    {
        List<Cuestionario> cuestionarios = cuestionarioRepository.findAll();
        return cuestionarioMapper.toDto((cuestionarios));
    }

    @Override
    @Transactional
    public CuestionarioDto crearCuestionario(CuestionarioDto cuestionarioDto)
    {
        Cuestionario cuestionario = cuestionarioMapper.toEntity(cuestionarioDto);
        cuestionario = cuestionarioRepository.save(cuestionario);
        return cuestionarioMapper.toDto(cuestionario);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CuestionarioDto> obtenerCuestionarioPorId(Long cuestionarioId)
    {
        return cuestionarioRepository
                .findById(cuestionarioId)
                .map(cuestionarioMapper::toDto);
    }


    @Override
    @Transactional
    public List<PreguntaCuestionarioDto> anadePreguntaEnCuestionario(Long cuestionarioId,
                                                                     PreguntaCuestionarioDto preguntaCuestionarioDto)
    {
        CuestionarioDto cuestionarioDto = obtenerCuestionarioPorId(cuestionarioId)
                .orElseThrow(() -> new RuntimeException("Cuestionario no encontrado"));

        preguntaCuestionarioDto.setCuestionarioId(cuestionarioId);
        cuestionarioDto.getPreguntas().add(preguntaCuestionarioDto);
        Cuestionario cuestionario = cuestionarioRepository.save(cuestionarioMapper.toEntity(cuestionarioDto));
        cuestionarioDto = cuestionarioMapper.toDto(cuestionario);

        return cuestionarioDto.getPreguntas();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PreguntaCuestionarioDto> obtenerPreguntasDeCuestionario(Long cuestionarioId)
    {
        CuestionarioDto cuestionarioDto = obtenerCuestionarioPorId(cuestionarioId)
                .orElseThrow(() -> new RuntimeException("Cuestionario no encontrado")); //Al ser optional, puede que no lo haya encontrado
        return cuestionarioDto.getPreguntas();
    }
}
