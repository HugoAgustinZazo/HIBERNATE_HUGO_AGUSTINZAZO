package org.example.dao;

import org.example.entidades.Animador;
import org.example.entidades.Evento;
import org.example.entidades.HibernateUtil;
import org.example.entidades.Presentador;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EventoDao {

    public void insertEvent() {
        Scanner teclado = new Scanner(System.in);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Animador> entertainers = new ArrayList<>();
            AnimadorDao ad = new AnimadorDao();
            System.out.print("Introduce el nombre del evento: ");
            String nombre = teclado.nextLine();
            System.out.print("Introduce la fecha del evento (dd/MM/yyyy): ");
            String fecha = teclado.nextLine();
            System.out.print("Introduce la descripción del evento: ");
            String descripción = teclado.nextLine();
           try {
               System.out.print("Introduce el precio del evento: ");
               Double precio = teclado.nextDouble();

            String respuesta = "";

            while (!respuesta.equalsIgnoreCase("no")){
                System.out.println("¿Quieres añadir animadores al evento?");
                respuesta = teclado.next();
                if(respuesta.equalsIgnoreCase("si")) {
                    System.out.println("\nDime el id del animador: ");
                    int id = teclado.nextInt();
                    Animador entertainer = ad.getEntertainerById(id);
                    entertainers.add(entertainer);
                }
            }

            System.out.print("Introduce el Id del presentador del evento: ");
            int id = teclado.nextInt();
            Presentador presentador = session.get(Presentador.class, id);
            Presentador presentador1 = new Presentador();

            if(presentador!=null){
                presentador1=presentador;
            }

            Evento event = new Evento();

            event.setName(nombre);
            event.setTime(fecha);
            event.setDescription(descripción);
            event.setPrice(precio);
            event.setPresentador(presentador1);
            event.setEntertainers(entertainers);

            session.beginTransaction();
            session.save(event);
            session.getTransaction().commit();
           }catch (InputMismatchException e){
               System.err.println("Tipo de dato no valido\n");
           }
        }
    }

    public Evento getByName(String eventName){
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Evento event = session.createQuery("select e from Evento e where e.name = :name", Evento.class)
                        .setParameter("name", eventName)
                        .getSingleResult();
                return event;
            }
    }

    public Evento getById(int eventId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Evento event = session.find(Evento.class, eventId);
            return event;
        }
    }

    public List<Evento> getAllEvents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Evento> events = session.createQuery("from Evento", Evento.class).getResultList();
            return events;
        }
    }

    public List<Evento> getEventsByPresenterDni(String presenterDni) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Evento> events = session.createQuery("select e from Evento e join e.presentator p where p.dni = :dniP", Evento.class).setParameter("dniP", presenterDni).getResultList();
            return events;
        }
    }
}
