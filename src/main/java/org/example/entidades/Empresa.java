package org.example.entidades;


import jakarta.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@Table (name = "Empresa")
public class Empresa extends Cliente{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    @Column (name = "CIF",unique = true)
    String cif;
    @Column (name = "CONTACTO")
    String contact;
    @Column (name = "NOMBRE")
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
