package ma.infosat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tache implements Serializable{

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
	private String description;
	@Column
	private Integer importance;
	
	@ManyToOne
	private DemandeReparation demandeReparation;

	public Tache(String nom, String description, Integer importance) {
		super();
		this.nom = nom;
		this.description = description;
		this.importance = importance;
	}

	public Tache() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getImportance() {
		return importance;
	}

	public void setImportance(Integer importance) {
		this.importance = importance;
	}

	public DemandeReparation getDemandeReparation() {
		return demandeReparation;
	}

	public void setDemandeReparation(DemandeReparation demandeReparation) {
		this.demandeReparation = demandeReparation;
	}
	
}
