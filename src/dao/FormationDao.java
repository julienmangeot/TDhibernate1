package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Formation;
import model.Lieu;

public class FormationDao implements IFormationDao{
	
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionfactory.openSession();

	
	public boolean createFormation(Formation formation) {
		try {
			session.beginTransaction();
			session.save(formation);
			session.getTransaction().commit();
			session.close();
			System.out.println("Formation creation succeded");
			return true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Formation creation failed");
			return false;
		}
	}

	public List<Formation> showFormations() {
		List<Formation> list = new ArrayList<Formation>();
		try {
			session.beginTransaction();
			SQLQuery query= session.createSQLQuery("Select * from Formation");
			query.addEntity(Formation.class);
			list= query.list();
			session.close();
			System.out.println("Formation display succeded");
			return list;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Formation display failed");
			return null;
		}
	}

	public List<Formation> getFormations(Lieu lieu){
		List<Formation> list = new ArrayList<Formation>();
		try {
			session.beginTransaction();
			Query query= session.createQuery("from Formation where lieu.idLieu= :idLieu");
			query.setParameter("idLieu", lieu.getIdLieu());
			list= query.list();
			session.close();
			System.out.println("Formation with Lieu display succeded");
			return list;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Formation with Lieu display failed");
			return null;
		}
	}
}
