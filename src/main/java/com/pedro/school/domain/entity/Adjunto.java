package com.pedro.school.domain.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="adjuntos")
public class Adjunto
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SCHOOL_SEQUENCE")
    @SequenceGenerator(name = "SCHOOL_SEQUENCE")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "mime_type", nullable = false, length = 255)
    private String mimeType;

    @Lob()
    @Column(name="contenido")
    private byte[] contenido;

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

    public String getMimeType()
    {
        return mimeType;
    }

    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    public byte[] getContenido()
    {
        return contenido;
    }

    public void setContenido(byte[] contenido)
    {
        this.contenido = contenido;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || id == null) return false;
        Adjunto adjunto = (Adjunto) o;
        return id.equals(adjunto.id);
    }

}
