package com.pedro.school.application.services;

import com.pedro.school.application.dto.CursoDto;

import java.util.List;
import java.util.Optional;

public interface CursoService
{
    List<CursoDto> obtenerCursos();
    Optional<CursoDto> obtenerCursoPorId(Long id); //Es Optional cuando puede que no exista un curso
    CursoDto crearCurso (CursoDto cursoDto);
    void eliminarCursoPorId(Long id);
}
