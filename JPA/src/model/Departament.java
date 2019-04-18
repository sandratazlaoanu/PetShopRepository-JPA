package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the departament database table.
 * 
 */
@Entity
@NamedQuery(name = "Departament.findAll", query = "SELECT d FROM Departament d")
public class Departament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDepartament;

	private String denumire;

	private int nrRaioane;

	// bi-directional many-to-one association to Angajatdepartament
	@OneToMany(mappedBy = "departament")
	private List<AngajatDepartament> angajatDepartaments;

	public Departament() {
	}

	public int getIdDepartament() {
		return this.idDepartament;
	}

	public void setIdDepartament(int idDepartament) {
		this.idDepartament = idDepartament;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public int getNrRaioane() {
		return this.nrRaioane;
	}

	public void setNrRaioane(int nrRaioane) {
		this.nrRaioane = nrRaioane;
	}

	public List<AngajatDepartament> getAngajatdepartaments() {
		return this.angajatDepartaments;
	}

	public void setAngajatdepartaments(List<AngajatDepartament> angajatDepartaments) {
		this.angajatDepartaments = angajatDepartaments;
	}

	public AngajatDepartament addAngajatdepartament(AngajatDepartament angajatDepartament) {
		getAngajatdepartaments().add(angajatDepartament);
		angajatDepartament.setDepartament(this);

		return angajatDepartament;
	}

	public AngajatDepartament removeAngajatdepartament(AngajatDepartament angajatDepartament) {
		getAngajatdepartaments().remove(angajatDepartament);
		angajatDepartament.setDepartament(null);

		return angajatDepartament;
	}

	@Override
	public String toString() {
		return "Departament " + idDepartament + " " + denumire + " " + nrRaioane;
	}

}