package com.pedro.school.infrastructure.repository;

import com.pedro.school.domain.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> //Especificamos como parámetro entidad y el tipo de dato del id
{

}
