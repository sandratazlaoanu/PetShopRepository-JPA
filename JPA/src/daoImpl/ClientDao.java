package daoImpl;

import model.Client;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;

public class ClientDao implements Dao<Client> {

	private DatabaseHelper databaseHelper;

	public ClientDao(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<Client> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(Client.class, id));
	}

	@Override
	public List<Client> getAll() {
		TypedQuery<Client> query = databaseHelper.getEntityManager().createQuery("SELECT c FROM Client c",
				Client.class);
		return query.getResultList();
	}

	@Override
	public boolean create(Client client) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(client));
	}

	@Override
	public boolean update(Client old, Client newObj) {
		old.setNume(newObj.getNume());
		old.setPrenume(newObj.getPrenume());
		

		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(Client client) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(client));
	}

	@Override
	public Client findById(int id) {
		Client toFind = databaseHelper.getEntityManager().find(Client.class, id);
		
		return toFind;
	}
}
