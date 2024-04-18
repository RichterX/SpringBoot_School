package com.pedro.school.infrastructure.repository;

import com.pedro.school.domain.entity.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CalificacionRespository extends JpaRepository<Calificacion, Long>
{
    List<Calificacion> findByAlumno_id(Long id);

    Optional<Calificacion> findOneByIdAndAlumno_id(Long calificacionId, Long alumnoId);
}
