package org.example.dao;

import org.example.entidades.Animador;
import org.example.entidades.Disfraz;
import org.example.entidades.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AnimadorDao {
    public void insertEntertainer() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("DNI : ");
        String dni = teclado.nextLine();
        System.out.println("Nombre: ");
        String name = teclado.nextLine();
        System.out.println("Apellido: ");
        String surname = teclado.nextLine();
       try {
           System.out.println("Dime el id del disfraz: ");
           int id = teclado.nextInt();

           DisfrazDao dd = new DisfrazDao();
           Disfraz costume2 = dd.getCostumeById(id);
           Disfraz costume = new Disfraz();

           if (costume2 != null) {
               costume = costume2;
           }

           Animador entertainer = new Animador(dni, name, surname, costume);
           try (Session session = HibernateUtil.getSessionFactory().openSession()) {
               Transaction tx = session.beginTransaction();
               session.save(entertainer);
               tx.commit();

           } catch (Exception e) {
               System.out.println("Error al insertar");
               e.printStackTrace();
           }
       }catch (InputMismatchException e){
           System.err.println("Tipo de dato no valido\n");
       }
    }

    public Animador getEntertainerById(int entertainerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Animador entertainer = session.find(Animador.class, entertainerId);
            return entertainer;
        }
    }
    public Animador getByDni(String dni) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Animador entertainer = session.createQuery("select e from Animador e where e.dni = :dni",Animador.class).setParameter("dni", dni).getSingleResult();
            return entertainer;
        }
    }

    public List<Animador> getAllEntertainers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           List<Animador> entertainers = new ArrayList<>();
           entertainers.addAll(session.createQuery("from Animador",Animador.class).getResultList());
            return entertainers;
        }
    }

    public List<Animador> getEntertainersByEventName(String eventName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Animador> entertainers = session.createQuery("select e from Animador e join e.events ev where ev.name = :eventName", Animador.class).setParameter("eventName", eventName).getResultList();
            return entertainers;
        }
    }

}
