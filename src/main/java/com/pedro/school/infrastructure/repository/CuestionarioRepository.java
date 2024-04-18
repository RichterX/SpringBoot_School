package com.pedro.school.infrastructure.repository;

import com.pedro.school.domain.entity.Cuestionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuestionarioRepository extends JpaRepository<Cuestionario, Long>
{
}
