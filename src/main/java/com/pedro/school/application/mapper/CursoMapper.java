package com.pedro.school.application.mapper;

import com.pedro.school.application.dto.CursoDto;
import com.pedro.school.domain.entity.Curso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LeccionMapper.class}) //Le indicamos que estamos trabajando con Spring
public interface CursoMapper extends EntityMapper<CursoDto, Curso>
{
    default Curso fromId(Long id) {
        if (id == null) return null;
        Curso curso = new Curso();
        curso.setId(id);
        return curso;
    }
}
