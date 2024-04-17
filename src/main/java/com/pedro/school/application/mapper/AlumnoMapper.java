package com.pedro.school.application.mapper;

import com.pedro.school.application.dto.AlumnoDto;
import com.pedro.school.domain.entity.Alumno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlumnoMapper extends EntityMapper<AlumnoDto, Alumno>
{
}
