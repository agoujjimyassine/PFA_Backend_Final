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
public class Phase implements Serializable{
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
private String ordre;

@JsonIgnore
@OneToMany(mappedBy = "phase")
private List<PhaseDossier> phaseDossier = new ArrayList<>();

public Phase(String nom, String ordre) {
	super();
	this.nom = nom;
	this.ordre = ordre;
	
}
public Phase() {
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
public String getOrdre() {
	return ordre;
}
public void setOrdre(String ordre) {
	this.ordre = ordre;
}
public List<PhaseDossier> getPhaseDossier() {
	return phaseDossier;
}
public void setPhaseDossier(List<PhaseDossier> phaseDossier) {
	this.phaseDossier = phaseDossier;
}

}
