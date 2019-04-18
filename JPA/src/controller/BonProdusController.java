package controller;

import java.util.List;

import daoImpl.BonProdusDao;
import helper.DatabaseHelper;
import model.BonFiscal;
import model.BonProdus;
import model.Produs;

/**
 * @author Sandra
 * Util functions for BonProdus
 */
public class BonProdusController {

	private DatabaseHelper dh = DatabaseHelper.getInstance();

	public void printList() {

		BonProdusDao dao = new BonProdusDao(dh);
		List<BonProdus> list = dao.getAll();

		for (BonProdus b : list) {
			System.out.println(b.toString());
		}
	}

	public void create(int id, BonFiscal bonFiscal, Produs produs) {
		BonProdusDao dao = new BonProdusDao(dh);
		if (dao.get(id).isPresent() == true) {
			System.out.println("Already exists..");
		}
		BonProdus newObj = new BonProdus();
		newObj.setIndex(id);
		newObj.setBonFiscal(bonFiscal);
		newObj.setProdus(produs);
		
		dao.create(newObj);
	}

	public void search(int id) {

		BonProdusDao bonProdus = new BonProdusDao(dh);
		System.out.println(bonProdus.findById(id));
	}

	public void update(int id, BonFiscal bonFiscal, Produs produs) {
		BonProdusDao dao = new BonProdusDao(dh);
		BonProdus toFind = dao.findById(id);
		BonProdus newObj = new BonProdus();
		newObj.setIndex(id);
		newObj.setBonFiscal(bonFiscal);
		newObj.setProdus(produs);
		
		dao.update(toFind, newObj);

	}

	public void delete(int id) {

		BonProdusDao dao = new BonProdusDao(dh);
		BonProdus toFind = dao.findById(id);

		dao.delete(toFind);
	}
}
