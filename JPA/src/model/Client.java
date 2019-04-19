    
package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;

	private String nume;

	private String prenume;

	// bi-directional many-to-one association to BonFiscal
	@OneToMany(mappedBy = "client")
	private List<BonFiscal> bonFiscals;

	// bi-directional many-to-one association to PetShop
	@ManyToOne
	@JoinColumn(name = "idPetShopClient")
	private PetShop petShop;

	public Client() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public List<BonFiscal> getBonFiscals() {
		return this.bonFiscals;
	}

	public void setBonFiscals(List<BonFiscal> bonFiscals) {
		this.bonFiscals = bonFiscals;
	}

	public BonFiscal addBonFiscal(BonFiscal bonFiscal) {
		getBonFiscals().add(bonFiscal);
		bonFiscal.setClient(this);

		return bonFiscal;
	}

	public BonFiscal removeBonfiscal(BonFiscal bonFiscal) {
		getBonFiscals().remove(bonFiscal);
		bonFiscal.setClient(null);

		return bonFiscal;
	}

	public PetShop getPetShop() {
		return this.petShop;
	}

	public void setPetShop(PetShop petShop) {
		this.petShop = petShop;
	}

	@Override
	public String toString() {
		return "Client " + idClient + " " + nume + " " + prenume + " " + bonFiscals + " " + petShop;
	}
}