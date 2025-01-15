package org.example.entidades;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
/**He elegido la herencia "Single Table ya que creo que a la hora de buscar registros/informacion se hace más sencillo ir a buscar a una sola
 * tabla, al igual que si quieres ver todos los clientes sin importar el tipo puedes verlos solo en esa tabla y asi los tienes todos juntos
 * aunque también separados a la vez por la columna discriminatoria, aparte del menor consumo de memoria ya que en vez de mapear dos tablas solo mapea una.
 *
 */
@DiscriminatorColumn(name = "TIPO_CLIENTE",discriminatorType = DiscriminatorType.STRING)
@Table (name = "CLIENTE")
public abstract class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "CIUDAD")
    String city;
    @Column(name = "CALLE")
    String street;
    @Column(name = "MUNICIPIO")
    String village;
    @Column(name = "TELEFONO")
    String phone_number;

    @OneToMany(mappedBy = "client_id",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Contrata> hires;

    public Cliente() {
    }

    public Cliente(String city, String street, String village, String phone_number) {
        this.city = city;
        this.street = street;
        this.village = village;
        this.phone_number = phone_number;
    }

    public abstract void info();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


}
