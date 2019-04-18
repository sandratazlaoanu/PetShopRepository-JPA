package controller;

import java.util.List;

import daoImpl.FurnizorDao;
import helper.DatabaseHelper;
import model.Furnizor;

/**
 * @author Sandra
 * Util functions for Furnizor
 */
public class FurnizorController {

private DatabaseHelper dh = DatabaseHelper.getInstance();
	
	public void printList() {

		FurnizorDao dao = new FurnizorDao(dh);
		List<Furnizor> list = dao.getAll();

		for (Furnizor f : list) {
			System.out.println(f.toString());
		}
	}

	public void create(int id, String denumire, String cont) {
		FurnizorDao dao = new FurnizorDao(dh);
		if (dao.get(id).isPresent() == true) {
			System.out.println("Already exists..");
		}
		Furnizor newObj = new Furnizor();
		newObj.setIdFurnizor(id);
		newObj.setDenumire(denumire);
		newObj.setIdCont(cont);
		
		dao.create(newObj);
	}

	public void search(int id) {

		FurnizorDao furnizor = new FurnizorDao(dh);
		System.out.println(furnizor.findById(id));
	}

	public void update(int id, String denumire, String cont) {
		FurnizorDao dao = new FurnizorDao(dh);
		Furnizor toFind = dao.findById(id);
		Furnizor newObj = new Furnizor();
		newObj.setIdFurnizor(id);
		newObj.setDenumire(denumire);
		newObj.setIdCont(cont);
		
		dao.update(toFind, newObj);

	}

	public void delete(int id) {

		FurnizorDao dao = new FurnizorDao(dh);
		Furnizor toFind = dao.findById(id);

		dao.delete(toFind);
	}
}
