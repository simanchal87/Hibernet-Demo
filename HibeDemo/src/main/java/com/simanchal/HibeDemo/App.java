package com.simanchal.HibeDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StudentsName sn = new StudentsName();
    	
    	sn.setFname("Fname");
    	sn.setMname("mname");
    	sn.setLname("lname");
    	
    	Laptop lp = new Laptop();
    	
    	lp.setLid(1);
    	lp.setLname("Dell");
    		
    	Student s = new Student();
    	
    	s.setsId(1);
    	s.setSname(sn);    	
    	s.setRollNo("123");
    	s.getLaptop().add(lp);
    	
    	
    	
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
