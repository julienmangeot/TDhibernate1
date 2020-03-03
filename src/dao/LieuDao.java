package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Lieu;

public class LieuDao implements ILieuDao{

	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	public boolean createLieu(Lieu lieu) {
		try {
		Session session =sessionfactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(lieu);
		session.getTransaction().commit();
		System.out.println("Lieu creation succeded");
		return true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Lieu creation failed");
			return false;
		}
	}

}
