package com.main;

import com.DAO.DataSource;
import com.entity.Agent;
import com.entity.Buyer;
import com.entity.Owner;
import com.service.ServiceClass;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class ExecutionMain {

    public static ServiceClass serviceClass = new ServiceClass();
    public static DataSource dataSource = new DataSource();

    public static Scanner scanner = new Scanner(System.in);

    public static SessionFactory sessionFactory = dataSource.getConnection();

    public static Agent agent = new Agent();
    public static Owner owner = new Owner();
    public static Buyer buyer = new Buyer();


    public static void main(String[] args) {

        serviceClass.dataEntryAgent(agent,sessionFactory,dataSource,scanner);
        serviceClass.dataEntryBuyer(buyer,sessionFactory,dataSource,scanner);
        serviceClass.dataEntryOwner(owner,sessionFactory,dataSource,scanner);

        String customerType1 = serviceClass.login(scanner, buyer);
        String customerType2 = serviceClass.login(scanner, owner);
        String customerType3 = serviceClass.login(scanner, agent);

        if (customerType1 != "") {
            System.out.println("Customer Type: " + customerType1);
        }

        if (customerType2 != "") {
            System.out.println("Customer Type: " + customerType2);
        }
        if (customerType3 != "") {
            System.out.println("Customer Type: " + customerType3);
        }
    }
}