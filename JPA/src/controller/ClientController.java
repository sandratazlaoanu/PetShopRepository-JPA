package controller;

import java.util.List;

import daoImpl.ClientDao;
import daoImpl.PetShopDao;
import helper.DatabaseHelper;
import model.Client;

/**
 * @author Sandra
 * Util functions for Client
 */
public class ClientController {

	private DatabaseHelper dh = DatabaseHelper.getInstance();
	
	public void printList() {

		ClientDao dao = new ClientDao(dh);
		List<Client> list = dao.getAll();

		for (Client c : list) {
			System.out.println(c.toString());
		}
	}

	public void create(int id, String nume, String prenume, int idPetShop) {
		ClientDao dao = new ClientDao(dh);
		PetShopDao psDao = new PetShopDao(dh);
		
		if (dao.get(id).isPresent() == true) {
			System.out.println("Already exists..");
		}
		Client newObj = new Client();
		newObj.setIdClient(id);
		newObj.setNume(nume);
		newObj.setPrenume(prenume);
		
		newObj.setPetShop(psDao.findById(idPetShop));
		
		dao.create(newObj);
	}

	public void search(int id) {

		ClientDao client = new ClientDao(dh);
		System.out.println(client.findById(id));
	}

	public void update(int id, String nume, String prenume) {
		ClientDao dao = new ClientDao(dh);
		Client toFind = dao.findById(id);
		Client newObj = new Client();
		newObj.setIdClient(id);
		newObj.setNume(nume);
		newObj.setPrenume(prenume);
		
		dao.update(toFind, newObj);

	}

	public void delete(int id) {

		ClientDao dao = new ClientDao(dh);
		Client toFind = dao.findById(id);

		dao.delete(toFind);
	}
}
