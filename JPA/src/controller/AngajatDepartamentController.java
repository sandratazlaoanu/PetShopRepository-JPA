package controller;

import java.util.List;

import daoImpl.AngajatDepartamentDao;
import helper.DatabaseHelper;
import model.Angajat;
import model.AngajatDepartament;
import model.Departament;

/**
 * @author Sandra
 * Util functions for Angajat Departament
 */
public class AngajatDepartamentController {

	private DatabaseHelper dh = DatabaseHelper.getInstance();

	public void printList() {

		AngajatDepartamentDao dao = new AngajatDepartamentDao(dh);
		List<AngajatDepartament> list = dao.getAll();

		for (AngajatDepartament a : list) {
			System.out.println(a.toString());
		}
	}

	public void create(int id, Angajat angajat, Departament departament) {
		AngajatDepartamentDao dao = new AngajatDepartamentDao(dh);
		if (dao.get(id).isPresent() == true) {
			System.out.println("Already exists..");
		}
		AngajatDepartament newObj = new AngajatDepartament();
		newObj.setIndex(id);
		newObj.setAngajat(angajat);
		newObj.setDepartament(departament);

		dao.create(newObj);
	}

	public void search(int id) {

		AngajatDepartamentDao angajatDepartament = new AngajatDepartamentDao(dh);
		System.out.println(angajatDepartament.findById(id));
	}

	public void update(int id, Angajat angajat, Departament departament) {
		AngajatDepartamentDao dao = new AngajatDepartamentDao(dh);
		AngajatDepartament toFind = dao.findById(id);
		AngajatDepartament newObj = new AngajatDepartament();
		newObj.setIndex(id);
		newObj.setAngajat(angajat);
		newObj.setDepartament(departament);

		dao.update(toFind, newObj);

	}

	public void delete(int id) {

		AngajatDepartamentDao dao = new AngajatDepartamentDao(dh);
		AngajatDepartament toFind = dao.findById(id);

		dao.delete(toFind);
	}
}
