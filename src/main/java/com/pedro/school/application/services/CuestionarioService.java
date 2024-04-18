package com.pedro.school.application.services;

import com.pedro.school.application.dto.CuestionarioDto;
import com.pedro.school.application.dto.PreguntaCuestionarioDto;
import com.pedro.school.application.dto.PreguntaDto;

import java.util.List;
import java.util.Optional;

public interface CuestionarioService
{
    List<CuestionarioDto> obtenerCuestionarios();
    Optional<CuestionarioDto> obtenerCuestionario(Long cuestionarioId);
    CuestionarioDto crearCuestionario (CuestionarioDto cuestionarioDto);

    Optional<CuestionarioDto> obtenerCuestionarioPorId(Long cuestionarioId);

    List<PreguntaCuestionarioDto> anadePreguntaEnCuestionario(Long cuestionarioId, PreguntaCuestionarioDto preguntaCuestionarioDto);

    List<PreguntaCuestionarioDto> obtenerPreguntasDeCuestionario(Long cuestionarioId);
}
