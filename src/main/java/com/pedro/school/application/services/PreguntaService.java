package com.pedro.school.application.services;

import com.pedro.school.application.dto.PreguntaDto;

import java.util.List;
import java.util.Optional;

public interface PreguntaService
{
    List<PreguntaDto> obtenerPreguntas();
    PreguntaDto crearPregunta (PreguntaDto preguntaDto);

    Optional<PreguntaDto> obtenerPreguntaPorId(Long preguntaId);
}
