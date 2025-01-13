package org.example.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@Table (name = "EVENTO")
public class Evento {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    @Column (name = "NOMBRE",unique = true)
    String name;
    @Column (name = "HORARIO")
    LocalDateTime time;
    @Column (name = "DESCRIPCION")
    String description;
    @Column (name = "PRECIO")
    double price;

    public Evento(int id, String name, LocalDateTime time, String description, double price) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.description = description;
        this.price = price;
    }

    public Evento() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
