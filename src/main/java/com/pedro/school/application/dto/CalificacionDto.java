package com.pedro.school.application.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CalificacionDto implements Serializable
{

    private Long id;
    private Integer nota;
    private Date fechaCalificacion;
    private Long cuestionarioId;
    private String cuestionarioTitulo;
    private Long alumnoId;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getNota()
    {
        return nota;
    }

    public void setNota(Integer nota)
    {
        this.nota = nota;
    }

    public Date getFechaCalificacion()
    {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(Date fechaCalificacion)
    {
        this.fechaCalificacion = fechaCalificacion;
    }

    public Long getCuestionarioId()
    {
        return cuestionarioId;
    }

    public void setCuestionarioId(Long cuestionarioId)
    {
        this.cuestionarioId = cuestionarioId;
    }

    public String getCuestionarioTitulo()
    {
        return cuestionarioTitulo;
    }

    public void setCuestionarioTitulo(String cuestionarioTitulo)
    {
        this.cuestionarioTitulo = cuestionarioTitulo;
    }

    public Long getAlumnoId()
    {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId)
    {
        this.alumnoId = alumnoId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, nota, fechaCalificacion);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CalificacionDto entity = (CalificacionDto) obj;
        return Objects.equals(this.id, entity.id) && Objects.equals(this.nota, entity.nota) && Objects.equals(this.fechaCalificacion, entity.fechaCalificacion);
    }
}
