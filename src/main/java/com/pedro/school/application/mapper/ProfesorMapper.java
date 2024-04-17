package com.pedro.school.application.mapper;

import com.pedro.school.application.dto.ProfesorDto;
import com.pedro.school.domain.entity.Profesor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfesorMapper extends EntityMapper<ProfesorDto, Profesor>
{
    default Profesor fromId(Long id)
    {
        if (id == null) return null;
        Profesor profesor = new Profesor();
        profesor.setId(id);
        return profesor;
    }
}
