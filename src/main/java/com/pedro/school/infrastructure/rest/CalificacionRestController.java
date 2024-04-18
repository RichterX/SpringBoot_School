package com.pedro.school.infrastructure.rest;

import com.pedro.school.application.dto.CalificacionDto;
import com.pedro.school.application.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos/{alumnoId}")
public class CalificacionRestController
{

    private final CalificacionService calificacionService;

    @Autowired
    public CalificacionRestController(CalificacionService calificacionService)
    {
        this.calificacionService = calificacionService;
    }

    @GetMapping(value = "/calificaciones", produces = "application/json")
    public ResponseEntity<List<CalificacionDto>> obtenerCalificaciones(@PathVariable Long alumnoId)
    {
        var calificaciones = calificacionService.obtenerCalificacionesDeUnAlumno(alumnoId);
        return new ResponseEntity<>(calificaciones, HttpStatus.OK);
    }

    @GetMapping(value = "/calificaciones/{calificacionId}", produces = "application/json")
    public ResponseEntity<CalificacionDto> obtenerCalificacion(@PathVariable Long alumnoId, @PathVariable Long calificacionId)
    {
        return calificacionService
                .obtenerCalificacionDeUnAlumno(alumnoId, calificacionId)
                .map(calificacionDto -> new ResponseEntity<>(calificacionDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/calificaciones", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<CalificacionDto>> crearCalificacion(@PathVariable Long alumnoId,
                                                                   @RequestBody CalificacionDto calificacionDto)
    {
        List<CalificacionDto> calificaciones = calificacionService.crearCalificacionDeAlumno(alumnoId, calificacionDto);
        return new ResponseEntity<>(calificaciones, HttpStatus.CREATED);
    }

}
