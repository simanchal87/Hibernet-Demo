package com.simanchal.HibeDemo;

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
    	
    	
    	    	
    	
    	//Session 1
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
    	Query q1 = session.createQuery("FROM Student where sId=1");
    	q1.setCacheable(true);
    	    	
    	s1 = (Student)q1.uniqueResult();
    	//s1 =  (Student) session.get(Student.class, 1);
    	System.out.println(s1);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	//Session 2
    	Session session2 = sf.openSession();
    	session2.beginTransaction();
    	
    	Query q2 = session2.createQuery("FROM Student where sId=1");
    	q2.setCacheable(true);
    	
    	s1 = (Student)q2.uniqueResult();
    	//s1 =  (Student) session2.get(Student.class, 1);
    	System.out.println(s1);
    	
    	session2.getTransaction().commit();
    	session2.close();
    	
    	
    }
}
