package com.DAO;

import com.entity.Agent;
import com.entity.Buyer;
import com.entity.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.main.ExecutionMain.sessionFactory;

public class DataSource {

    public SessionFactory getConnection() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Agent.class);
        configuration.addAnnotatedClass(Buyer.class);
        configuration.addAnnotatedClass(Owner.class);

        //create Session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public void addAgent(Agent agent, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(agent);
            tx.commit();
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void addBuyer(Buyer buyer, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(buyer);
            tx.commit();
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void addOwner(Owner owner, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(owner);
            tx.commit();
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<Buyer> getAllBuyerCustomers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Buyer> buyerCustomer = null;
        try{
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Buyer> cr = builder.createQuery(Buyer.class);
            Root<Buyer> root = cr.from(Buyer.class);
            cr.select(root);
            Query query = session.createQuery(cr);
            buyerCustomer =  query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return buyerCustomer;
    }

    public static List<Owner> getAllOwnerCustomers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Owner> ownerCustomer = null;
        try{
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Owner> cr = builder.createQuery(Owner.class);
            Root<Owner> root = cr.from(Owner.class);
            cr.select(root);
            Query query = session.createQuery(cr);
            ownerCustomer =  query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ownerCustomer;
    }

    public static List<Agent> getAllAgentCustomers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Agent> agentCustomer = null;
        try{
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Agent> cr = builder.createQuery(Agent.class);
            Root<Agent> root = cr.from(Agent.class);
            cr.select(root);
            Query query = session.createQuery(cr);
            agentCustomer =  query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return agentCustomer;
    }
}