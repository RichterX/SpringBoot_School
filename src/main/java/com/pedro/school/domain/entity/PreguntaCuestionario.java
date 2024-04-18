package com.pedro.school.domain.entity;

import com.pedro.school.domain.key.PreguntaCuestionarioKey;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cuestionarios_preguntas")
public class PreguntaCuestionario
{
    @EmbeddedId
    private PreguntaCuestionarioKey id;

    @ManyToOne
    @MapsId("cuestionarioId")
    @JoinColumn(name = "cuestionario_id")
    private Cuestionario cuestionario;

    @ManyToOne
    @MapsId("preguntaId")
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;

    @Column(name = "orden")
    private Integer orden;

    public PreguntaCuestionarioKey getId()
    {
        return id;
    }

    public void setId(PreguntaCuestionarioKey id)
    {
        this.id = id;
    }

    public Cuestionario getCuestionario()
    {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario)
    {
        this.cuestionario = cuestionario;
    }

    public Pregunta getPregunta()
    {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta)
    {
        this.pregunta = pregunta;
    }

    public Integer getOrden()
    {
        return orden;
    }

    public void setOrden(Integer orden)
    {
        this.orden = orden;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass() || id == null) return false;
        PreguntaCuestionario that = (PreguntaCuestionario) obj;
        return id.equals(that.id);
    }
}
