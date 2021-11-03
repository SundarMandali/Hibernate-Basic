package com.sundar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class App {
public static void main(String[] args) {
	
	AlienName alienName=new AlienName();
	alienName.setFirstname("Mandali");
	alienName.setLastname("Sundar");
	Alien obj=new Alien();
	obj.setAid(101);
	obj.setAlienName(alienName);
	obj.setColor("Green");
	
	
	Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
	SessionFactory sf=con.buildSessionFactory();
	Session session=sf.openSession();
	
	Transaction tx=session.beginTransaction();
	
	session.save(obj);
	tx.commit();
//	System.out.println(obj);
	
}
}
