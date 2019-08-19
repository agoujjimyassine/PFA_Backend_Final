package ma.infosat.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ContratAssurance implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String numeroPolice;
	@Column
	private Date dateDebut;
	@Column
	private Date dateFin;
	
	@ManyToOne
	private TypeContrat typeContrat;
	
	@ManyToOne
	private AgenceAssurance agenceAssurance;
	
	@ManyToOne
	private Vehicule vehicule;

	public ContratAssurance(String numeroPolice, Date dateDebut, Date dateFin) {
		super();
		this.numeroPolice = numeroPolice;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public ContratAssurance() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroPolice() {
		return numeroPolice;
	}

	public void setNumeroPolice(String numeroPolice) {
		this.numeroPolice = numeroPolice;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	

	public TypeContrat getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}

	public AgenceAssurance getAgenceAssurance() {
		return agenceAssurance;
	}

	public void setAgenceAssurance(AgenceAssurance agenceAssurance) {
		this.agenceAssurance = agenceAssurance;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

}
