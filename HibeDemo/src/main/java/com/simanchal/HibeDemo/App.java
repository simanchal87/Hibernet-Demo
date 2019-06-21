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
    	
    	
    	
    	
    	Laptop l = new Laptop();
		
		l.setName("Sony1");
		l.setBrand("Brand Sony1");
		l.setPrice(35000);
		
		session.save(l);
		l.setPrice(30000);
		
		session.getTransaction().commit();
		
		session.evict(l);
		l.setPrice(20000);
    	
    	/*
    	Random r = new Random();
    	for (int i=1; i<30; i++)
    	{
    		
    		Laptop l = new Laptop();
    		
    		l.setName("Laptop: " + i);
    		l.setBrand("Brand: " + i);
    		l.setPrice(r.nextInt(50000));
    		
    		session.save(l);
    	}*/
    	   	
    	
    }
}
