package com.simanchal.HibeDemo;

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
    	StudentsName sn = new StudentsName();
    	Student s = new Student();
    	
    	sn.setFname("Fname5");
    	sn.setMname("mname5");
    	sn.setLname("lname5");
    	
    	Laptop lp = new Laptop();
    	
    	lp.setLid(5);
    	lp.setLname("HP5");
    	lp.setLprice("52000");
    	
    	
    		
    	s.setsId(5);
    	s.setSname(sn);    	
    	s.setRollNo("126");
    	
    	lp.setStudents(s);
    	
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	
    	session.save(lp);
    	session.save(s);
    	
    	
    	session.getTransaction().commit();
    	
    }
}
