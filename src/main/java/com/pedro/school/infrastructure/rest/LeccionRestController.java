package com.pedro.school.infrastructure.rest;

import com.pedro.school.application.dto.AdjuntoDto;
import com.pedro.school.application.dto.LeccionDto;
import com.pedro.school.application.services.LeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/cursos/{cursoId}")
public class LeccionRestController
{
    private final LeccionService leccionService;

    @Autowired
    public LeccionRestController(LeccionService leccionService)
    {
        this.leccionService = leccionService;
    }

    @GetMapping(value = "/lecciones", produces = "application/json")
    public ResponseEntity<List<LeccionDto>> obtenerLeccionesDeCurso(@PathVariable Long cursoId)
    {
        List<LeccionDto> leccionDtos = leccionService.obtenerLeccionesDeUnCurso(cursoId);
        return new ResponseEntity<>(leccionDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/lecciones/{leccionId}", produces = "application/json")
    public ResponseEntity<LeccionDto> obtenerLeccion(@PathVariable Long cursoId, @PathVariable Long leccionId)
    {
        return leccionService
                .obtenerLeccionDeUnCurso(cursoId, leccionId)
                .map(leccionDto -> new ResponseEntity(leccionDto, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/lecciones", produces = "application/json", consumes = "application/json")
    public ResponseEntity<LeccionDto> crearLeccionEnCurso(@PathVariable Long cursoId, @RequestBody LeccionDto leccionDto)
    {
        leccionDto = leccionService.crearLeccion(cursoId, leccionDto);
        return new ResponseEntity<>(leccionDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/lecciones/{leccionId}/adjuntos", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<AdjuntoDto>> anadirAdjuntoEnLeccion(@PathVariable Long cursoId,
                                                                   @PathVariable Long leccionId,
                                                                   @RequestBody AdjuntoDto adjuntoDto)
    {
        List<AdjuntoDto> adjuntos = leccionService.adjuntarFichero(cursoId, leccionId, adjuntoDto);
        return new ResponseEntity<>(adjuntos, HttpStatus.OK);
    }
}
