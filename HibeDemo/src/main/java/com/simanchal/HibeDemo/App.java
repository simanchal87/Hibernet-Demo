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
    	
    		
    	Student s = new Student();
    	
    	s.setsId(1);
    	
    	s.setSname(sn);    	
    	s.setRollNo("123");
    	
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sf = con.buildSessionFactory(reg);
    	
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	session.save(s);
    	
    	tx.commit();
    	
    	s = (Student) session.get(Student.class, 105);
    	
    	System.out.println(s);
    }
}
