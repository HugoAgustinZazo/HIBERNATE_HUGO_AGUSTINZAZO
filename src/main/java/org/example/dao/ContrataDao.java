package org.example.dao;

import org.example.entidades.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class ContrataDao {

    public void insertHire(){
        Scanner teclado = new Scanner(System.in);
        ClienteDao cd = new ClienteDao();
        EventoDao ed = new EventoDao();

        System.out.println("Dime el id del cliente");
        int id_client = teclado.nextInt();
        System.out.println("Dime el id del evento");
        int id_event = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Dime la ciudad del evento");
        String event_city = teclado.nextLine();

        Cliente client = cd.getClientById(id_client);
        Evento event = ed.getById(id_event);

        Contrata hire = new Contrata(client,event,event_city);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(hire);
            tx.commit();
        }
        System.out.println("Contrata insertada");
    }

    public Contrata getHireById(int hireId){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Contrata hire = session.find(Contrata.class,hireId);
            tx.commit();
            return hire;
        }
    }

    public void getAllHires() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Contrata> query = session.createQuery("from Contrata", Contrata.class);
            List<Contrata> hires = query.getResultList();
            for (Contrata c : hires) {
                System.out.println(c);
            }
        }
    }
}
