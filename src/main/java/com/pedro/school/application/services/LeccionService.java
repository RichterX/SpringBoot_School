package com.pedro.school.application.services;

import com.pedro.school.application.dto.LeccionDto;

import java.util.List;
import java.util.Optional;

public interface LeccionService
{
    List<LeccionDto> obtenerLeccionesDeUnCurso(Long cursoId);
    LeccionDto crearLeccion(Long cursoId, LeccionDto leccionDto);
    Optional<LeccionDto> obtenerLeccionDeUnCurso(Long cursoId, Long leccionId);
}
