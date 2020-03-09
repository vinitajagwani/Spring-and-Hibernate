package com.hibernate.HibernateMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Laptop laptop=new Laptop();
        laptop.setLid(101);
        laptop.setLname("Lenovo");
        Student student = new Student();
        student.setRollno(1);
        student.setName("Vinita");
        student.setMarks(80);
        student.getLaptop().add(laptop);
//        laptop.getStudent().add(student);
      
        
        Configuration config =  new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry =  new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(laptop);
        session.save(student);
        
        session.getTransaction().commit();
    }
}
