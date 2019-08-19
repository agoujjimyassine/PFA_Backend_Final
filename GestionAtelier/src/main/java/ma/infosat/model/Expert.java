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
public class Expert implements Serializable{
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
	private String adreese;
	@Column
	private String ville;
	
	@JsonIgnore
	@OneToMany(mappedBy = "expert")
	private List<Contact> contacts = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "expert")
	private List<ExpertDossier> expertDossiers = new ArrayList<>();

	public Expert(String raisonSociale, String telephone, String email, String adreese, String ville) {
		super();
		this.raisonSociale = raisonSociale;
		this.telephone = telephone;
		this.email = email;
		this.adreese = adreese;
		this.ville = ville;
	}

	public Expert() {
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

	public String getAdreese() {
		return adreese;
	}

	public void setAdreese(String adreese) {
		this.adreese = adreese;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<ExpertDossier> getExpertDossiers() {
		return expertDossiers;
	}

	public void setExpertDossiers(List<ExpertDossier> expertDossiers) {
		this.expertDossiers = expertDossiers;
	}

}
