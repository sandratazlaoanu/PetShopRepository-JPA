package controller;

import java.util.List;

import daoImpl.AngajatDao;
import daoImpl.PetShopDao;
import helper.DatabaseHelper;
import model.Angajat;

/**
 * @author Sandra
 * Util functions for Angajat
 */
public class AngajatController {

	private DatabaseHelper dh = DatabaseHelper.getInstance();

	public void printList() {

		AngajatDao dao = new AngajatDao(dh);
		List<Angajat> list = dao.getAll();

		for (Angajat a : list) {
			System.out.println(a.toString());
		}
	}

	public void create(int id, String nume, String prenume, float salariu, int idPetShop) {
		AngajatDao dao = new AngajatDao(dh);
		PetShopDao psDao = new PetShopDao(dh);
		if (dao.get(id).isPresent() == true) {
			System.out.println("Already exists..");
		}
		Angajat newObj = new Angajat();
		newObj.setNume(nume);
		newObj.setPrenume(prenume);
		newObj.setSalariu(salariu);
		
		newObj.setPetShop(psDao.findById(idPetShop));
		
		dao.create(newObj);
	}

	public void search(int id) {

		AngajatDao a = new AngajatDao(dh);
		System.out.println(a.findById(id));
	}

	public void update(int id, String nume, String prenume, float salariu){
		AngajatDao dao = new AngajatDao(dh);
		Angajat toFind = dao.findById(id);
		Angajat newObj = new Angajat();
		newObj.setNume(nume);
		newObj.setPrenume(prenume);
		newObj.setSalariu(salariu);

		dao.update(toFind, newObj);

	}

	public void delete(int id) {

		AngajatDao dao = new AngajatDao(dh);
		Angajat toFind = dao.findById(id);

		dao.delete(toFind);
	}
}
