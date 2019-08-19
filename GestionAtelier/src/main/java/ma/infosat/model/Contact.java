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
public class Contact implements Serializable{
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
	private String prenom;
	@Column
	private String poste;
	@Column
	private String telephone;
	@Column
	private String email;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Expert expert;
	
	@ManyToOne
	private TypeContact typeContact;
	
	@JsonIgnore
	@OneToMany(mappedBy = "contact")
	private List<ContactDossier> contactDossiers = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "contact")
	private List<RendezVous> rendezVous = new ArrayList<>();
	
	@ManyToOne
	private AgenceAssurance agenceAssurance;

	public Contact(String nom, String prenom, String poste, String telephone, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
		this.telephone = telephone;
		this.email = email;
	}

	public Contact() {
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public TypeContact getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(TypeContact typeContact) {
		this.typeContact = typeContact;
	}

	public List<ContactDossier> getContactDossiers() {
		return contactDossiers;
	}

	public void setContactDossiers(List<ContactDossier> contactDossiers) {
		this.contactDossiers = contactDossiers;
	}

	public List<RendezVous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}

	public AgenceAssurance getAgenceAssurance() {
		return agenceAssurance;
	}

	public void setAgenceAssurance(AgenceAssurance agenceAssurance) {
		this.agenceAssurance = agenceAssurance;
	}

}
