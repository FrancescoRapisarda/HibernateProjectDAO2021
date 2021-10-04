package corsoAdecco.HibernateProjectDAO2021;

import java.util.ArrayList;

import corsoAdecco.HibernateProjectDAO2021.models.Esame;
import corsoAdecco.HibernateProjectDAO2021.models.Studente;
import corsoAdecco.HibernateProjectDAO2021.models.crud.EsameDAO;
import corsoAdecco.HibernateProjectDAO2021.models.crud.StudenteDAO;



public class App 
{
    public static void main( String[] args )
    {

    	StudenteDAO stuDao = new StudenteDAO();
        
        EsameDAO esaDao = new EsameDAO();
        
        
        
        /*
         * Insert Studente
         */
//      Studente stuUno = new Studente("Jasmine", "Ferretti", "Ingegneria Fisica","UNI000009");
//		Studente stuDue = new Studente("Elody", "Di Pietro", "Ingegneria Aerospaziale","UNI000010");
//		Studente stuTre = new Studente("Gessica", "Lamorgese", "Ingegneria Informatica","UNI000011");
//		
//		stuDao.insert(stuUno);
//		stuDao.insert(stuDue);
//		stuDao.insert(stuTre);
		
        
        /*
         * FindById Studente
         */
//        Studente stuUno = stuDao.findById(2);
//        System.out.println(stuUno);
        
        
        /*
         * Delete id Studente
         */
//        if(stuDao.delete(3)) {
//        	System.out.println("Studente eliminato!");
//        } else {
//        	System.out.println("Errore!");
//        }
        
        
        /*
         * Update Studente
         */
//        Studente stuUno = stuDao.findById(2);
//        stuUno.setNome("Domenico");
//        stuUno.setCognome("Russo");
//		if(stuDao.update(stuUno)) {
//			System.out.println("Update eseguito con successo!");	
//		} else {
//			System.out.println("Errore!");
//		}
		
        
        /*
         * FindAll Studente
         */
//          List<Studente> elencoStudenti = stuDao.findAll();
//          
//          for(int i=0;i<elencoStudenti.size();i++) {
//        	  Studente temp = elencoStudenti.get(i);
//        	  System.out.println(temp);
//          }
        
        
        
        /*
         * INSERT studente
         * INSERT analisiII
         * INSERT fisicaII
         */
//        Studente studente = new Studente("Luca", "Leonardi", "Ingegneria Informatica","UNI000003");
//        
//        Esame analisiII = new Esame("Analisi II", "2021-12-18", 8);
//        Esame fisicaII = new Esame("Fisica II", "2022-02-08", 4);
//        
//        
//        studente.setElencoEsami( new ArrayList<Esame>() );		//Inizializzo il contenitore tramite la SET!
//        studente.getElencoEsami().add(analisiII);
//        studente.getElencoEsami().add(fisicaII);
//        
//        esaDao.insert(analisiII);
//        esaDao.insert(fisicaII);
//        stuDao.insert(studente);
        
        
        
        /*
         * INSERT Studente ed iscrizione ad Esami presenti sul DB
         */
//        Studente stu = new Studente("Sabrina", "Ferreri", "Ingegneria Aerospaziale","UNI000001");
//        
//        Esame fisicaII = esaDao.findById(2);
//        Esame analisiII = esaDao.findById(1);
//        
//        stu.setElencoEsami( new ArrayList<Esame>());
//        stu.getElencoEsami().add(analisiII);				
//        stu.getElencoEsami().add(fisicaII);				
//        
//        esaDao.insert(analisiII);							//L'Esame analisiII ESISTE GIA!
//        esaDao.insert(fisicaII);							//L'Esame fisicaII ESISTE GIA!
//        stuDao.insert(stu);
        
        
        
        /*
         * Penso INVERSAMENTE, creo un Esame e iscrivo uno o piu Studenti
         */
        Esame ana = new Esame("Analisi I", "2021-12-05", 6);
        
        Studente luca = stuDao.findById(1);
        Studente sabrina = stuDao.findById(2);
        
        ana.setElencoStudenti(new ArrayList<Studente>());
        ana.getElencoStudenti().add(sabrina);					
        ana.getElencoStudenti().add(luca);						
        
        stuDao.insert(sabrina);								//Lo Studente sabrina ESISTE GIA!
        stuDao.insert(luca);								//Lo Studente luca ESISTE GIA!
        esaDao.insert(ana);
        
    }
}
