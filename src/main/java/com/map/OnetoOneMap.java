package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoOneMap {
public static void main(String[] args) {
	
	
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class);
	
	SessionFactory factory=cfg.buildSessionFactory();
	
	//creating answer1 object
	Answer a1=new Answer();
	a1.setAnswer("My name is Sundar!");
	a1.setAnswerId(11);
	
	//creating Question1 object
	Question q1=new Question();
	q1.setQuestionId(101);
	q1.setQuestion("What is your Name?");
	q1.setAnswer(a1);
	a1.setQuestion(q1);
	
	//creating answer2 object
		Answer a2=new Answer();
		a2.setAnswer("I am a Developer");
		a2.setAnswerId(12);
		
		
		//creating Question2 object
		Question q2=new Question();
		q2.setQuestionId(102);
		q2.setQuestion("Who are you?");
		q2.setAnswer(a2);
		a2.setQuestion(q2);
		
	//session
	Session session=factory.openSession();
	Transaction tx=session.beginTransaction();
	
	session.save(q1);
	session.save(q2);
	session.save(a1);
	session.save(a2);
	
	tx.commit();
	
	//fetching
	Question qres=(Question)session.get(Question.class,101 );
	
	System.out.println(qres.getQuestion());
	System.out.println(qres.getQuestionId());
	System.out.println(qres.getAnswer().getAnswer());
	System.out.println(qres.getAnswer().getAnswerId());
	
	session.close();
	factory.close();
	
}
}
