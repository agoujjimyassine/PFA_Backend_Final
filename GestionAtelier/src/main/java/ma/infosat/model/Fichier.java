package ma.infosat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fichier implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String nom;
	@Column
	private String chemin;
	
	@ManyToOne
	private TypeFichier typeFichier;
	
	@ManyToOne
	private Dossier dossier;

	public Fichier(String nom, String chemin) {
		super();
		this.nom = nom;
		this.chemin = chemin;
	}

	public Fichier() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public TypeFichier getTypeFichier() {
		return typeFichier;
	}

	public void setTypeFichier(TypeFichier typeFichier) {
		this.typeFichier = typeFichier;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

}
