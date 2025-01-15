package org.example;
import org.example.dao.*;
import org.example.entidades.Animador;
import org.example.entidades.Disfraz;
import org.example.entidades.Evento;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ClienteDao clientDao = new ClienteDao();
        DisfrazDao costumeDao = new DisfrazDao();
        AnimadorDao entertainerDao = new AnimadorDao();
        EventoDao eventDao = new EventoDao();
        PresentadorDao presenterDao = new PresentadorDao();
        ContrataDao contrataDao = new ContrataDao();
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Insertar entidades");
            System.out.println("2. Consultar entidad por ID");
            System.out.println("3. Mostrar todas las entidades");
            System.out.println("4. Consultas específicas");
            System.out.println("5. Consultas por campos unicos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        insertEntities(clientDao, costumeDao, entertainerDao, eventDao, presenterDao,contrataDao);
                        break;
                    case 2:
                        queryEntityById(clientDao, costumeDao, entertainerDao, eventDao, presenterDao,contrataDao);
                        break;
                    case 3:
                        showAllEntities(clientDao, costumeDao, entertainerDao, eventDao, presenterDao,contrataDao);
                        break;
                    case 4:
                        specificQueries(clientDao, entertainerDao, eventDao, costumeDao);
                        break;
                    case 5:
                        queryEntityByUniqueField(clientDao, costumeDao, entertainerDao, eventDao, presenterDao,contrataDao);
                    case 6:
                        System.out.println("Saliendo del programa.");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Tipo de dato no valido\n");
            }
        }
    }
    private static void queryEntityByUniqueField(ClienteDao clientDao, DisfrazDao costumeDao, AnimadorDao entertainerDao, EventoDao eventDao, PresentadorDao presenterDao,ContrataDao contrataDao) {
        System.out.println("\n--- Consultar Entidad por Campo Único ---");
        System.out.println("1. Consultar Cliente por DNI/CIF");
        System.out.println("2. Consultar Disfraz por Personaje");
        System.out.println("3. Consultar Animador por DNI");
        System.out.println("4. Consultar Evento por Nombre");
        System.out.println("5. Consultar Presentador por DNI");
        System.out.print("Seleccione una opción: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        switch (option) {
            case 1:
                System.out.print("Es un particular(1) o una empresa(2)?: ");
                int particularOrCompany = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Ingrese el DNI/CIF: ");
                String identifier = scanner.nextLine();

                if (particularOrCompany == 1) {
                    try {
                        System.out.println(clientDao.getParticularByDni(identifier));
                    } catch (Exception e) {
                        System.out.println("No se encontró el particular con el DNI ingresado.");
                    }
                } else if (particularOrCompany == 2) {
                    try {
                        System.out.println(clientDao.getCompanyByCif(identifier));
                    } catch (Exception e) {
                        System.out.println("No se encontró la empresa con el CIF ingresado.");
                    }
                } else {
                    System.out.println("Opción no válida.");
                }
                break;
            case 2:
                System.out.print("Ingrese el Personaje: ");
                String character = scanner.nextLine();
                try {
                    System.out.println(costumeDao.getCostumeByCharacter(character));
                } catch (Exception e) {
                    System.out.println("No se encontró el disfraz con el personaje ingresado.");
                }
                break;
            case 3:
                System.out.print("Ingrese el DNI: ");
                String dni = scanner.nextLine();
                try {
                    System.out.println(entertainerDao.getByDni(dni));
                } catch (Exception e) {
                    System.out.println("No se encontró el animador con el DNI ingresado.");
                }
                break;
            case 4:
                System.out.print("Ingrese el Nombre del Evento: ");
                String eventName = scanner.nextLine();
                try {
                    System.out.println(eventDao.getByName(eventName));
                } catch (Exception e) {
                    System.out.println("No se encontró el evento con el nombre ingresado.");
                }
                break;
            case 5:
                System.out.print("Ingrese el DNI: ");
                String presenterDni = scanner.nextLine();
                try {
                    System.out.println(presenterDao.getByDni(presenterDni));
                } catch (Exception e) {
                    System.out.println("No se encontró el presentador con el DNI ingresado.");
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void insertEntities(ClienteDao clientDao, DisfrazDao costumeDao, AnimadorDao entertainerDao, EventoDao eventDao, PresentadorDao presenterDao,ContrataDao contrataDao) {
        System.out.println("\n--- Insertar Entidades ---");
        System.out.println("1. Insertar Cliente");
        System.out.println("2. Insertar Disfraz");
        System.out.println("3. Insertar Animador");
        System.out.println("4. Insertar Evento");
        System.out.println("5. Insertar Presentador");
        System.out.println("6. Insertar Contrataciones");
        System.out.print("Seleccione una opción: ");
try {
    int option = scanner.nextInt();
    scanner.nextLine();

    switch (option) {
        case 1:
            clientDao.insertClient();
            break;
        case 2:
            costumeDao.insertCostume();
            break;
        case 3:
            entertainerDao.insertEntertainer();
            break;
        case 4:
            eventDao.insertEvent();
            break;
        case 5:
            presenterDao.insertPresenter();
            break;
        case 6:
            contrataDao.insertHire();
            break;
        default:
            System.out.println("Opción no válida.");
    }
}catch (InputMismatchException e){
    System.err.println("Tipo de dato no valido\n");
}
    }

    private static void queryEntityById(ClienteDao clientDao, DisfrazDao costumeDao, AnimadorDao entertainerDao, EventoDao eventDao, PresentadorDao presenterDao,ContrataDao contrataDao) {
        System.out.println("\n--- Consultar Entidad por ID ---");
        System.out.println("1. Consultar Cliente");
        System.out.println("2. Consultar Disfraz");
        System.out.println("3. Consultar Animador");
        System.out.println("4. Consultar Evento");
        System.out.println("5. Consultar Presentador");
        System.out.print("Seleccione una opción: ");
try {
    int option = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Ingrese el ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    switch (option) {
        case 1:
            System.out.println(clientDao.getParticularById(id));
            break;
        case 2:
            System.out.println(costumeDao.getCostumeById(id));
            break;
        case 3:
            System.out.println(entertainerDao.getEntertainerById(id));
            break;
        case 4:
            System.out.println(eventDao.getById(id));
            break;
        case 5:
            System.out.println(presenterDao.getById(id));
            break;
        case 6:
            System.out.println(contrataDao.getHireById(id));
            break;
        default:
            System.out.println("Opción no válida.");
    }
}catch (InputMismatchException e){
    System.err.println("Tipo de dato no valido\n");
}
    }

    private static void showAllEntities(ClienteDao clientDao, DisfrazDao costumeDao, AnimadorDao entertainerDao, EventoDao eventDao, PresentadorDao presenterDao,ContrataDao contrataDao) {
        System.out.println("\n--- Mostrar Todas las Entidades ---");
        System.out.println("1. Mostrar todos los Clientes");
        System.out.println("2. Mostrar todos los Disfraces");
        System.out.println("3. Mostrar todos los Animadores");
        System.out.println("4. Mostrar todos los Eventos");
        System.out.println("5. Mostrar todos los Presentadores");
        System.out.println("6. Mostrar todas las contratas");
        System.out.print("Seleccione una opción: ");
    try {
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                clientDao.getAllClients().forEach(System.out::println);
                break;
            case 2:
                costumeDao.getAllCostume();
                break;
            case 3:
                entertainerDao.getAllEntertainers().forEach(System.out::println);
                break;
            case 4:
                eventDao.getAllEvents().forEach(System.out::println);
                break;
            case 5:
                presenterDao.getAllPresentators().forEach(System.out::println);
                break;
            case 6:
                contrataDao.getAllHires();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }catch (InputMismatchException e){
        System.err.println("Tipo de dato no valido\n");
    }
    }

    private static void specificQueries(ClienteDao clientDao,  AnimadorDao entertainerDao, EventoDao eventDao, DisfrazDao costumeDao) {
        System.out.println("\n--- Consultas Específicas ---");
        System.out.println("1. Animadores en un Evento");
        System.out.println("2. Eventos de un Presentador");
        System.out.println("3. Clientes en una Ciudad");
        System.out.println("4. Los 2 disfraces más caros");
        System.out.print("Seleccione una opción: ");
try {
    int option = scanner.nextInt();
    scanner.nextLine();

    switch (option) {
        case 1:
            System.out.print("Ingrese el nombre del Evento: ");
            String eventName = scanner.nextLine();
            entertainerDao.getEntertainersByEventName(eventName).forEach(System.out::println);
            break;
        case 2:
            System.out.print("Ingrese el DNI del Presentador: ");
            String presenterDni = scanner.nextLine();
            eventDao.getEventsByPresenterDni(presenterDni).forEach(System.out::println);
            break;
        case 3:
            System.out.print("Ingrese el nombre de la Ciudad: ");
            String cityName = scanner.nextLine();
            clientDao.getClientsByEventCity(cityName).forEach(System.out::println);
            break;
        case 4:
            costumeDao.getCostumeByPrice();
            break;
        default:
            System.out.println("Opción no válida.");
    }
}catch (InputMismatchException e){
    System.err.println("El tipo de dato no es valido");
    scanner.nextLine();
}
    }
}

