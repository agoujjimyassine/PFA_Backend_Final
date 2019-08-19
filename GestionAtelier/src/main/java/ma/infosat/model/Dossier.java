package ma.infosat.model;

import java.io.Serializable;
import java.sql.Date;
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
public class Dossier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String numero;
	@Column
	private Date dateCreation;
	@Column
	private String statut;
	@Column
	private String observation;

	@ManyToOne
	private Vehicule vehicule;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dossier")
	private List<PhaseDossier> phaseDossiers = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "dossier")
	private List<PieceDetachee> pieceDetachees = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "dossier")
	private List<RendezVous> rendezVouss=new ArrayList<>();
	
	@ManyToOne
	private AgenceAssurance agenceAssurance;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dossier")
	private List<ContactDossier> contactDossiers = new ArrayList<>();
	
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private DemandeReparation demandeReparation;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dossier")
	private List<ExpertDossier> expertDossiers = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "dossier")
	private List<Historique> historiques = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "dossier")
	private List<Fichier> fichiers = new ArrayList<>();
		
	public Dossier(String numero, Date dateCreation, String statut, String observation) {
		super();
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.statut = statut;
		this.observation = observation;

	}

	public Dossier() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public List<PhaseDossier> getPhaseDossiers() {
		return phaseDossiers;
	}

	public void setPhaseDossiers(List<PhaseDossier> phaseDossiers) {
		this.phaseDossiers = phaseDossiers;
	}

	public List<RendezVous> getRendezVouss() {
		return rendezVouss;
	}

	public void setRendezVouss(List<RendezVous> rendezVouss) {
		this.rendezVouss = rendezVouss;
	}

	public AgenceAssurance getAgenceAssurance() {
		return agenceAssurance;
	}

	public void setAgenceAssurance(AgenceAssurance agenceAssurance) {
		this.agenceAssurance = agenceAssurance;
	}

	public List<ContactDossier> getContactDossiers() {
		return contactDossiers;
	}

	public void setContactDossiers(List<ContactDossier> contactDossiers) {
		this.contactDossiers = contactDossiers;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ExpertDossier> getExpertDossiers() {
		return expertDossiers;
	}

	public void setExpertDossiers(List<ExpertDossier> expertDossiers) {
		this.expertDossiers = expertDossiers;
	}

	public List<Historique> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public List<Fichier> getFichiers() {
		return fichiers;
	}

	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}

	public List<PieceDetachee> getPieceDetachees() {
		return pieceDetachees;
	}

	public void setPieceDetachees(List<PieceDetachee> pieceDetachees) {
		this.pieceDetachees = pieceDetachees;
	}

	public DemandeReparation getDemandeReparation() {
		return demandeReparation;
	}

	public void setDemandeReparation(DemandeReparation demandeReparation) {
		this.demandeReparation = demandeReparation;
	}

}
