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
public class Commande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String reference;
	@Column
	private Date dateCreation;
	@Column
	private Double montant;
	
	@ManyToOne
	private Fournisseur fournisseur;
	
	@JsonIgnore
	@OneToMany(mappedBy = "commande")
	private List<PieceDetachee> pieceDetachees = new ArrayList<>();

	public Commande(String reference, Date dateCreation, Double montant) {
		super();
		this.reference = reference;
		this.dateCreation = dateCreation;
		this.montant = montant;
	}

	public Commande() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<PieceDetachee> getPieceDetachees() {
		return pieceDetachees;
	}

	public void setPieceDetachees(List<PieceDetachee> pieceDetachees) {
		this.pieceDetachees = pieceDetachees;
	}
	
}
