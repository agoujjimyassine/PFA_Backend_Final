package ma.infosat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PieceDetachee implements Serializable{
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
	private String nom;
	@Column
	private Double prix;
	@Column
	private Integer quantite;
	
	@ManyToOne
	private Dossier dossier;
		
	@ManyToOne
	private Commande commande;
	
	@ManyToOne
	private EtatPiece etatPiece;

	public PieceDetachee(String reference, String nom, Double prix) {
		super();
		this.reference = reference;
		this.nom = nom;
		this.prix = prix;
	}

	public PieceDetachee() {
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

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public EtatPiece getEtatPiece() {
		return etatPiece;
	}

	public void setEtatPiece(EtatPiece etatPiece) {
		this.etatPiece = etatPiece;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
}
