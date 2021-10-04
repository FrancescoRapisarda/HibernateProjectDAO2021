package corsoAdecco.HibernateProjectDAO2021.models.crud;

import java.util.List;

import org.hibernate.Session;

import corsoAdecco.HibernateProjectDAO2021.db.GestoreSessioni;
import corsoAdecco.HibernateProjectDAO2021.models.Studente;

public class StudenteDAO implements Dao<Studente> {
	

	@Override
	public void insert(Studente t) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
				
			sessione.beginTransaction();
			sessione.save(t);
			sessione.getTransaction().commit();			//porta a termine la transazione e perpetua la modifica con "commit"!
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			sessione.close();
		}
		
	}

	@Override
	public Studente findById(int id) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			Studente temp = sessione.get(Studente.class, id);
			
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
	public List<Studente> findAll() {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
				
		try {
			
			sessione.beginTransaction();
			
			List<Studente> elenco = sessione.createQuery("FROM Studente").list();
			
			sessione.getTransaction();
			
			return elenco;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			sessione.close();
		}
		
	}
	

	@Override
	public boolean delete(Studente t) {

		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			sessione.delete(t);
			
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
			
			// .get()  cerca l'oggetto se non esiste restituisce NULL!
			// .load() cerca l'oggetto se non esiste va in Exception! salta l'istruzione sessione.remove().
			// Questo è importante perchè le operazioni nel DB sono molto onerose, il DB è occupato a rispondere a milioni di persone a volte!
			
			Studente temp = sessione.load(Studente.class, id);  //la load ha la certezza di caricare l'oggetto dal database!
			
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
	public boolean update(Studente t) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
//			int id = t.getId();										//ID Studente inserito nel metodo.
//			Studente temp = sessione.load(Studente.class, id);		//Studente sul DB che devo modificare!
//			
//			temp.setNome(t.getNome());
//			temp.setCognome(t.getCognome());
//			temp.setFacolta(t.getFacolta());
//			temp.setMatricola(t.getMatricola());
//			
//			sessione.update(temp);
			
			sessione.update(t);			//CON HIBERNATE CI SIAMO RISPARMIATI TUTTA QUELLA RIGA DI CODICE SU!!!
			
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
