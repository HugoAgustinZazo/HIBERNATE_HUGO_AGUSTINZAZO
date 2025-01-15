package org.example.dao;

import org.example.entidades.Cliente;
import org.example.entidades.Disfraz;
import org.example.entidades.HibernateUtil;
import org.example.entidades.Particular;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisfrazDao {

    public void insertCostume(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dime el personaje que quieras");
        String personaje = teclado.nextLine();
        System.out.println("Dime el precio del disfraz");
        double precio = teclado.nextDouble();
        teclado.nextLine();
        Disfraz disfraz = new Disfraz(personaje,precio);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(disfraz);
            tx.commit();
        }
        System.out.println("Disfraz insertado");
    }

    public Disfraz costumeById(int costumeId){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Disfraz costume = session.find(Disfraz.class,costumeId);
            return costume;
        }
    }

    public void getCustomByPrice() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Disfraz> query = session.createQuery("from Disfraz order by PRECIO desc", Disfraz.class);
            query.setMaxResults(2);
            List<Disfraz> disfraces = query.getResultList();
            for (Disfraz c : disfraces) {
                System.out.println(c);
            }
        }
    }
}
