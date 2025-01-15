package org.example;

import org.example.dao.ClienteDao;
import org.example.entidades.*;
import org.hibernate.*;
public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        Entertainer entertainer = new Entertainer();
//        entertainer.setDni("12345678A");
//        entertainer.setFirstName("Gabriela");
//        entertainer.setLastName("García");
//        session.save(entertainer);

//        Particular particular = new Particular("Barcelona", "12345678A", "Calle Principal", "Barcelona", "98765432B", "Pedro", "Pérez");
//        particular.setDni("98765432B");
//        particular.setName("Pedro");*-+
//        particular.setSurname("Pérez");
//        session.save(particular);
/*
        Cliente nuevoParticular = new Empresa("Barcelona", "12345678A",
                "Calle Principal", "Barcelona", "98765432B", "Pedro", "Pérez");

        Evento eventoNuevo = new Evento();
        eventoNuevo.setName("Concierto de POPper");
        eventoNuevo.setTime("18:00");
        eventoNuevo.setDescription("Un concierto de los chales de la Fortuna.");
        eventoNuevo.setPrice(50.0);
        Presentador presentador = new Presentador();
        eventoNuevo.setPresentador(presentador);


        Contrata hire = new Contrata();
        hire.setCliente_id(nuevoParticular);
        hire.setEvento_id(eventoNuevo);
        hire.setCiudadEvento("La Fortuna");


        session.save(nuevoParticular);
        session.save(presentador);
        session.save(eventoNuevo);
        session.save(hire);


//        System.out.println(nuevoParticular.toString());

//        Costume traje = new Costume();
//        traje.setPrice(100);
//        traje.setCharacter("traje");
//        session.persist(traje);
//
//        Entertainer entertainer = new Entertainer();
//        entertainer.setDni("12345678A");
//        entertainer.setFirstName("Gabriela");
//        entertainer.setLastName("García");
//        entertainer.setCostume(traje);
//        session.save(entertainer);






        session.getTransaction().commit();
        session.close();


 */
        ClienteDao cd = new ClienteDao();

        System.out.println(cd.getCompanyById(2));
    }
}