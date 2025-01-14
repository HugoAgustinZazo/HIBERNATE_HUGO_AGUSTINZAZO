package org.example.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Animador")
public class Animador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "DNI", unique = true)
    String dni;

    @Column(name = "NOMBRE")
    String name;

    @Column(name = "APELLIDO")
    String surname;

    @ManyToOne
    @JoinColumn(name = "DISFRAZ")
    private Disfraz disfraz;

    @ManyToMany(mappedBy = "animadores")
    private List<Evento>eventos;

    public Animador(int id, String dni, String name, String surname, Disfraz disfraz_id, List<Evento> eventos) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.surname = surname;

        this.disfraz = disfraz_id;
        this.eventos = eventos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Disfraz getDisfraz() {
        return disfraz;
    }

    public void setDisfraz(Disfraz disfraz) {
        this.disfraz = disfraz;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public Animador(){

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Animador{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
