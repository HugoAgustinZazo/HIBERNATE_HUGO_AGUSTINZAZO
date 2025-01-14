package org.example.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table (name = "EVENTO")
public class Evento {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    @Column (name = "NOMBRE",unique = true)
    String name;
    @Column (name = "HORARIO")
    String time;
    @Column (name = "DESCRIPCION")
    String description;
    @Column (name = "PRECIO")
    double price;

    @ManyToMany
    @JoinTable(
            name = "animador_evento",
            joinColumns = {
                    @JoinColumn(name = "Evento_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "Animador_id")
            })
    private List<Animador> animadores;


    @OneToMany(mappedBy = "evento_id")
    private List<Contrata> contratos;

    @ManyToOne
    @JoinColumn(name = "presentador")
    private Presentador presentador;

    public Evento(int id, String name, String time, String description, double price) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.description = description;
        this.price = price;
    }

    public Evento() {
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

    public List<Contrata> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrata> contratos) {
        this.contratos = contratos;
    }

    public Presentador getPresentador() {
        return presentador;
    }

    public void setPresentador(Presentador presentador) {
        this.presentador = presentador;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String  time) {
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
