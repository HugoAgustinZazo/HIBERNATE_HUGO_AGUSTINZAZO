package org.example.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "Disfraz")
public class Disfraz {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "DISFRAZ_ID")
    int id;
    @Column (name = "PERSONAJE",unique = true)
    String character;
    @Column (name = "PRECIO")
    double price;

    @OneToMany(mappedBy = "costume", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Animador> entertainers;


    public Disfraz( String character, double price) {
        this.character = character;
        this.price = price;
    }

    public Disfraz(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Animador> getAnimadores() {
        return entertainers;
    }

    public void setAnimadores(List<Animador> animadores) {
        this.entertainers = animadores;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "=============Disfraz=============\nCharacter: "+character+"\nPrice: "+price+"\n=================================";
    }

}

