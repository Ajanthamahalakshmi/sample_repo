package in.co.nmsworks.hibernate.SampleProgram;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class CompanyMain {
	public static void main(String[] args)
	{
		
		Company nmsworks = new Company();
		nmsworks.setEmpId(739);
		nmsworks.setEmpName("Karthik");
		nmsworks.setEmpSalary(21456);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Company.class);
		
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(nmsworks);
		
		System.out.println("Schema updated Success ");
		tx.commit();
		
	}

}
                                                      