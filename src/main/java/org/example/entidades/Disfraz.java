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

    @OneToMany(mappedBy = "disfraz", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Animador> animadores;


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
        return animadores;
    }

    public void setAnimadores(List<Animador> animadores) {
        this.animadores = animadores;
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
        return "Disfraz{" +
                "character='" + character + '\'' +
                ", price=" + price +
                '}';
    }

}

