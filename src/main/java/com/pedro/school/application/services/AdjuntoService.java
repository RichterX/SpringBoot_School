package com.pedro.school.application.services;

import com.pedro.school.application.dto.AdjuntoDto;
import com.pedro.school.application.dto.AlumnoDto;
import com.pedro.school.application.dto.CalificacionDto;
import com.pedro.school.application.dto.CursoSimpleDto;

import java.util.List;
import java.util.Optional;

public interface AdjuntoService
{
    List<AdjuntoDto> obtenerAdjuntos();
    Optional<AdjuntoDto> obtenerAdjuntoPorId(Long id);
    AdjuntoDto crearAdjunto (AdjuntoDto adjuntoDto);
}
