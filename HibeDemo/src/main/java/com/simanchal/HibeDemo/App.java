package com.simanchal.HibeDemo;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	 	
    	    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	
    	Student s1 =  (Student) session.get(Student.class, 3);
    	
    	System.out.println(s1.getSname());
    	
    	
    	
    	
    	
    /*	
    	Collection<Laptop> lps = s1.getLaptop();
    	
    	for(Laptop l : lps) {
    		
    		System.out.println(l);
    	}
    	
    	session.getTransaction().commit();
    	*/
    
    	
    }
}
