package com.simanchal.HibeDemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App 
{
    public static void main( String[] args )
    {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	EntityManager em = emf.createEntityManager();
    	
    	Laptop l =em.find(Laptop.class, 2);
    	
    	
    	System.out.println(l);
		
		
    	   	
    	
    }
}
