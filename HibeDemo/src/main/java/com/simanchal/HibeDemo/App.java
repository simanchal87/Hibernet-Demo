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
    	Student s1 = null;
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
    	Random rnd = new Random();
    	
    	for(int i=1; i<20; i++)
    	{
    		s1 = new Student();
    		s1.setRollNo(i);
    		s1.setSname("Student "+i);
    		s1.setMark(rnd.nextInt(100));
    		
    		session.save(s1);
    	}
    	
    	session.getTransaction().commit();
    }
}
