package org.example.entidades;

public class Disfraz {

    String character;
    double price;

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

