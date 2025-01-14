package org.example.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente_contrata_Evento")
public class Contrata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente_id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento_id;

    @Column
    String ciudadEvento;


    public Contrata(int id,Cliente cliente_id, Evento evento_id, String ciudadEvento) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.evento_id = evento_id;
        this.ciudadEvento = ciudadEvento;
    }

    public Contrata() {
    }

    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Evento getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(Evento evento_id) {
        this.evento_id = evento_id;
    }

    public String getCiudadEvento() {
        return ciudadEvento;
    }

    public void setCiudadEvento(String ciudadEvento) {
        this.ciudadEvento = ciudadEvento;
    }

    @Override
    public String toString() {
        return "Contrata{" +
                "cliente_id=" + cliente_id +
                ", evento_id=" + evento_id +
                ", ciudadEvento='" + ciudadEvento + '\'' +
                '}';
    }
}
