package com.pedro.school.infrastructure.repository;

import com.pedro.school.domain.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>
{
}
