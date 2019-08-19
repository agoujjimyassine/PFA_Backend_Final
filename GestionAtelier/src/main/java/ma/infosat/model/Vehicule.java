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
public class Vehicule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String immatriculation;
	@Column
	private String numeroSerie;
	@Column
	private Date dateCirculation;
	@Column
	private int kilometrage;
	@Column
	private String referenceCouleur;
	@Column
	private String proprietaire;
	@Column
	private String couleur;
	@Column
	private String description;
	
	@ManyToOne
	private PuissanceFiscale  puissanceFiscale;
	
	@ManyToOne
	private TypeCarburant  typeCarburant;
	
	@ManyToOne
	private ModeleVehicule  modeleVehicule;
	
	@ManyToOne
	private MarqueVehicule  marqueVehicule;
	
	@JsonIgnore
	@OneToMany(mappedBy = "vehicule")
	private List<Dossier> dossiers = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "vehicule")
	private List<ContratAssurance> contratsAssurances = new ArrayList<>();
	
	public Vehicule(String immatriculation, String numeroSerie, Date dateCirculation, int kilometrage,
			String referenceCouleur, String proprietaire, String couleur, String description) {
		super();
		this.immatriculation = immatriculation;
		this.numeroSerie = numeroSerie;
		this.dateCirculation = dateCirculation;
		this.kilometrage = kilometrage;
		this.referenceCouleur = referenceCouleur;
		this.proprietaire = proprietaire;
		this.couleur = couleur;
		this.description = description;
	}
	public Vehicule() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public Date getDateCirculation() {
		return dateCirculation;
	}
	public void setDateCirculation(Date dateCirculation) {
		this.dateCirculation = dateCirculation;
	}
	public int getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}
	public String getReferenceCouleur() {
		return referenceCouleur;
	}
	public void setReferenceCouleur(String referenceCouleur) {
		this.referenceCouleur = referenceCouleur;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PuissanceFiscale getPuissanceFiscale() {
		return puissanceFiscale;
	}
	public void setPuissanceFiscale(PuissanceFiscale puissanceFiscale) {
		this.puissanceFiscale = puissanceFiscale;
	}
	public TypeCarburant getTypeCarburant() {
		return typeCarburant;
	}
	public void setTypeCarburant(TypeCarburant typeCarburant) {
		this.typeCarburant = typeCarburant;
	}
	public ModeleVehicule getModeleVehicule() {
		return modeleVehicule;
	}
	public void setModeleVehicule(ModeleVehicule modeleVehicule) {
		this.modeleVehicule = modeleVehicule;
	}
	public List<Dossier> getDossiers() {
		return dossiers;
	}
	public void setDossiers(List<Dossier> dossiers) {
		this.dossiers = dossiers;
	}
	public List<ContratAssurance> getContratsAssurances() {
		return contratsAssurances;
	}
	public void setContratsAssurances(List<ContratAssurance> contratsAssurances) {
		this.contratsAssurances = contratsAssurances;
	}
	public MarqueVehicule getMarqueVehicule() {
		return marqueVehicule;
	}
	public void setMarqueVehicule(MarqueVehicule marqueVehicule) {
		this.marqueVehicule = marqueVehicule;
	}
	
}
