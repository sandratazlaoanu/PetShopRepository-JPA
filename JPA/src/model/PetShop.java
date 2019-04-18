package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the petshop database table.
 * 
 */
@Entity
@NamedQuery(name="Petshop.findAll", query="SELECT p FROM PetShop p")
public class PetShop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPetShop;

	private String email;

	private String nrTelefon;

	private String nume;

	//bi-directional many-to-one association to Angajat
	@OneToMany(mappedBy="petShop")
	private List<Angajat> angajats;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="petShop")
	private List<Client> clients;

	//bi-directional many-to-one association to Furnizor
	@OneToMany(mappedBy="petShop")
	private List<Furnizor> furnizors;

	//bi-directional many-to-one association to Adresa
	@ManyToOne
	@JoinColumn(name="zip")
	private Adresa adresa;

	public PetShop() {
	}

	public int getIdPetShop() {
		return this.idPetShop;
	}

	public void setIdPetShop(int idPetShop) {
		this.idPetShop = idPetShop;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNrTelefon() {
		return this.nrTelefon;
	}

	public void setNrTelefon(String nrTelefon) {
		this.nrTelefon = nrTelefon;
	}

	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public List<Angajat> getAngajats() {
		return this.angajats;
	}

	public void setAngajats(List<Angajat> angajats) {
		this.angajats = angajats;
	}

	public Angajat addAngajat(Angajat angajat) {
		getAngajats().add(angajat);
		angajat.setPetShop(this);

		return angajat;
	}

	public Angajat removeAngajat(Angajat angajat) {
		getAngajats().remove(angajat);
		angajat.setPetShop(null);

		return angajat;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setPetShop(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setPetShop(null);

		return client;
	}

	public List<Furnizor> getFurnizors() {
		return this.furnizors;
	}

	public void setFurnizors(List<Furnizor> furnizors) {
		this.furnizors = furnizors;
	}

	public Furnizor addFurnizor(Furnizor furnizor) {
		getFurnizors().add(furnizor);
		furnizor.setPetShop(this);

		return furnizor;
	}

	public Furnizor removeFurnizor(Furnizor furnizor) {
		getFurnizors().remove(furnizor);
		furnizor.setPetShop(null);

		return furnizor;
	}

	public Adresa getAdresa() {
		return this.adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	
	@Override
	public String toString() {
		return "PetShop " + idPetShop + "/nEmail: " + email + "/nNrTelefon: " + nrTelefon + "/nNnume: " + nume
				+ "/nAdresa:" + adresa;
	}

}