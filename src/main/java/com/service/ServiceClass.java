package com.service;

import com.DAO.DataSource;
import com.entity.Agent;
import com.entity.Buyer;
import com.entity.Owner;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class ServiceClass {

    public void dataEntryBuyer(Buyer buyer, SessionFactory sessionFactory, DataSource dataSource, Scanner scanner) {
        System.out.println("Enter buyer name");
        String buyerName = scanner.next();
        buyer.setBuyerName(buyerName);


        System.out.println("Enter buyer email");
        String buyeremail = scanner.next();
        buyer.setBuyerEmail(buyeremail);

        System.out.println("Enter buyer password");
        String buyerPassword = scanner.next();
        buyer.setBuyerpassword(buyerPassword);

        System.out.println("Enter buyer mobile");
        long buyermobile = scanner.nextLong();
        buyer.setBuyerMobile(buyermobile);
        dataSource.addBuyer(buyer, sessionFactory);

    }


    public void dataEntryOwner(Owner owner, SessionFactory sessionFactory, DataSource dataSource, Scanner scanner) {
        System.out.println("Enter owner name");
        String ownerName = scanner.next();
        owner.setOwnerName(ownerName);


        System.out.println("Enter owner email");
        String owneremail = scanner.next();
        owner.setOwnerEmail(owneremail);

        System.out.println("Enter owner password");
        String ownerPassword = scanner.next();
        owner.setOwnerpassword(ownerPassword);

        System.out.println("Enter owner mobile");
        long ownermobile = scanner.nextLong();
        owner.setOwnerMobile(ownermobile);
        dataSource.addOwner(owner, sessionFactory);
    }


    public void dataEntryAgent(Agent agent, SessionFactory sessionFactory, DataSource dataSource, Scanner scanner) {
        System.out.println("Enter agent name");
        String agentName = scanner.next();
        agent.setAgentName(agentName);


        System.out.println("Enter agent email");
        String agentemail = scanner.next();
        agent.setAgentEmail(agentemail);

        System.out.println("Enter agent password");
        String agentPassword = scanner.next();
        agent.setAgentpassword(agentPassword);

        System.out.println("Enter agent mobile");
        long agentmobile = scanner.nextLong();
        agent.setAgentMobile(agentmobile);
        dataSource.addAgent(agent, sessionFactory);
    }


    public String login(Scanner scanner,Buyer buyer) {
        String customerType1 = "";

        System.out.println("Enter your username:");
        String userName = scanner.next();

        System.out.println("Enter your password:");
        String password = scanner.next();

        if(!userName.equals(null) && !password.equals("")){
            String custType = checkEmailPasswordMatched(userName, password);
            if(!custType.equals("")){
                customerType1 = custType;
                System.out.println("Successfully logged In.");
            }else {
                System.out.println("Invalid Credentials!");
            }
        }else{
            System.out.println("Invalid Credentials!");
        }

        return customerType1;

    }

    public String login(Scanner scanner,Owner owner) {
        String customerType2 = "";

        System.out.println("Enter your username:");
        String userName = scanner.next();

        System.out.println("Enter your password:");
        String password = scanner.next();

        if (!userName.equals(null) && !password.equals("")) {
            String custType = checkEmailPasswordMatched(userName, password);
            if (!custType.equals("")) {
                customerType2 = custType;
                System.out.println("Successfully logged In.");
            } else {
                System.out.println("Invalid Credentials!");
            }
        } else {
            System.out.println("Invalid Credentials!");
        }

        return customerType2;
    }

    public String login(Scanner scanner,Agent agent) {
        String customerType3 = "";

        System.out.println("Enter your username:");
        String userName = scanner.next();

        System.out.println("Enter your password:");
        String password = scanner.next();

        if (!userName.equals(null) && !password.equals("")) {
            String custType = checkEmailPasswordMatched(userName, password);
            if (!custType.equals("")) {
                customerType3 = custType;
                System.out.println("Successfully logged In.");
            } else {
                System.out.println("Invalid Credentials!");
            }
        } else {
            System.out.println("Invalid Credentials!");
        }

        return customerType3;
    }
    public String checkEmailPasswordMatched(String email, String password){
        String iam = "";
        List<Buyer> buyerCustomerList = DataSource.getAllBuyerCustomers();
        List<Owner> ownerCustomerList = DataSource.getAllOwnerCustomers();
        List<Agent> agentCustomerList = DataSource.getAllAgentCustomers();
        for(Buyer bc : buyerCustomerList){
            if(bc.getBuyerEmail().equalsIgnoreCase(email) && bc.getBuyerpassword().equalsIgnoreCase(password)){
                iam = "Buyer";
                break;
            }
        }
        if(iam.equals("")){
            for(Agent ac : agentCustomerList){
                if(ac.getAgentEmail().equalsIgnoreCase(email) && ac.getAgentpassword().equalsIgnoreCase(password)){
                    iam = "Agent";
                    break;
                }
            }
        }

        if(iam.equals("")){
            for(Owner oc : ownerCustomerList){
                if(oc.getOwnerEmail().equalsIgnoreCase(email) && oc.getOwnerpassword().equalsIgnoreCase(password)){
                    iam = "Owner";
                    break;
                }
            }
        }

        return iam;

    }
}