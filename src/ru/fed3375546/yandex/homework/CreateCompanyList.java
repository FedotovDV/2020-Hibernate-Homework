package ru.fed3375546.yandex.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import ru.fed3375546.yandex.homework.entity.Company;

public class CreateCompanyList {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Company.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		
		try {
						
			Company tempCompany1 = new Company( "Epam", "Moscow");
			Company tempCompany2 = new Company("TSystems", "SPb");
			Company tempCompany3 = new Company("Sberbank", "SPb");

			session.beginTransaction();
			
			session.save(tempCompany1);
			session.save(tempCompany2);
			session.save(tempCompany3);

			
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
