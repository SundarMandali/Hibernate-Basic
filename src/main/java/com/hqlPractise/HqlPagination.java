package com.hqlPractise;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HqlPagination {
	public static void main(String[] args) {
		
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory factory=con.buildSessionFactory();
		Session session=factory.openSession();
				
				Transaction tx=session.beginTransaction();
				Query q=session.createQuery("from Student");
//				Query<Student> q=session.createQuery("from Student",Student.class);
				
				//implementing pagination
				q.setFirstResult(0);
				q.setMaxResults(5);
				

								
				List<Student> list=q.list();
				for(Student student:list)
				{
					System.out.println(student);
				}
				
				
				
				tx.commit();
				session.close();
				factory.close();
	}
}
