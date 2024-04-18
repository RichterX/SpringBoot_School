package com.pedro.school.application.dto;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CuestionarioDto implements Serializable
{
    private Long id;
    private String titulo;
    private Integer notaMinima;
    private List<PreguntaCuestionarioDto> preguntas;

    public CuestionarioDto() { }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public Integer getNotaMinima()
    {
        return notaMinima;
    }
    public void setNotaMinima(Integer nota_minima)
    {
        this.notaMinima = nota_minima;
    }
    public String getTitulo()
    {
        return titulo;
    }
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public List<PreguntaCuestionarioDto> getPreguntas()
    {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaCuestionarioDto> preguntas)
    {
        this.preguntas = preguntas;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuestionarioDto that = (CuestionarioDto) o;
        return Objects.equals(id, that.id) && Objects.equals(notaMinima, that.notaMinima) && Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, notaMinima, titulo);
    }

    @Override
    public String toString()
    {
        return "CuestionarioDto{" +
                "id=" + id +
                ", nota_minima=" + notaMinima +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
