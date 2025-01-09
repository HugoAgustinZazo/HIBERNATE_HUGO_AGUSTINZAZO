package org.example.entidades;

public class Empresa extends Cliente{

    String cif;
    String contact;
    String name;

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CIF: "+cif+" Contact "+contact+" Name "+name+" {City "+city+" Street "+street+" Village "+village+" Phone Number"+phone_number+"}";
    }
}
