package daoImpl;

import model.BonFiscal;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;

public class BonFiscalDao implements Dao<BonFiscal> {

	private DatabaseHelper databaseHelper;

	public BonFiscalDao(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<BonFiscal> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(BonFiscal.class, id));
	}

	@Override
	public List<BonFiscal> getAll() {
		TypedQuery<BonFiscal> query = databaseHelper.getEntityManager().createQuery("SELECT b FROM BonFiscal b",
				BonFiscal.class);
		return query.getResultList();
	}

	@Override
	public boolean create(BonFiscal bonFiscal) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(bonFiscal));
	}

	@Override
	public boolean update(BonFiscal old, BonFiscal newObj) {
		old.setData(newObj.getData());
		old.setSuma(newObj.getSuma());

		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(BonFiscal bonFiscal) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(bonFiscal));
	}

	@Override
	public BonFiscal findById(int id) {
		BonFiscal toFind = databaseHelper.getEntityManager().find(BonFiscal.class, id);

		return toFind;
	}

}
