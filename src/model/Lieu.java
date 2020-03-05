package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lieu {
	@Id
	@GeneratedValue
	private int idLieu;
	private String address;
	private String city;
	
	@OneToMany(mappedBy = "lieu")
	List<Formation> formations;
	
	public Lieu() {
	}
	
	public Lieu(String address, String city) {
		this.address = address;
		this.city = city;
	}

	public int getIdLieu() {
		return idLieu;
	}

	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {
		return "IdLieu=" + idLieu + ", address=" + address + ", city=" + city;
	}

}
