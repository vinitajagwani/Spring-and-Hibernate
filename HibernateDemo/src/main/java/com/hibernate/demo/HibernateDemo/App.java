package com.hibernate.demo.HibernateDemo;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
//    	Name name=new Name();
//    	name.setFname("Jatin");
//    	name.setLname("nbgkj");
//    	name.setMname("Jagwani");
    	Student student=new Student();
//    	student.setUid(19);
//    	student.setName(name);
    	Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
    	ServiceRegistry regsitry=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf=con.buildSessionFactory(regsitry);
    	Session session = sf.openSession();
    	
    	Transaction transaction = session.beginTransaction();
    	Query q1=session.createQuery("from Student where Uid=11");
    	q1.setCacheable(true);
    	student =  (Student) q1.uniqueResult();
//    	session.save(student);
//    	student=(Student)session.get(Student.class, 11);
    	System.out.println(student);
    	transaction.commit();
    	session.close();
    	Session session1 = sf.openSession();
    	
    	Transaction transaction1 = session1.beginTransaction();
    	Query q2=session1.createQuery("from Student where Uid=11");
    	q2.setCacheable(true);
    	student =  (Student) q2.uniqueResult();
//    	student=(Student)session1.get(Student.class, 11);
    	System.out.println(student);
    	transaction1.commit();
    	session1.close();
    	
    }
}
