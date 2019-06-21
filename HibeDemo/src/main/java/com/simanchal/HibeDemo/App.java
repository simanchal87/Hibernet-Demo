package com.simanchal.HibeDemo;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
    	//get will run even if it's not used anywhere
    	Laptop l = (Laptop) session.get(Laptop.class, 3);
		//System.out.println(l);
		
    	
    	//Load will run if it's only used 
		Laptop l1 = (Laptop) session.load(Laptop.class, 3);
		//System.out.println(l1);
	
		
		session.getTransaction().commit();
		
		
    	   	
    	
    }
}
