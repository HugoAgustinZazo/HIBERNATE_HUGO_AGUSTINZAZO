package org.example.dao;

import com.mysql.cj.xdevapi.Client;
import org.example.entidades.Cliente;
import org.example.entidades.Empresa;
import org.example.entidades.HibernateUtil;
import org.example.entidades.Particular;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClienteDao {

    public void insertClient () {
        Scanner teclado = new Scanner(System.in);
        System.out.println("============Insertar Cliente============");
        System.out.println("1-Insertar una Empresa.");
        System.out.println("2-Insertar un Particular.");
        try {
            int opcion = teclado.nextInt();
            teclado.nextLine();

            System.out.println("Ciudad");
            String ciudad = teclado.nextLine();
            System.out.println("Calle");
            String calle = teclado.nextLine();
            System.out.println("Municipio");
            String municipio = teclado.nextLine();
            System.out.println("Telefono");
            String telefono = teclado.nextLine();
            if (opcion == 1) {
                System.out.println("============Datos especificos de la empresa============");
                System.out.println("CIF");
                String cif = teclado.nextLine();
                System.out.println("Contacto");
                String contacto = teclado.nextLine();
                System.out.println("Nombre");
                String nombre = teclado.nextLine();
                Cliente client = new Empresa(ciudad, calle, municipio, telefono, cif, contacto, nombre);

                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    Transaction tx = session.beginTransaction();
                    session.save(client);
                    tx.commit();
                }
                System.out.println("Empresa insertada");

            } else if (opcion == 2) {
                System.out.println("============Datos especificos del Particular============");
                System.out.println("DNI");
                String dni = teclado.nextLine();
                System.out.println("Nombre");
                String nombreParticular = teclado.nextLine();
                System.out.println("Apellido");
                String apellido = teclado.nextLine();
                Cliente clientParticular = new Particular(ciudad, calle, municipio, telefono, dni, nombreParticular, apellido);

                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    Transaction tx = session.beginTransaction();
                    session.save(clientParticular);
                    tx.commit();
                }
                System.out.println("Particular insertado");
            } else {

                System.out.println("Opcion no valida");
            }
        }catch (InputMismatchException e){
            System.err.println("Tipo de dato no valido\n");
        }
    }

    public Cliente getParticularById(int clientId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Cliente particular = session.find(Particular.class, clientId);
            return particular;
        }
    }

    public Cliente getCompanyById(int clientId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Cliente empresa = session.find(Empresa.class, clientId);
            return empresa;
        }
    }

    public Cliente getClientById(int clientId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Cliente client = session.find(Cliente.class, clientId);
            return client;
        }
    }

    public List<Particular> getAllParticulars() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             Query<Particular> query = session.createQuery("from Cliente where TIPO_CLIENTE = :Particular", Particular.class);
             query.setParameter("Particular","Particular");
             List <Particular> particulars = query.getResultList();
             return particulars;
        }
    }
    public Cliente getParticularByDni(String dni) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Particular> query = session.createQuery(
                    "from Particular p where p.dni = :dni", Particular.class);
            query.setParameter("dni", dni);
            Particular particular = query.uniqueResult();
            return particular;
        }
    }

    public Cliente getCompanyByCif(String cif) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Empresa> query = session.createQuery(
                    "from Empresa where cif = :cif", Empresa.class);
            query.setParameter("cif", cif);
            Cliente empresa = query.uniqueResult();
            return empresa;
        }
    }
    public List<Empresa> getAllCompanies() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Empresa> query = session.createQuery("from Cliente where TIPO_CLIENTE = :Empresa", Empresa.class);
            query.setParameter("Empresa","Empresa");
            List<Empresa>companies = query.getResultList();
            return companies;
        }
    }

    public List<Cliente> getAllClients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List <Cliente> clients = new ArrayList<>();
            clients.addAll(session.createQuery("from Cliente", Cliente.class).getResultList());
            return clients;
        }
    }

    public List<Cliente> getClientsByEventCity(String cityName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Cliente> clients = session.createQuery("select distinct h.client_id from Contrata h where h.eventcity = :city", Cliente.class).setParameter("city",cityName).getResultList();
            return clients;
        }

    }
}
