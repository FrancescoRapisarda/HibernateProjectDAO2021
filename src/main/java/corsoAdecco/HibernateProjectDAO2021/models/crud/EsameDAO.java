package corsoAdecco.HibernateProjectDAO2021.models.crud;

import java.util.List;

import org.hibernate.Session;

import corsoAdecco.HibernateProjectDAO2021.db.GestoreSessioni;
import corsoAdecco.HibernateProjectDAO2021.models.Esame;

public class EsameDAO implements Dao<Esame> {

	
	@Override
	public void insert(Esame t) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			sessione.save(t);
			sessione.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
	}
	

	@Override
	public Esame findById(int id) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			Esame temp = sessione.get(Esame.class, id);
			
			sessione.getTransaction().commit();
			
			return temp;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
		return null;
	}

	
	@Override
	public List<Esame> findAll() {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			List<Esame> elenco = sessione.createQuery("FROM Esame").list();
			
			sessione.getTransaction().commit();
			
			return elenco;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
			
		} finally {
			sessione.close();
		}
		
	}

	
	@Override
	public boolean delete(Esame t) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			sessione.remove(t);
			
			sessione.getTransaction().commit();
			
			return true;
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			
			sessione.close();
		
		}
		
		return false;
	}

	
	@Override
	public boolean delete(int id) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			Esame temp = sessione.load(Esame.class, id);
			
			sessione.remove(temp);
			
			sessione.getTransaction().commit();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
		return false;
	}

	@Override
	public boolean update(Esame t) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			sessione.save(t);
			
			sessione.getTransaction().commit();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
		return false;
	}

}
