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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "animador_evento",
            joinColumns = {
                    @JoinColumn(name = "Evento_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "Animador_id")
            })
    private List<Animador> entertainers;


    @OneToMany(mappedBy = "event_id",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Contrata> contratos;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "presentador")
    private Presentador presentator;

    public Evento(String name, String time, String description, double price,Presentador presentator) {
        this.name = name;
        this.time = time;
        this.description = description;
        this.price = price;
        this.presentator = presentator;
    }

    public Evento(int id, String name, String time, String description, double price, List<Animador> entertainers) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.description = description;
        this.price = price;
        this.entertainers = entertainers;
    }

    public Evento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Animador> getEntertainers() {
        return entertainers;
    }

    public void setEntertainers(List<Animador> entertainers) {
        this.entertainers = entertainers;
    }

    public Presentador getPresentator() {
        return presentator;
    }

    public void setPresentator(Presentador presentator) {
        this.presentator = presentator;
    }

    public List<Contrata> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrata> contratos) {
        this.contratos = contratos;
    }

    public Presentador getPresentador() {
        return presentator;
    }

    public void setPresentador(Presentador presentador) {
        this.presentator = presentador;
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
        return "=============Evento=============\nName: "+name+"\nTime: "+time+"\nDescription: "+description+"\nPrice: "+price+"\n"+presentator+"\n================================";
    }
}
