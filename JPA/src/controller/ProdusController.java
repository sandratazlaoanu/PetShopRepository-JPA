package controller;

import java.util.List;

import daoImpl.ProdusDao;
import helper.DatabaseHelper;
import model.Produs;

/**
 * @author Sandra
 * Util functions for Produs
 */
public class ProdusController {

	private DatabaseHelper dh = DatabaseHelper.getInstance();

	public void printList() {

		ProdusDao dao = new ProdusDao(dh);
		List<Produs> list = dao.getAll();

		for (Produs b : list) {
			System.out.println(b.toString());
		}
	}

	public void create(int id, String denumire, int cantitate, float pret) {
		ProdusDao dao = new ProdusDao(dh);
		if (dao.get(id).isPresent() == true) {
			System.out.println("Already exists..");
		}
		Produs newObj = new Produs();
		newObj.setIdProdus(id);
		newObj.setDenumire(denumire);
		newObj.setCantitate(cantitate);
		newObj.setPret(pret);

		dao.create(newObj);
	}

	public void search(int id) {

		ProdusDao produs = new ProdusDao(dh);
		System.out.println(produs.findById(id));
	}

	public void update(int id, String denumire, int cantitate, float pret) {
		ProdusDao dao = new ProdusDao(dh);
		Produs toFind = dao.findById(id);
		Produs newObj = new Produs();
		newObj.setIdProdus(id);
		newObj.setDenumire(denumire);
		newObj.setCantitate(cantitate);
		newObj.setPret(pret);

		dao.update(toFind, newObj);

	}

	public void delete(int id) {

		ProdusDao dao = new ProdusDao(dh);
		Produs toFind = dao.findById(id);

		dao.delete(toFind);
	}
}
