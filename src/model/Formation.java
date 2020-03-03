package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Formation {
	
	//Attributs
	@Id
	@GeneratedValue
	private int idFormation;
	private String theme;
	
	@JoinColumn(name="idLieu")
	@ManyToOne
	private Lieu lieu;
	
	//Constructeurs
	public Formation() {
	}

	public Formation(String theme) {
		this.theme = theme;
	}
	
	//Getters and setters
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public String toString() {
		return "Formation [id=" + idFormation + ", theme=" + theme + "]";
	}

	
}
