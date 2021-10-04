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
@Table (name = "studente")  
public class Studente {
	
	@Id														//Dice ad Hibernate che si tratta di una PK!
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//IDENTITY è la strategia di generazione degli ID AUTO_INCREMENT di MySQL 	 
	@Column (name = "studenteID")
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private String facolta;

	@Column (name = "cod_matricola")
	private String matricola;
	
	@ManyToMany
	@JoinTable(name = "studente_esame",
				joinColumns = { @JoinColumn (name = "studente_rif", referencedColumnName = "studenteID") },
				inverseJoinColumns = {@JoinColumn (name = "esame_rif", referencedColumnName = "esameID") } 
			)
	private List<Esame> elencoEsami;
	
	
	
	public Studente() {
		
	}
	
	

	public Studente(String nome, String cognome, String facolta, String matricola) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.facolta = facolta;
		this.matricola = matricola;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getFacolta() {
		return facolta;
	}


	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}


	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


	public List<Esame> getElencoEsami() {
		return elencoEsami;
	}



	public void setElencoEsami(List<Esame> elencoEsami) {
		this.elencoEsami = elencoEsami;
	}



	@Override
	public String toString() {
		return "Studente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", facolta=" + facolta
				+ ", matricola=" + matricola + "]";
	}

	
}
