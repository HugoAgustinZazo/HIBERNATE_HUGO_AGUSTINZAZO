package org.example.dao;

import org.example.entidades.Evento;
import org.example.entidades.HibernateUtil;
import org.hibernate.Session;

import java.util.Scanner;

public class EventoDao {
/*
    public void insertEvent() {
        Scanner teclado = new Scanner(System.in);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Evento event = new Evento();
            System.out.print("Introduce el nombre del evento: ");
            String nombre = teclado.nextLine();

            System.out.print("Introduce la fecha del evento (dd/MM/yyyy): ");
            String fecha = teclado.nextLine();
            System.out.print("Introduce la descripci n del evento: ");
            event.setDescription(scanner.next());

            System.out.print("Introduce el precio del evento: ");
            event.setPrice(scanner.nextDouble());

            System.out.print("Introduce el DNI del presentador del evento: ");
            Presenter presenter = session.get(Presenter.class, scanner.next());
            event.setPresenter(presenter);

            session.beginTransaction();
            session.save(event);
            session.getTransaction().commit();
            logger.info("Evento insertado correctamente");
        }
    }

    public Event getById(int eventId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            logger.info("Consultando evento por id: " + eventId);
            Event event = session.find(Event.class, eventId);
            return event;
        }
    }

    public List<Event> getAllEvents() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            logger.info("Consultando todos los eventos");
            List<Event> events = session.createQuery("select e from Event e", Event.class)
                    .getResultList();
            return events;
        }
    }

    public List<Event> getEventsByPresenterDni(String presenterDni) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            logger.info("Consultando eventos presentados por el presentador con DNI: " + presenterDni);
            List<Event> events = session.createQuery(
                            "select e from Event e join e.presenter p where p.dni = :dni", Event.class)
                    .setParameter("dni", presenterDni)
                    .getResultList();
            return events;
        }



 */

}
