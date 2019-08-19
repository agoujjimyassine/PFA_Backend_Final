package ma.infosat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class AgenceAssurance implements Serializable{
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
	private String telephone;
	@Column
	private String email;
	@Column
	private String adresse;
	@Column
	private String ville;
	@Column
	private String fax;
	@Column
	private String description;

	@JsonIgnore
	@OneToMany
	private List<ContratAssurance> contratAssurances = new ArrayList<>();

	@ManyToOne
	private CompagnieAssurance compagnieAssurance;

	@JsonIgnore
	@OneToMany(mappedBy = "agenceAssurance")
	private List<Dossier> dossiers = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "agenceAssurance")
	private List<Contact> contacts = new ArrayList<>();

	public AgenceAssurance(String raisonSociale, String telephone, String email, String adresse, String ville,
			String fax, String description) {
		super();
		this.raisonSociale = raisonSociale;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.fax = fax;
		this.description = description;
	}

	public AgenceAssurance() {
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CompagnieAssurance getCompagnieAssurance() {
		return compagnieAssurance;
	}

	public void setCompagnieAssurance(CompagnieAssurance compagnieAssurance) {
		this.compagnieAssurance = compagnieAssurance;
	}

	public List<ContratAssurance> getContratAssurances() {
		return contratAssurances;
	}

	public void setContratAssurances(List<ContratAssurance> contratAssurances) {
		this.contratAssurances = contratAssurances;
	}

	public List<Dossier> getDossiers() {
		return dossiers;
	}

	public void setDossiers(List<Dossier> dossiers) {
		this.dossiers = dossiers;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
