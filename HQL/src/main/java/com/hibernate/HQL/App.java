package com.hibernate.HQL;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
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
    	Configuration config=new Configuration().configure().addAnnotatedClass(Student.class);
    	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
    	SessionFactory sessionFactory = config.buildSessionFactory(registry);
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Random random = new Random();
//    	for(int i=1;i<=20;i++) {
//    		Student student = new Student();
//    		student.setRollno(i);
//    		student.setName("Name"+i);
//    		student.setMarks(random.nextInt(100));
//    		session.save(student);
//    		
//    	}
    	//1.
//    	Query query = session.createQuery("from Student where marks>50");
//    	List<Student> students = query.list();
 //  	for(Student s:students)
//        	{
//        		System.out.println(s);
//        	}
    	//2.
//    	Query query = session.createQuery("from Student where rollno=7");
//    	Student student = (Student)query.uniqueResult();
 //   	System.out.println(student);
    	//3.
//    	Query query = session.createQuery("select rollno, name, marks from Student where rollno=7");
//    	Object[] student =(Object[]) query.uniqueResult();
//    	
//    	for(Object o : student) {
//    		System.out.println(o);
//    	}
    	//or
//   	System.out.println(student[0]+":"+student[1]+":"+student[2]);
//    	4.
//    	Query query = session.createQuery("select rollno, name, marks from Student");
//    	List<Object[]> students = (List<Object[]>) query.list();
//    	for(Object[] student:students) {
//    		System.out.println(student[0]+":"+student[1]+":"+student[2]);
//    	}
  //    5.
//    	Query query = session.createQuery("select rollno, name, marks from Student s where s.marks>60");
//    	List<Object[]> students = (List<Object[]>) query.list();
//    	for(Object[] student:students) {
//    		System.out.println(student[0]+":"+student[1]+":"+student[2]);
//    	}
    	//6. Sum of marks greater than 60
//    	Query query = session.createQuery("select sum(marks) from Student s where s.marks>60");
//    	Object marks = query.uniqueResult();
    	// Or
//    	Long marks= (Long) query.uniqueResult();
//    	System.out.println(marks);
    	//7.
//    	int b=70;
//    	Query query = session.createQuery("select sum(marks) from Student s where s.marks>:b");
//    	query.setParameter("b", b);
// 
//    	Long marks= (Long) query.uniqueResult();
//    	System.out.println(marks);
    	
    	//-----------SQL--------
    	SQLQuery query = session.createSQLQuery("select * from Student where marks>60");
    	query.addEntity(Student.class);
    	List<Student> students = query.list();
    	for(Object o:students) {
    		System.out.println(o);
    	}
    	session.getTransaction().commit();
    }
}
