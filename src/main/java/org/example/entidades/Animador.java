package org.example.entidades;

import jakarta.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
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

    public Animador(int id, String dni, String name, String surname) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
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
