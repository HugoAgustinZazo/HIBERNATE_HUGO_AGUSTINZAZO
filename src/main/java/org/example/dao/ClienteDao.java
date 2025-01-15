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
import java.util.List;
import java.util.Scanner;

public class ClienteDao {

    public void insertarCliente (){
        Scanner teclado = new Scanner(System.in);
        System.out.println("============Insertar Cliente============");
        System.out.println("1-Insertar una Empresa.");
        System.out.println("2-Insertar un Particular.");
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
        if(opcion==1){
            System.out.println("============Datos especificos de la empresa============");
            System.out.println("CIF");
            String cif = teclado.nextLine();
            System.out.println("Contacto");
            String contacto = teclado.nextLine();
            System.out.println("Nombre");
            String nombre = teclado.nextLine();
            Cliente cliente = new Empresa(ciudad,calle,municipio,telefono,cif,contacto,nombre);

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction tx = session.beginTransaction();
                session.save(cliente);
                tx.commit();
            }
            System.out.println("Empresa insertada");

        }else if(opcion==2){
            System.out.println("============Datos especificos del Particular============");
            System.out.println("DNI");
            String dni = teclado.nextLine();
            System.out.println("Nombre");
            String nombreParticular = teclado.nextLine();
            System.out.println("Apellido");
            String apellido = teclado.nextLine();
            Cliente clienteParticular = new Particular(ciudad,calle,municipio,telefono,dni,nombreParticular,apellido);

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction tx = session.beginTransaction();
                session.save(clienteParticular);
                tx.commit();
            }
            System.out.println("Particular insertado");
        }else{

            System.out.println("Opcion no valida");
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

    public List<Particular> getAllParticulars() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             Query<Particular> query = session.createQuery("from CLIENTE where TIPO_CLIENTE = :Particular", Particular.class);
             query.setParameter("Particular","Particular");
             List <Particular> particulares = query.getResultList();
             return particulares;
        }
    }

    public List<Empresa> getAllCompanies() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Empresa> query = session.createQuery("from CLIENTE where TIPO_CLIENTE = :Empresa", Empresa.class);
            query.setParameter("Empresa","Empresa");
            List<Empresa>empresas = query.getResultList();
            return empresas;
        }
    }

    public List<Cliente> getAllClients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List <Cliente> clients = new ArrayList<>();
            clients.addAll(session.createQuery("from CLIENTE", Cliente.class).getResultList());
            return clients;
        }
    }

    public List<Client> getClientsByEventCity(String cityName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("select distinct cce.cliente_id from Cliente_contrata_Evento cce where cce.Ciudad_evento = :city", Client.class);
            query.setParameter("city", cityName);
            List<Client> clients = query.getResultList();
            return clients;
        }
    }
}
