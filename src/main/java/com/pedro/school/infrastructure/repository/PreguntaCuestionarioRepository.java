package com.pedro.school.infrastructure.repository;

import com.pedro.school.domain.entity.PreguntaCuestionario;
import com.pedro.school.domain.key.PreguntaCuestionarioKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaCuestionarioRepository extends JpaRepository<PreguntaCuestionario, PreguntaCuestionarioKey>
{
}
