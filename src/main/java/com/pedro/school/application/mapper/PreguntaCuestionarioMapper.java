package com.pedro.school.application.mapper;

import com.pedro.school.application.dto.PreguntaCuestionarioDto;
import com.pedro.school.domain.entity.PreguntaCuestionario;
import com.pedro.school.domain.key.PreguntaCuestionarioKey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CuestionarioMapper.class, PreguntaMapper.class})
public interface PreguntaCuestionarioMapper extends EntityMapper<PreguntaCuestionarioDto, PreguntaCuestionario>
{

    @Override
    @Mapping(source="cuestionarioId", target="cuestionario")
    @Mapping(source="preguntaId", target="pregunta")
    PreguntaCuestionario toEntity(PreguntaCuestionarioDto dto);

    @Override
    @Mapping(source="cuestionario.id", target="cuestionarioId")
    @Mapping(source="cuestionario.titulo", target="cuestionarioTitulo")
    @Mapping(source="pregunta.id", target="preguntaId")
    @Mapping(source="pregunta.pregunta", target="preguntaPregunta")
    PreguntaCuestionarioDto toDto(PreguntaCuestionario entity);

    default PreguntaCuestionario fromId(PreguntaCuestionarioKey id)
    {
        if (id == null) return null;

        PreguntaCuestionario preguntaCuestionario = new PreguntaCuestionario();
        preguntaCuestionario.setId(id);
        return preguntaCuestionario;
    }
}
