package corsoAdecco.HibernateProjectDAO2021.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import corsoAdecco.HibernateProjectDAO2021.models.Esame;
import corsoAdecco.HibernateProjectDAO2021.models.Studente;

public class GestoreSessioni {
	
	private static GestoreSessioni ogg_gestore;
	private SessionFactory factory;

	public static GestoreSessioni getInstance() {
		
		if(ogg_gestore == null) {
			ogg_gestore = new GestoreSessioni();
		}
		
		return ogg_gestore;
		
	}
	
	public SessionFactory getFactory() {
		
		if(factory == null) {
			factory = new Configuration()
					.configure("resources/hibernate_studente.cfg.xml")
					.addAnnotatedClass(Studente.class)
					.addAnnotatedClass(Esame.class)
					.buildSessionFactory();
		}
		
		return factory;
	}
	
}
