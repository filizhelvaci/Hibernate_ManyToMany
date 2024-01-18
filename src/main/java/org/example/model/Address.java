package org.example.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ADDRESS")
public class Address{

    @ManyToMany(mappedBy = "address",fetch = FetchType.LAZY)
    private Set<Customer> customer=new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADDRESS_ID",nullable = false)
    private Long id;

    @Column(name="COUNTRY",length = 50,nullable = false)
    private String country;
    @Column(name="CITY",length = 50)
    private String city;
    @Column(name="STREET")
    private String street;
    @Transient //Bu veri tabanına kolon olarak gitmeyecek
    private int Sayac;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public void setStreet(String stree1t) {
        this.street = stree1t;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }

    public int getSayac() {
        return Sayac;
    }

    public void setSayac(int sayac) {
        Sayac = sayac;
    }

    public Address() {
    }

    public Address(Set<Customer> customer, Long id, String country, String city, String street, int sayac) {
        this.customer = customer;
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        Sayac = sayac;
    }

    public Address(Long id, String country, String city, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }
}
