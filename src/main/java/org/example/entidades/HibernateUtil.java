package org.example.entidades;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.DriverManager;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            return new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }

    }

    //Probamos a no utilizar la configuracion programatica
    private static SessionFactory buildSessionFactoryProgrammatically() {

        Configuration configuration = new Configuration();
        //Driver específico para la BD de destino
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        //Datos para la conexión hacia la BD (cadena de conexión y credenciales)
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/empresa");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "");

        //Específico para la BD de destino que usemos
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        //Nos mostrará el SQL generado por hibernate hacia la BD
        configuration.setProperty("hibernate.show_sql", "true");
        //Formateará las sentencias SQL que va a mostrar para que sean más legibles
        configuration.setProperty("hibernate.format_sql", "true");
        //Esta propiedad nos permite especificar cómo se va a comportar con el modelo físico
        //update: me permitirá actualizar el modelo físico según lo que encuentre en las clases. Por ejemplo,
        //si no hay ninguna tabla relacionada con alguna entidad, creará la tabla
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");

        //Especificamos qué clases/entidades va a mapear

        configuration.addAnnotatedClass(Animador.class);
        configuration.addAnnotatedClass(Cliente.class);
        configuration.addAnnotatedClass(Disfraz.class);
        configuration.addAnnotatedClass(Empresa.class);
        configuration.addAnnotatedClass(Evento.class);
        configuration.addAnnotatedClass(Particular.class);
        configuration.addAnnotatedClass(Presentador.class);
        return configuration.buildSessionFactory();

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
