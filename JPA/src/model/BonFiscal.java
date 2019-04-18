package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the bonfiscal database table.
 * 
 */
@Entity
@NamedQuery(name = "Bonfiscal.findAll", query = "SELECT b FROM BonFiscal b")
public class BonFiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBonFiscal;

	@Temporal(TemporalType.DATE)
	private Date data;

	private float suma;

	// bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;

	// bi-directional many-to-one association to Bonprodus
	@OneToMany(mappedBy = "bonFiscal")
	private List<BonProdus> bonproduses;

	public BonFiscal() {
	}

	public int getIdBonFiscal() {
		return this.idBonFiscal;
	}

	public void setIdBonFiscal(int idBonFiscal) {
		this.idBonFiscal = idBonFiscal;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getSuma() {
		return this.suma;
	}

	public void setSuma(float suma) {
		this.suma = suma;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<BonProdus> getBonproduses() {
		return this.bonproduses;
	}

	public void setBonproduses(List<BonProdus> bonproduses) {
		this.bonproduses = bonproduses;
	}

	public BonProdus addBonprodus(BonProdus bonProdus) {
		getBonproduses().add(bonProdus);
		bonProdus.setBonFiscal(this);

		return bonProdus;
	}

	public BonProdus removeBonprodus(BonProdus bonProdus) {
		getBonproduses().remove(bonProdus);
		bonProdus.setBonFiscal(null);

		return bonProdus;
	}

	@Override
	public String toString() {
		return "BonFiscal " + idBonFiscal + " " + data + " " + suma + " " + client;
	}

}