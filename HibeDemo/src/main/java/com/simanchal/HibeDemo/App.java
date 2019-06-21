package com.simanchal.HibeDemo;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
    	
    	SQLQuery q = session.createSQLQuery("select sname, mark from Student where mark> 60");
    	
    	q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    	
    	List students = q.list();
    			
    	for(Object o : students)
    	{
    		Map m = (Map)o;
    		System.out.println(m.get("SNAME") + " : " + m.get("MARK"));
    	}
    	   	
    	session.getTransaction().commit();
    }
}
