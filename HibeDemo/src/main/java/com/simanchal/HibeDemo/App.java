package com.simanchal.HibeDemo;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	Student s1 = null;
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
    	Query q = session.createQuery("select sum(mark) from Student where mark>60");
    	
    	Double mark = (Double) q.uniqueResult();
    	
    		System.out.println(mark);
    	
    	    	
    	session.getTransaction().commit();
    }
}
