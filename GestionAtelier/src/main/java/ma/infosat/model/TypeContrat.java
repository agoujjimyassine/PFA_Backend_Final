package ma.infosat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class TypeContrat implements Serializable{
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "typeContrat")
	private List<ContratAssurance> contratAssurances = new ArrayList<>();
	
	public TypeContrat(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}
	public TypeContrat() {
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
	public List<ContratAssurance> getContratAssurances() {
		return contratAssurances;
	}
	public void setContratAssurances(List<ContratAssurance> contratAssurances) {
		this.contratAssurances = contratAssurances;
	}
	
}
