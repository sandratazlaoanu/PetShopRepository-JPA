package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the angajat database table.
 * 
 */
@Entity
@NamedQuery(name="Angajat.findAll", query="SELECT a FROM Angajat a")
public class Angajat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAngajat;

	private String nume;

	private String prenume;

	private float salariu;

	//bi-directional many-to-one association to PetShop
	@ManyToOne
	@JoinColumn(name="idPetShop")
	private PetShop petShop;

	//bi-directional many-to-one association to AngajatDepartament
	@OneToMany(mappedBy="angajat", fetch=FetchType.EAGER)
	private List<AngajatDepartament> angajatDepartaments;

	public Angajat() {
	}

	public int getIdAngajat() {
		return this.idAngajat;
	}

	public void setIdAngajat(int idAngajat) {
		this.idAngajat = idAngajat;
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

	public float getSalariu() {
		return this.salariu;
	}

	public void setSalariu(float salariu) {
		this.salariu = salariu;
	}

	public PetShop getPetShop() {
		return this.petShop;
	}

	public void setPetShop(PetShop petShop) {
		this.petShop = petShop;
	}

	public List<AngajatDepartament> getAngajatDepartaments() {
		return this.angajatDepartaments;
	}

	public void setAngajatDepartaments(List<AngajatDepartament> angajatDepartaments) {
		this.angajatDepartaments = angajatDepartaments;
	}

	public AngajatDepartament addAngajatDepartament(AngajatDepartament angajatDepartament) {
		getAngajatDepartaments().add(angajatDepartament);
		angajatDepartament.setAngajat(this);

		return angajatDepartament;
	}

	public AngajatDepartament removeAngajatdepartament(AngajatDepartament angajatDepartament) {
		getAngajatDepartaments().remove(angajatDepartament);
		angajatDepartament.setAngajat(null);

		return angajatDepartament;
	}

	@Override
	public String toString() {
		return "Angajat " + idAngajat + " " + nume + " " + prenume + " " + salariu
				+ " " + petShop;
	}

}