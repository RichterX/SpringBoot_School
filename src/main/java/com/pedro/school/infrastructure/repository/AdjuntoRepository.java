package com.pedro.school.infrastructure.repository;

import com.pedro.school.domain.entity.Adjunto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdjuntoRepository extends JpaRepository<Adjunto, Long>
{
}
