package controller;

import java.util.List;

import daoImpl.AdresaDao;
import helper.DatabaseHelper;
import model.Adresa;

/**
 * @author Sandra
 * Util functions for Adresa
 */
public class AdresaController {

	private DatabaseHelper dh = DatabaseHelper.getInstance();

	public void printList() {

		AdresaDao dao = new AdresaDao(dh);
		List<Adresa> list = dao.getAll();

		for (Adresa a : list) {
			System.out.println(a.toString());
		}
	}

	public void create(int zip, String judet, String oras, String strada, int numar) {
		AdresaDao dao = new AdresaDao(dh);
		if (dao.get(zip).isPresent() == true) {
			System.out.println("Already exists..");
		}
		Adresa newObj = new Adresa();
		newObj.setZip(zip);
		newObj.setJudet(judet);
		newObj.setOras(oras);
		newObj.setStrada(strada);
		newObj.setNumar(numar);
		dao.create(newObj);
	}

	public void search(int zip) {

		AdresaDao a = new AdresaDao(dh);
		System.out.println(a.findById(zip));
	}

	public void update(int zip, String judet, String oras, String strada, int numar) {
		AdresaDao dao = new AdresaDao(dh);
		Adresa toFind = dao.findById(zip);
		Adresa newObj = new Adresa();
		newObj.setZip(zip);
		newObj.setJudet(judet);
		newObj.setOras(oras);
		newObj.setStrada(strada);
		newObj.setNumar(numar);

		dao.update(toFind, newObj);

	}

	public void delete(int zip) {

		AdresaDao dao = new AdresaDao(dh);
		Adresa toFind = dao.findById(zip);

		dao.delete(toFind);
	}
}
