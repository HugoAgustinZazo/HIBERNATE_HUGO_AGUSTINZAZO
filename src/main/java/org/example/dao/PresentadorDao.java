package org.example.dao;

import org.example.entidades.HibernateUtil;
import org.example.entidades.Presentador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

import static com.mysql.cj.conf.PropertyKey.logger;

public class PresentadorDao {

    public void insertPresenter() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dime su DNI");
        String dni = teclado.nextLine();
        System.out.println("Dime su nombre");
        String nombre = teclado.nextLine();
        System.out.println("Dime su apellido");
        String apellido = teclado.nextLine();
        System.out.println("Dime su año");
        int año = teclado.nextInt();
        Presentador presentador = new Presentador(dni, nombre, apellido, año);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(presentador);
            tx.commit();
            System.out.println("Presentador Insertado");
        }

    }
        public Presentador getById(int presenterId) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Presentador presenter = session.find(Presentador.class, presenterId);
                return presenter;
            }
        }

        public List<Presentador> getAll() {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Query<Presentador> query = session.createQuery("from Presenter", Presentador.class);
                List<Presentador> presentadores = query.getResultList();
                return presentadores;
            }




    }
}
