package com.pedro.school.application.mapper;

import com.pedro.school.application.dto.AdjuntoDto;
import com.pedro.school.domain.entity.Adjunto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdjuntoMapper extends EntityMapper<AdjuntoDto, Adjunto>
{
}
