package com.pedro.school.application.services.impl;

import com.pedro.school.application.dto.ProfesorDto;
import com.pedro.school.application.mapper.ProfesorMapper;
import com.pedro.school.application.services.ProfesorService;
import com.pedro.school.infrastructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService
{
    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;

    @Autowired
    public ProfesorServiceImpl(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper)
    {
        this.profesorRepository = profesorRepository;
        this.profesorMapper = profesorMapper;
    }
    @Override
    public List<ProfesorDto> obtenerProfesores()
    {
        var profesores = profesorRepository.findAll();
        return profesorMapper.toDto(profesores);
    }

    @Override
    public Optional<ProfesorDto> obtenerProfesorPorId(Long profesorId)
    {
        return profesorRepository
                .findById(profesorId)
                .map(profesorMapper::toDto);
    }

    @Override
    public ProfesorDto crearProfesor(ProfesorDto profesorDto)
    {
        var profesor = profesorMapper.toEntity(profesorDto);
        profesor = profesorRepository.save(profesor);
        return profesorMapper.toDto(profesor);
    }
}
