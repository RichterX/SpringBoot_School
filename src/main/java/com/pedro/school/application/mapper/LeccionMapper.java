package com.pedro.school.application.mapper;

import com.pedro.school.application.dto.LeccionDto;
import com.pedro.school.domain.entity.Leccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CursoMapper.class, ProfesorMapper.class})
public interface LeccionMapper extends EntityMapper<LeccionDto, Leccion>
{
    @Override
    @Mapping(source = "cursoId", target = "curso")
    @Mapping(source = "profesorId", target = "profesor")
    Leccion toEntity(LeccionDto dto);

    @Override
    @Mapping(source = "curso.id", target = "cursoId") //Extrae de la propiedad Curso de Leccion el id y nombre y lo asigna a cursoId y cursoNombre
    @Mapping(source = "curso.nombre", target = "cursoNombre")
    @Mapping(source = "profesor.id", target = "profesorId")
    @Mapping(source = "profesor.nombre", target= "profesorNombre")
    LeccionDto toDto(Leccion entity);
}
