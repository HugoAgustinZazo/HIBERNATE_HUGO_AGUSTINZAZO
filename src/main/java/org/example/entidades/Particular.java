package org.example.entidades;

import jakarta.persistence.*;

@Entity
public class Particular extends Cliente{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    @Column (name = "DNI",unique = true)
    String dni;
    @Column (name = "NOMBRE")
    String name;
    @Column (name = "APELLIDO")
    String surname;

    public Particular( String city, String street, String village, String phone_number, String dni, String name, String surname) {
        super(city, street, village, phone_number);
        this.dni = dni;
        this.name = name;
        this.surname = surname;
    }

    public Particular(){
    }

    @Override
    public void info() {

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
        return "=============Particular=============\nDNI: "+dni+"\nName: "+name+"\nSurname: "+surname+"\nCity: "+city+"\nStreet: "+street+"\nVillage: "+village+"\nPhone Number: "+phone_number+"\n====================================";
    }
}
