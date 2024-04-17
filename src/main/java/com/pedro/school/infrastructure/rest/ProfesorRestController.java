package com.pedro.school.infrastructure.rest;

import com.pedro.school.application.dto.ProfesorDto;
import com.pedro.school.application.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesorRestController
{
    private final ProfesorService profesorService;

    @Autowired
    public ProfesorRestController(ProfesorService profesorService)
    {
        this.profesorService = profesorService;
    }

    @GetMapping(value = "/profesores", produces = "application/json")
    public ResponseEntity<List<ProfesorDto>> obtenerProfesores()
    {
        var profesores = profesorService.obtenerProfesores();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    @GetMapping(value = "/profesores/{profesorId}", produces = "application/json")
    public ResponseEntity<ProfesorDto> obtenerProfesor(@PathVariable Long profesorId)
    {
        return profesorService
                .obtenerProfesorPorId(profesorId)
                .map(profesorDto -> new ResponseEntity<>(profesorDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/profesores", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ProfesorDto> crearProfesor(@RequestBody ProfesorDto profesorDto)
    {
        profesorDto = profesorService.crearProfesor(profesorDto);
        return new ResponseEntity<>(profesorDto, HttpStatus.CREATED);
    }
}
