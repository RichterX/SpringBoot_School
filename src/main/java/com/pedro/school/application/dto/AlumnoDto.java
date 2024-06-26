package com.pedro.school.application.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AlumnoDto implements Serializable //Implementa Serializable para poder serializar el objeto de Json a Dto
{

    private Long id;
    private String nombre;
    private String url;
    private List<CursoSimpleDto> cursos;
    private List<CalificacionDto> calificaciones;


    public AlumnoDto() { }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public List<CursoSimpleDto> getCursos()
    {
        return cursos;
    }

    public void setCursos(List<CursoSimpleDto> cursos)
    {
        this.cursos = cursos;
    }

    public List<CalificacionDto> getCalificaciones()
    {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionDto> calificaciones)
    {
        this.calificaciones = calificaciones;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoDto alumnoDto = (AlumnoDto) o;
        return Objects.equals(id, alumnoDto.id) && Objects.equals(nombre, alumnoDto.nombre) && Objects.equals(url, alumnoDto.url);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, nombre, url);
    }

    @Override
    public String toString()
    {
        return "AlumnoDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
