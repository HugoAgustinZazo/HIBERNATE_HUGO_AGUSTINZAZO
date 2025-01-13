package org.example.entidades;


import jakarta.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@Table (name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "CIUDAD")
    String city;
    @Column(name = "CALLE")
    String street;
    @Column(name = "MUNICIPIO")
    String village;
    @Column(name = "TELEFONO")
    String phone_number;

    public Cliente() {
    }

    public Cliente(int id, String city, String street, String village, String phone_number) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.village = village;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

}
