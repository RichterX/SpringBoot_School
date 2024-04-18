package com.pedro.school.application.services.impl;

import com.pedro.school.application.dto.AlumnoDto;
import com.pedro.school.application.dto.CalificacionDto;
import com.pedro.school.application.dto.CursoSimpleDto;
import com.pedro.school.application.mapper.AlumnoMapper;
import com.pedro.school.application.services.AlumnoService;
import com.pedro.school.domain.entity.Alumno;
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

    @Override
    public void eliminarAlumnoPorId(Long alumnoId)
    {
        alumnoRepository.deleteById(alumnoId);
    }

    @Override
    @Transactional
    public List<CursoSimpleDto> registrarAlumnoEnCurso(Long alumnoId, CursoSimpleDto cursoSimpleDto)
    {
        AlumnoDto alumnoDto = obtenerAlumnoPorId(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        alumnoDto.getCursos().add(cursoSimpleDto);
        Alumno alumno = alumnoRepository.save(alumnoMapper.toEntity(alumnoDto));

        alumnoDto = alumnoMapper.toDto(alumno);
        return alumnoDto.getCursos();
    }

    @Override
    @Transactional
    public void eliminarCursoDeAlumno(Long alumnoId, Long cursoId)
    {
        Alumno alumno = alumnoRepository
                .findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        alumno.eliminarCursoPorId(cursoId);
        alumnoRepository.save(alumno);
    }

    @Override
    public AlumnoDto anadirCalificacion(Long alumnoId, CalificacionDto calificacionDto)
    {
        AlumnoDto alumnoDto = obtenerAlumnoPorId(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        alumnoDto.getCalificaciones().add(calificacionDto);
        Alumno alumno = alumnoRepository.save(alumnoMapper.toEntity(alumnoDto));
        return alumnoMapper.toDto(alumno);
    }
}
