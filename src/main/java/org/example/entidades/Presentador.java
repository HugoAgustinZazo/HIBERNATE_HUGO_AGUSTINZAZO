package org.example.entidades;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "Presentador")
public  class Presentador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column (name = "DNI",unique = true)
    String dni;

    @Column (name = "NOMBRE", length = 20)
    String name;

    @Column (name = "APELLIDO", length = 30)
    String surname;

    @Column (name = "AÑO")
    int year;

    @OneToMany(mappedBy = "presentator",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Evento> events;


    public Presentador(String dni, String name, String surname, int year) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Presentador(){

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "=============Presentador=============\nDNI: "+dni+"\nName: "+name+"\nSurname: "+surname+"\nYear: "+year+"\n======================================";    }
}
