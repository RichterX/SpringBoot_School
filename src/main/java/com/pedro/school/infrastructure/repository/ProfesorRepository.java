package com.pedro.school.infrastructure.repository;

import com.pedro.school.domain.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long>
{
}
