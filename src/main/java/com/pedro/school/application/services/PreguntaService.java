package com.pedro.school.application.services;

import com.pedro.school.application.dto.AlumnoDto;
import com.pedro.school.application.dto.CuestionarioDto;
import com.pedro.school.application.dto.PreguntaDto;
import com.pedro.school.domain.entity.Pregunta;

import java.util.List;
import java.util.Optional;

public interface PreguntaService
{
    List<PreguntaDto> obtenerPreguntas();
    Optional<PreguntaDto> obtenerPregunta(Long preguntaId);
    PreguntaDto crearPregunta (PreguntaDto preguntaDto);

    Optional<PreguntaDto> obtenerPreguntaPorId(Long preguntaId);
}
