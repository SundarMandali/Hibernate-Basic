package com.hqlPractise;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HqlApp {

	public static void main(String[] args) {
		
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory factory=con.buildSessionFactory();
		Session session=factory.openSession();
				
				Transaction tx=session.beginTransaction();
				Random random=new Random();
				for(int i=1;i<=10;i++)
				{
					Student obj=new Student();
					obj.setRollno(i);
					obj.setName("Name"+i);
					obj.setMarks(random.nextInt(100));
					session.save(obj);
				}
				
				tx.commit();
				session.close();
				factory.close();
	}
}
