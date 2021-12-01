package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.hibernate.utils.HibernateUtils;
import com.app.models.Employe;

public class DaoEmploye implements IDao<Employe> {

	Logger logger = Logger.getLogger(DaoEmploye.class);
	
	@Override
	public List<Employe> getAll() {
		Transaction t = null;
		try {
			logger.info("Debut de getAll");
			Session s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			if(!t.isActive())
				t=s.beginTransaction();
			
			List<Employe> emps = s.createNamedQuery("q1").list();
			
			t.commit();
			s.close();
						
			logger.info("Fin de getAll");
			
			return emps;
		}catch (Exception e) {
			logger.error("Erreur : " + e.getMessage());
			t.rollback();
		}
		
		return null;
	}

	@Override
	public Employe getOne(int id) {
		Employe emp = null;
		Transaction t = null;
		try {
			logger.info("Debut de getOne");
			Session s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			
			emp = s.get(Employe.class, id);
			
			t.commit();
			s.close();
			
			logger.info("Fin de getOne");
		}catch (Exception e) {
			logger.error("Erreur : " + e.getMessage());
			t.rollback();
		}
		return emp;
	}

	@Override
	public boolean save(Employe obj) {
		Transaction t = null;
		try {
			logger.info("Debut de save");
			Session s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			
			Integer ee = (Integer) s.save(obj);

			t.commit();
			s.close();
			
			logger.info("Fin de getOne");
			
			if(ee!=null)
				return true;
		}catch (Exception e) {
			logger.error("Erreur : " + e.getMessage());
			t.rollback();
		}
		return false;
	}

	@Override
	public boolean update(Employe obj) {
		Transaction t = null;
		try {
			logger.info("Debut de update");
			Session s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			
			s.update(obj);
			
			t.commit();
			s.close();
			
			logger.info("Fin de update");
			
			return true;
		}catch (Exception e) {
			logger.error("Erreur : " + e.getMessage());
			t.rollback();
		}
		return false;
	}

	@Override
	public boolean delete(Employe obj) {
		Transaction t = null;
		try {
			logger.info("Debut de delete");
			
			Session s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			
			s.delete(obj);
			
			t.commit();
			s.close();
			
			logger.info("Fin de delete");
			return true;
		}catch (Exception e) {
			logger.error("Erreur : " + e.getMessage());
			t.rollback();
		}
		return false;
	}

}
