package com.pedro.school.application.services.impl;

import com.pedro.school.application.dto.AlumnoDto;
import com.pedro.school.application.mapper.AlumnoMapper;
import com.pedro.school.application.services.AlumnoService;
import com.pedro.school.infrastructure.repository.AlumnoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService
{
    AlumnoRepository alumnoRepository;
    AlumnoMapper alumnoMapper;

    @Autowired
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper)
    {
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AlumnoDto> obtenerAlumnos()
    {
        var alumnos = alumnoRepository.findAll();
        return alumnoMapper.toDto(alumnos);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AlumnoDto> obtenerAlumnoPorId(Long id)
    {
        return alumnoRepository
                .findById(id)
                .map(alumnoMapper::toDto);
    }

    @Override
    @Transactional
    public AlumnoDto crearAlumno(AlumnoDto alumnoDto)
    {
        var alumno = alumnoMapper.toEntity(alumnoDto);
        alumno = alumnoRepository.save(alumno);
        return alumnoMapper.toDto(alumno);
    }
}
