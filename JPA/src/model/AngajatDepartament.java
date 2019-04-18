package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the angajatdepartament database table.
 * 
 */
@Entity
@NamedQuery(name="Angajatdepartament.findAll", query="SELECT a FROM AngajatDepartament a")
public class AngajatDepartament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int index;

	//bi-directional many-to-one association to Angajat
	@ManyToOne
	@JoinColumn(name="idAngajat")
	private Angajat angajat;

	//bi-directional many-to-one association to Departament
	@ManyToOne
	@JoinColumn(name="idDepartament")
	private Departament departament;

	public AngajatDepartament() {
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Angajat getAngajat() {
		return this.angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}

	public Departament getDepartament() {
		return this.departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
	
	@Override
	public String toString() {
		return "AngajatDepartament " + index + " " + angajat + " " + departament;
	}

}