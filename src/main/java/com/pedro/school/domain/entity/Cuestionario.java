package com.pedro.school.domain.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cuestionarios")
public class Cuestionario
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHOOL_SEQUENCE")
    @SequenceGenerator(name = "SCHOOL_SEQUENCE")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "nota_minima", nullable = false)
    private Integer notaMinima;

    @OneToMany(mappedBy = "cuestionario", cascade = CascadeType.ALL)
    private Set<PreguntaCuestionario> preguntas; //En las entidades como tal, siempre usamos Set para que no haya duplicados

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

    public void setNotaMinima(Integer notaMinima)
    {
        this.notaMinima = notaMinima;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public Set<PreguntaCuestionario> getPreguntas()
    {
        return preguntas;
    }

    public void setPreguntas(Set<PreguntaCuestionario> preguntas)
    {
        this.preguntas = preguntas;
    }
}
