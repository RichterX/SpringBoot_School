package com.pedro.school.application.services;

import com.pedro.school.application.dto.AlumnoDto;
import com.pedro.school.application.dto.CursoDto;

import java.util.List;
import java.util.Optional;

public interface AlumnoService
{
    List<AlumnoDto> obtenerAlumnos();
    Optional<AlumnoDto> obtenerAlumnoPorId(Long id);
    AlumnoDto crearAlumno (AlumnoDto alumnoDto);
}
