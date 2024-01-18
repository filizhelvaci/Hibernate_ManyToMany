package org.example;

import org.example.model.Address;
import org.example.model.Customer;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AppMain {
    public static void main(String[] args) {

        Customer customer=new Customer();
        customer.setFirstName("Servet");
        customer.setLastName("Demirci");

        Customer customer1=new Customer("Batuhan","Devran");
        Customer customer2=new Customer("Ceylan","Evren");

        Address address=new Address("Turkiye","İzmir","Alsancak");
        Address address1=new Address("turkiye","Adana","Seyhan");
        Address address2=new Address("Kanada","Toronto","Xavi");
        Address address3=new Address("Almanya","Berlin","mrl");
        Address address4=new Address("Isvec","Stocholm","vht");

        Set<Address> addressSet = new HashSet<>();
        addressSet.addAll(Arrays.asList(address1,address2,address));

        customer.getAddress().add(address);
        customer.getAddress().add(address1);

        customer1.getAddress().add(address2);
        customer1.getAddress().add(address1);
        customer1.getAddress().add(address4);

        customer2.getAddress().add(address3);
        customer2.getAddress().add(address1);


        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;

        try {
            transaction=session.beginTransaction();
            session.save(customer);
            session.save(customer1);
            session.save(customer2);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            System.out.println("Hata: "+e);
        }finally {
            session.close();
        }


    }
}