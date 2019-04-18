package daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;
import model.BonProdus;

public class BonProdusDao implements Dao<BonProdus>{

	private DatabaseHelper databaseHelper;

	public BonProdusDao(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<BonProdus> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(BonProdus.class, id));
	}

	@Override
	public List<BonProdus> getAll() {
		TypedQuery<BonProdus> query = databaseHelper.getEntityManager().createQuery("SELECT b FROM BonProdus b",
				BonProdus.class);
		return query.getResultList();
	}

	@Override
	public boolean create(BonProdus bonFiscal) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(bonFiscal));
	}

	@Override
	public boolean update(BonProdus old, BonProdus newObj) {
		old.setBonFiscal(newObj.getBonFiscal());
		old.setProdus(newObj.getProdus());

		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(BonProdus bonProdus) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(bonProdus));
	}

	@Override
	public BonProdus findById(int id) {
		BonProdus toFind = databaseHelper.getEntityManager().find(BonProdus.class, id);
		
		return toFind;
	}
}
