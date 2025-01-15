package org.example.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Animador")
public class Animador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "DNI", unique = true,nullable = false)
    String dni;

    @Column(name = "NOMBRE")
    String name;

    @Column(name = "APELLIDO")
    String surname;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "DISFRAZ")
    private Disfraz costume;

    @ManyToMany(mappedBy = "entertainers")
    private List<Evento>events;

    public Animador() {
    }

    public Animador(String dni, String name, String surname, Disfraz costume_id) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.costume = costume_id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Disfraz getCostume() {
        return costume;
    }

    public void setCostume(Disfraz costume) {
        this.costume = costume;
    }

    public List<Evento> getEvents() {
        return events;
    }

    public void setEvents(List<Evento> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "=============Animador=============\nDNI: "+dni+"\nName: "+name+"\nSurname: "+surname+"\n==================================";
    }
}
