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
public class PhaseDossier implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private Integer id;
@Column
private Date dateDebut;
@Column
private Date dateFin;

@ManyToOne
private Dossier  dossier;

@ManyToOne
private Phase  phase;

public PhaseDossier(Date dateDebut, Date dateFin) {
	super();
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
}
public PhaseDossier() {
	super();
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
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
public Dossier getDossier() {
	return dossier;
}
public void setDossier(Dossier dossier) {
	this.dossier = dossier;
}
public Phase getPhase() {
	return phase;
}
public void setPhase(Phase phase) {
	this.phase = phase;
}


}
