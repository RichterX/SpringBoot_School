package com.pedro.school.application.services;

import com.pedro.school.application.dto.AlumnoDto;
import com.pedro.school.application.dto.CalificacionDto;
import com.pedro.school.application.dto.CursoDto;
import com.pedro.school.application.dto.CursoSimpleDto;

import java.util.List;
import java.util.Optional;

public interface AlumnoService
{
    List<AlumnoDto> obtenerAlumnos();

    Optional<AlumnoDto> obtenerAlumnoPorId(Long id);

    AlumnoDto crearAlumno(AlumnoDto alumnoDto);

    void eliminarAlumnoPorId(Long id);

    List<CursoSimpleDto> registrarAlumnoEnCurso(Long alumnoId, CursoSimpleDto cursoSimpleDto);

    void eliminarCursoDeAlumno(Long alumnoId, Long cursoId);

    AlumnoDto anadirCalificacion(Long alumnoId, CalificacionDto calificacionDto);
}
