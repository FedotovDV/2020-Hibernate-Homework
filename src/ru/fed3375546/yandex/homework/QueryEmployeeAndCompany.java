package ru.fed3375546.yandex.homework;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.fed3375546.yandex.homework.entity.Company;
import ru.fed3375546.yandex.homework.entity.Employee;

@SuppressWarnings("unchecked")
public class QueryEmployeeAndCompany {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Company.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
				
			List<Company> theCompanies = session.createQuery("from Company").getResultList();

			displayEmployees(theEmployees, theCompanies);
			
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayEmployees(List<Employee> theEmployees, List<Company> theCompanies) {
		for (Employee tempEmployee : theEmployees) {
			System.out.print("\nEmployee: First Name:"+ tempEmployee.getFirstName() );
			System.out.print(", Last Name: "+tempEmployee.getLastName() );
			System.out.print(", Company: "+theCompanies.get(tempEmployee.getIdCompany()-1).getCompanyName()+"\n" );
			System.out.println();
		}
	}
}
