package com.pedro.school.domain.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "alumnos")
public class Alumno
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHOOL_SEQUENCE")
    @SequenceGenerator(name = "SCHOOL_SEQUENCE")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;

    @Column(name = "URL", nullable = true, length = 255)
    private String url;

    @ManyToMany
    @JoinTable( //Con esta anotación, le indicamos que cree una tabla intermedia, que cree la llave primaria de esta tabla y la llave primaria de la otra tabla
            name = "alumnos_cursos",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    ) //En el otro lado de la relación (clase Curso), le hacemos un mappedby = "cursos" con el mismo nombre de la variable
    private Set<Curso> cursos;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    Set<Calificacion> calificaciones;


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

    public Set<Curso> getCursos()
    {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos)
    {
        this.cursos = cursos;
    }

    public Set<Calificacion> getCalificaciones()
    {
        return calificaciones;
    }

    public void setCalificaciones(Set<Calificacion> calificaciones)
    {
        this.calificaciones = calificaciones;
    }

    public void eliminarCursoPorId(Long cursoId)
    {
        if (cursoId == null) return;
        for (Curso c : this.getCursos())
        {
            if(cursoId.equals(c.getId()))
            {
                this.cursos.remove(c);
                break;
            }
        }
    }
}
