package com.pedro.school.application.services;

import com.pedro.school.application.dto.ProfesorDto;

import java.util.List;
import java.util.Optional;

public interface ProfesorService
{
    List<ProfesorDto> obtenerProfesores();
    Optional<ProfesorDto> obtenerProfesorPorId(Long profesorId);
    ProfesorDto crearProfesor(ProfesorDto profesor);
}
