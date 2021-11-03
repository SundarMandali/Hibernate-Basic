package com.hqlPractise;



import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HqlAppQueries {
public static void main(String[] args) {
		
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory factory=con.buildSessionFactory();
		Session session=factory.openSession();
				
				Transaction tx=session.beginTransaction();
				
				//SELECT query
//				Query q=session.createQuery("from Student where rollno>:x");
//				q.setParameter("x",5);

								
//				List<Student> list=q.list();
//				for(Student student:list)
//				{
//					System.out.println(student);
//				}
				
				
				//DELETE Query
//				Query q=session.createQuery("delete from Student where rollno=:x");
//				q.setParameter("x",10);
//				int r=q.executeUpdate();
//				System.out.println("No of rows deleted is "+r);
				
				//UPDATE Query
				Query q=session.createQuery("update Student set name=:n where rollno=:x");
				q.setParameter("n", "DRC");
				q.setParameter("x", 8);
				int r=q.executeUpdate();
				System.out.println("No of rows updated is "+r);
				tx.commit();
				session.close();
				factory.close();
	}
}
