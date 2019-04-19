package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produs database table.
 * 
 */
@Entity
@NamedQuery(name="Produs.findAll", query="SELECT p FROM Produs p")
public class Produs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProdus;

	private int cantitate;

	private String denumire;

	private float pret;

	//bi-directional many-to-one association to Bonprodus
	@OneToMany(mappedBy="produs")
	private List<BonProdus> bonproduses;

	//bi-directional many-to-one association to Furnizor
	@ManyToOne
	@JoinColumn(name="idFurnizor")
	private Furnizor furnizor;

	public Produs() {
	}

	public int getIdProdus() {
		return this.idProdus;
	}

	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	public int getCantitate() {
		return this.cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public float getPret() {
		return this.pret;
	}

	public void setPret(float pret) {
		this.pret = pret;
	}

	public List<BonProdus> getBonproduses() {
		return this.bonproduses;
	}

	public void setBonproduses(List<BonProdus> bonproduses) {
		this.bonproduses = bonproduses;
	}

	public BonProdus addBonprodus(BonProdus bonProdus) {
		getBonproduses().add(bonProdus);
		bonProdus.setProdus(this);

		return bonProdus;
	}

	public BonProdus removeBonprodus(BonProdus bonProdus) {
		getBonproduses().remove(bonProdus);
		bonProdus.setProdus(null);

		return bonProdus;
	}

	public Furnizor getFurnizor() {
		return this.furnizor;
	}

	public void setFurnizor(Furnizor furnizor) {
		this.furnizor = furnizor;
	}

}