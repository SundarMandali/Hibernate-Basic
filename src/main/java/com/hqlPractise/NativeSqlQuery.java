package com.hqlPractise;



import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class NativeSqlQuery {
	public static void main(String[] args) {
		
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory factory=con.buildSessionFactory();
		Session session=factory.openSession();
				
				Transaction tx=session.beginTransaction();
				
				//Executing SQL QUERIES in hibernate 
				NativeQuery nq=session.createSQLQuery("select * from Student");
				//Also use Query instead of NativeQuery
				//Query nq=session.createSQLQuery("select * from Student");
				List<Object[]> list=nq.list();
				
				for(Object[] student:list)
				{
					System.out.println(Arrays.toString(student));
				}
				
				tx.commit();
				session.close();
				factory.close();
	}
}
