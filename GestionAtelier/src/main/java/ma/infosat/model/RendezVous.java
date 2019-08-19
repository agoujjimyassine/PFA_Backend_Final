package ma.infosat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
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
public class RendezVous implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private Date dateTimeRdv;
	@Column
	private int dure;
	@Column
	private String rapport;
	@Column
	private String note;
	
	@ManyToOne
	private Contact contact;
	
	@ManyToOne
	private StatutRdv statutRdv;
	
	@ManyToOne
	private Motif motif;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rendezVous")
	private List<CollaborateurRdv> collaborateurRdv = new ArrayList<>();
	
	@ManyToOne
	private Dossier dossier;

	public RendezVous(Date dateTimeRdv, int dure, String rapport, String note) {
		super();
		this.dateTimeRdv = dateTimeRdv;
		this.dure = dure;
		this.rapport = rapport;
		this.note = note;
	}

	public RendezVous() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateTimeRdv() {
		return dateTimeRdv;
	}

	public void setDateTimeRdv(Date dateTimeRdv) {
		this.dateTimeRdv = dateTimeRdv;
	}

	public int getDure() {
		return dure;
	}

	public void setDure(int dure) {
		this.dure = dure;
	}

	public String getRapport() {
		return rapport;
	}

	public void setRapport(String rpport) {
		this.rapport = rpport;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public StatutRdv getStatutRdv() {
		return statutRdv;
	}

	public void setStatutRdv(StatutRdv statutRdv) {
		this.statutRdv = statutRdv;
	}

	public Motif getMotif() {
		return motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}

	public List<CollaborateurRdv> getCollaborateurRdv() {
		return collaborateurRdv;
	}

	public void setCollaborateurRdv(List<CollaborateurRdv> collaborateurRdv) {
		this.collaborateurRdv = collaborateurRdv;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

}
