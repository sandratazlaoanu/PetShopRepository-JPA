package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bonprodus database table.
 * 
 */
@Entity
@NamedQuery(name="Bonprodus.findAll", query="SELECT b FROM BonProdus b")
public class BonProdus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int index;

	//bi-directional many-to-one association to BonFiscal
	@ManyToOne
	@JoinColumn(name="idBonFiscal")
	private BonFiscal bonFiscal;

	//bi-directional many-to-one association to Produs
	@ManyToOne
	@JoinColumn(name="idProdus")
	private Produs produs;

	public BonProdus() {
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public BonFiscal getBonFiscal() {
		return this.bonFiscal;
	}

	public void setBonFiscal(BonFiscal bonFiscal) {
		this.bonFiscal = bonFiscal;
	}

	public Produs getProdus() {
		return this.produs;
	}

	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	
	@Override
	public String toString() {
		return "BonProdus " + index + " " + bonFiscal + " " + produs;
	}


}