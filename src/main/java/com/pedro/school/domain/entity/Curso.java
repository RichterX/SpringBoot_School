package com.pedro.school.domain.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "CURSOS")
public class Curso
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHOOL_SEQUENCE")
    @SequenceGenerator(name = "SCHOOL_SEQUENCE")
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;

    @Column(name="Resumen", nullable = false, length = 2000)
    private String resumen;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    Set<Leccion> lecciones;

    @ManyToMany (mappedBy = "cursos", cascade = CascadeType.ALL) //Al otro lado de esta anotación, creo una tabla intermedia, que cree la llave primaria de esta tabla y la llave primaria de la otra tabla
    Set<Alumno> alumnos;


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

    public String getResumen()
    {
        return resumen;
    }

    public void setResumen(String resumen)
    {
        this.resumen = resumen;
    }

    public Set<Leccion> getLecciones()
    {
        return lecciones;
    }

    public void setLecciones(Set<Leccion> lecciones)
    {
        this.lecciones = lecciones;
        this.lecciones.forEach(leccion -> leccion.setCurso(this));
    }

    public Set<Alumno> getAlumnos()
    {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos)
    {
        this.alumnos = alumnos;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || id == null) return false;
        Curso curso = (Curso) o;
        return id.equals(curso.id);
    }
}
