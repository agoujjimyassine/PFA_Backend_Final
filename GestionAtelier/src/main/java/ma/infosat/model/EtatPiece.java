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
public class EtatPiece implements Serializable{

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
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "etatPiece")
	private List<PieceDetachee> pieceDetachees = new ArrayList<>();
	
	public EtatPiece(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}
	
	public EtatPiece() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PieceDetachee> getPieceDetachees() {
		return pieceDetachees;
	}

	public void setPieceDetachees(List<PieceDetachee> pieceDetachees) {
		this.pieceDetachees = pieceDetachees;
	}
	
}
