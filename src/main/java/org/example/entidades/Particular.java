package org.example.entidades;

public class Particular extends Cliente{

    String dni;
    String name;
    String surname;


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
        return "DNI: "+dni+" Name "+name+" Surname "+surname+" {City "+city+" Street "+street+" Village "+village+" Phone Number"+phone_number+"}";
    }
}
