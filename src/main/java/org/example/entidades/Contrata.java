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
    private Cliente client_id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento event_id;

    @Column(name = "Ciudad_evento")
    String eventcity;


    public Contrata(Cliente client_id, Evento event_id, String eventcity) {
        this.client_id = client_id;
        this.event_id = event_id;
        this.eventcity = eventcity;
    }

    public Contrata() {
    }

    public Cliente getCliente_id() {
        return client_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.client_id = cliente_id;
    }

    public Evento getEvento_id() {
        return event_id;
    }

    public void setEvento_id(Evento evento_id) {
        this.event_id = evento_id;
    }

    public String getCiudadEvento() {
        return eventcity;
    }

    public void setCiudadEvento(String ciudadEvento) {
        this.eventcity = ciudadEvento;
    }

    @Override
    public String toString() {
        return "=============Contrata=============\n"+client_id+"\n"+event_id+"\nEvent city: "+eventcity+"\n==================================";
    }
}
