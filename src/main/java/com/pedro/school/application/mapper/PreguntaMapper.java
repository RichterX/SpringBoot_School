package com.pedro.school.application.mapper;

import com.pedro.school.application.dto.PreguntaDto;
import com.pedro.school.domain.entity.Pregunta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PreguntaMapper extends EntityMapper<PreguntaDto, Pregunta>
{
    default Pregunta fromId(Long id)
    {
        if (id == null) return null;
        Pregunta pregunta = new Pregunta();
        pregunta.setId(id);
        return pregunta;
    }
}
