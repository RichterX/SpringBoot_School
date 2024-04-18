package com.pedro.school.application.services.impl;

import com.pedro.school.application.dto.PreguntaDto;
import com.pedro.school.application.mapper.PreguntaMapper;
import com.pedro.school.application.services.PreguntaService;
import com.pedro.school.domain.entity.Cuestionario;
import com.pedro.school.domain.entity.Pregunta;
import com.pedro.school.infrastructure.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaServiceImpl implements PreguntaService
{
    public final PreguntaRepository preguntaRepository;
    public final PreguntaMapper preguntaMapper;

    @Autowired
    public PreguntaServiceImpl(PreguntaRepository preguntaRepository, PreguntaMapper preguntaMapper)
    {
        this.preguntaRepository = preguntaRepository;
        this.preguntaMapper = preguntaMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PreguntaDto> obtenerPreguntas()
    {
        List<Pregunta> preguntas = preguntaRepository.findAll();
        return preguntaMapper.toDto(preguntas);
    }

    @Override
    @Transactional
    public PreguntaDto crearPregunta(PreguntaDto preguntaDto)
    {
        Pregunta pregunta = preguntaMapper.toEntity(preguntaDto);
        pregunta = preguntaRepository.save(pregunta);
        return preguntaMapper.toDto(pregunta);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PreguntaDto> obtenerPreguntaPorId(Long preguntaId)
    {
        return preguntaRepository
                .findById(preguntaId)
                .map(preguntaMapper::toDto);
    }
}
