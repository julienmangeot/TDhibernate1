package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
	
	public List<Lieu> showLieu() {
		List<Lieu> list = new ArrayList<Lieu>();
		
		try {
			Session session =sessionfactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from Lieu");
			list=query.list();
			System.out.println("Lieu display succeded");
			return list;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Lieu display failed");
			return null;
		}
	}

}
