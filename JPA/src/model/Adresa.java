package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the adresa database table.
 * 
 */
@Entity
@NamedQuery(name = "Adresa.findAll", query = "SELECT a FROM Adresa a")
public class Adresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int zip;

	private String judet;

	private int numar;

	private String oras;

	private String strada;

	// bi-directional many-to-one association to Petshop
	@OneToMany(mappedBy = "adresa")
	private List<PetShop> petShops;

	public Adresa() {
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getJudet() {
		return this.judet;
	}

	public void setJudet(String judet) {
		this.judet = judet;
	}

	public int getNumar() {
		return this.numar;
	}

	public void setNumar(int numar) {
		this.numar = numar;
	}

	public String getOras() {
		return this.oras;
	}

	public void setOras(String oras) {
		this.oras = oras;
	}

	public String getStrada() {
		return this.strada;
	}

	public void setStrada(String strada) {
		this.strada = strada;
	}

	public List<PetShop> getPetshops() {
		return this.petShops;
	}

	public void setPetshops(List<PetShop> petShops) {
		this.petShops = petShops;
	}

	public PetShop addPetshop(PetShop petShop) {
		getPetshops().add(petShop);
		petShop.setAdresa(this);

		return petShop;
	}

	public PetShop removePetshop(PetShop petShop) {
		getPetshops().remove(petShop);
		petShop.setAdresa(null);

		return petShop;
	}

	@Override
	public String toString() {
		return "Adresa " + zip + " " + judet + " " + numar + " " + oras + " " + strada;
	}

}