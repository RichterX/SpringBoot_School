package com.pedro.school.infrastructure.repository;

import com.pedro.school.domain.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long>
{
}
