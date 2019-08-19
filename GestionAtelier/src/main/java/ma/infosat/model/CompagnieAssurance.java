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
public class CompagnieAssurance implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column	
private Integer id;
@Column	
private String raisonSociale;
@Column	
private String logo;

@JsonIgnore
@OneToMany(mappedBy = "compagnieAssurance")
private List<AgenceAssurance> agenceAssurance = new ArrayList<>();
public CompagnieAssurance(String raisonSociale, String logo) {
	super();
	this.raisonSociale = raisonSociale;
	this.logo = logo;
}
public CompagnieAssurance() {
	super();
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getRaisonSociale() {
	return raisonSociale;
}
public void setRaisonSociale(String raisonSociale) {
	this.raisonSociale = raisonSociale;
}
public String getLogo() {
	return logo;
}
public void setLogo(String logo) {
	this.logo = logo;
}
public List<AgenceAssurance> getAgenceAssurance() {
	return agenceAssurance;
}
public void setAgenceAssurance(List<AgenceAssurance> agenceAssurance) {
	this.agenceAssurance = agenceAssurance;
}

}
