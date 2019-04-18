package daoImpl;

import model.Produs;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;

public class ProdusDao implements Dao<Produs> {

	private DatabaseHelper databaseHelper;

	public ProdusDao(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<Produs> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(Produs.class, id));
	}

	@Override
	public List<Produs> getAll() {
		TypedQuery<Produs> query = databaseHelper.getEntityManager().createQuery("SELECT p FROM Produs p",
				Produs.class);
		return query.getResultList();
	}

	@Override
	public boolean create(Produs produs) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(produs));
	}

	@Override
	public boolean update(Produs old, Produs newObj) {
		old.setDenumire(newObj.getDenumire());
		old.setCantitate(newObj.getCantitate());
		old.setPret(newObj.getPret());
		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(Produs produs) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(produs));
	}

	@Override
	public Produs findById(int id) {
		Produs toFind = databaseHelper.getEntityManager().find(Produs.class, id);

		return toFind;
	}

}
