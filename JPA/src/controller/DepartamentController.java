package controller;

import java.util.List;
import daoImpl.DepartamentDao;
import helper.DatabaseHelper;
import model.Departament;

/**
 * @author Sandra
 * Util functions for Departament
 */
public class DepartamentController {

	private DatabaseHelper dh = DatabaseHelper.getInstance();

	public void printList() {

		DepartamentDao dao = new DepartamentDao(dh);
		List<Departament> list = dao.getAll();

		for (Departament d : list) {
			System.out.println(d.toString());
		}
	}

	public void create(int id, String denumire, int numarRaioane) {
		DepartamentDao dao = new DepartamentDao(dh);
		if (dao.get(id).isPresent() == true) {
			System.out.println("Already exists..");
		}
		Departament newObj = new Departament();
		newObj.setIdDepartament(id);
		newObj.setDenumire(denumire);
		newObj.setNrRaioane(numarRaioane);

		dao.create(newObj);
	}

	public void search(int id) {

		DepartamentDao departament = new DepartamentDao(dh);
		System.out.println(departament.findById(id));
	}

	public void update(int id, String denumire, int numarRaioane) {
		DepartamentDao dao = new DepartamentDao(dh);
		Departament toFind = dao.findById(id);
		Departament newObj = new Departament();
		newObj.setIdDepartament(id);
		newObj.setDenumire(denumire);
		newObj.setNrRaioane(numarRaioane);

		dao.update(toFind, newObj);

	}

	public void delete(int id) {

		DepartamentDao dao = new DepartamentDao(dh);
		Departament toFind = dao.findById(id);

		dao.delete(toFind);
	}
}
