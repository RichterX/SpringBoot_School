package com.pedro.school.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name="profesores")
public class Profesor
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHOOL_SEQUENCE")
    @SequenceGenerator(name = "SCHOOL_SEQUENCE")
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 255)
    private String nombre;

    @Column(name = "NUMERO_TELEFONO", nullable = true, length = 15)
    private String numeroTelefono;

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

    public String getNumeroTelefono()
    {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono)
    {
        this.numeroTelefono = numeroTelefono;
    }
}
