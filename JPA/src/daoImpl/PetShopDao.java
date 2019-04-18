package daoImpl;

import model.PetShop;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;

public class PetShopDao implements Dao<PetShop> {

	private DatabaseHelper databaseHelper;

	public PetShopDao(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<PetShop> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(PetShop.class, id));
	}

	@Override
	public List<PetShop> getAll() {
		TypedQuery<PetShop> query = databaseHelper.getEntityManager().createQuery("SELECT p FROM PetShop p",
				PetShop.class);
		return query.getResultList();
	}

	@Override
	public boolean create(PetShop petShop) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(petShop));
	}

	@Override
	public boolean update(PetShop old, PetShop newObj) {
		old.setEmail(newObj.getEmail());
		old.setNrTelefon(newObj.getNrTelefon());
		old.setNume(newObj.getNume());
		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(PetShop petShop) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(petShop));
	}

	@Override
	public PetShop findById(int id) {
		PetShop toFind = databaseHelper.getEntityManager().find(PetShop.class, id);

		return toFind;
	}
}
