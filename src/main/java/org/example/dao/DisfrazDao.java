package org.example.dao;

import org.example.entidades.Cliente;
import org.example.entidades.Disfraz;
import org.example.entidades.HibernateUtil;
import org.example.entidades.Particular;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DisfrazDao {

    public void insertCostume(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dime el personaje que quieras");
        String personaje = teclado.nextLine();
        try {
            System.out.println("Dime el precio del disfraz");
            double precio = teclado.nextDouble();
            teclado.nextLine();
            Disfraz disfraz = new Disfraz(personaje, precio);
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction tx = session.beginTransaction();
                session.save(disfraz);
                tx.commit();
            }
            System.out.println("Disfraz insertado");
        }catch (InputMismatchException e){
            System.err.println("Tipo de dato no valido\n");
        }
    }

    public Disfraz getCostumeById(int costumeId){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Disfraz costume = session.find(Disfraz.class,costumeId);
            return costume;
        }
    }
    public Disfraz getCostumeByCharacter(String character) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Disfraz> query = session.createQuery("from Disfraz where character = :character", Disfraz.class);
            query.setParameter("character", character);
            Disfraz costume = query.getSingleResult();
            return costume;
        }
    }
    public void getAllCostume() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Disfraz> query = session.createQuery("from Disfraz", Disfraz.class);
            List<Disfraz> disfraces = query.getResultList();
            for (Disfraz c : disfraces) {
                System.out.println(c);
            }
        }
    }
    public void getCostumeByPrice() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Disfraz> query = session.createQuery("from Disfraz order by price desc", Disfraz.class);
            query.setMaxResults(2);
            List<Disfraz> disfraces = query.getResultList();
            for (Disfraz c : disfraces) {
                System.out.println(c);
            }
        }
    }
}
