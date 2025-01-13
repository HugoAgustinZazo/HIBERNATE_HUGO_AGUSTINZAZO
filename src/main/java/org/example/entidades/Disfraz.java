package org.example.entidades;

import jakarta.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@Table (name = "Disfraz")
public class Disfraz {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    @Column (name = "PERSONAJE",unique = true)
    String character;
    @Column (name = "PRECIO")
    double price;

    public Disfraz(int id, String character, double price) {
        this.id = id;
        this.character = character;
        this.price = price;
    }

    public Disfraz(){

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

