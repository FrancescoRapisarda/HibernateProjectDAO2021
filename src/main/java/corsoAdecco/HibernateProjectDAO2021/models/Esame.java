package corsoAdecco.HibernateProjectDAO2021.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "esame")
public class Esame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "esameID")
	private int id;
	
	@Column
	private String materia;
	
	@Column(name = "data_esame")
	private String dataEsame;
	
	@Column
	private int cfu;

	@ManyToMany
	@JoinTable (name = "studente_esame",
				joinColumns = { @JoinColumn(name = " esame_rif", referencedColumnName = "esameID") },
				inverseJoinColumns = {@JoinColumn(name = "studente_rif", referencedColumnName = "studenteID")}
			)
			
	private List<Studente> elencoStudenti;
	
	
	
	public Esame() {
		
	}
	
	
	public Esame(String materia, String dataEsame, int cfu) {
		super();
		this.materia = materia;
		this.dataEsame = dataEsame;
		this.cfu = cfu;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getDataEsame() {
		return dataEsame;
	}
	public void setDataEsame(String dataEsame) {
		this.dataEsame = dataEsame;
	}
	public int getCfu() {
		return cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}	

	public List<Studente> getElencoStudenti() {
		return elencoStudenti;
	}


	public void setElencoStudenti(List<Studente> elencoStudenti) {
		this.elencoStudenti = elencoStudenti;
	}


	@Override
	public String toString() {
		return "Esame [id=" + id + ", materia=" + materia + ", dataEsame=" + dataEsame + ", cfu=" + cfu + "]";
	}
	
	public void dettaglioEsame() {
		System.out.println("Esame \n"
				+ "id= " + id + "\n"
				+ "materia= " + materia + "\n"
				+ "dataEsame= " + dataEsame + "\n"
				+ "cfu= " + cfu);
	}

}
