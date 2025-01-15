package org.example.entidades;


import jakarta.persistence.*;

@Entity
public class Empresa extends Cliente{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    @Column (name = "CIF",unique = true)
    String cif;
    @Column (name = "CONTACTO")
    String contact;
    @Column (name = "NOMBRE_EMPRESA")
    String name;

    public Empresa (){

    }
    public Empresa( String city, String street, String village, String phone_number, String cif, String contact, String name) {
        super(city, street, village, phone_number);
        this.cif = cif;
        this.contact = contact;
        this.name = name;
    }

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
        return "=============Empresa=============\nCIF: "+cif+"\nContact: "+contact+"\nName: "+name+"\nCity: "+city+"\nStreet: "+street+"\nVillage: "+village+"\nPhone Number: "+phone_number+"\n=================================";
    }

    @Override
    public void info() {

    }
}
