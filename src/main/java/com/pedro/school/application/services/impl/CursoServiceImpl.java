package com.pedro.school.application.services.impl;

import com.pedro.school.application.dto.CursoDto;
import com.pedro.school.application.mapper.CursoMapper;
import com.pedro.school.application.services.CursoService;
import com.pedro.school.domain.entity.Curso;
import com.pedro.school.infrastructure.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;
@Service
public class CursoServiceImpl implements CursoService
{

    private final CursoRepository cursoRepository; //Ojo, esto es una interfaz.
    private final CursoMapper cursoMapper;

    @Autowired
    public CursoServiceImpl (CursoRepository cursoRepository, CursoMapper cursoMapper)
    {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CursoDto> obtenerCursos()
    {
        List<Curso> cursos = cursoRepository.findAll();
        return cursoMapper.toDto(cursos);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CursoDto> obtenerCursoPorId(Long id)
    {
        return cursoRepository
                .findById(id)
                .map(curso -> cursoMapper.toDto(curso)); //map solamente se activa si encuentra un curso. Si no encontrara, devolvería un objeto de tipo empty
    }

    @Override
    @Transactional
    public CursoDto crearCurso(CursoDto cursoDto)
    {
        Curso curso = cursoMapper.toEntity(cursoDto);
        curso = cursoRepository.save(curso);
        return cursoMapper.toDto(curso);
    }

    @Override
    @Transactional
    public void eliminarCursoPorId(Long id)
    {
        cursoRepository.deleteById(id);

    }
}
