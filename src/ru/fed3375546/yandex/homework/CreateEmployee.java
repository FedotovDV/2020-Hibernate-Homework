package ru.fed3375546.yandex.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.fed3375546.yandex.homework.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		
		try {
						
			Employee tempEmployee1 = new Employee( "Ivan", "Ivanov", 1);
			Employee tempEmployee2 = new Employee("Petr", "Petrov", 2);
			Employee tempEmployee3 = new Employee("Elena", "Ivanova", 3);

			session.beginTransaction();
			
			session.save(tempEmployee1);
			session.save(tempEmployee2);
			session.save(tempEmployee3);

			
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
