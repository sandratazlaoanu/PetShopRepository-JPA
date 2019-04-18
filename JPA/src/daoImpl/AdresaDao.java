package daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;
import model.Adresa;

public class AdresaDao implements Dao<Adresa> {
	
	private DatabaseHelper databaseHelper;
	
	public AdresaDao(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<Adresa> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(Adresa.class, id));
	}

	@Override
	public List<Adresa> getAll() {
		TypedQuery<Adresa> query = databaseHelper.getEntityManager().createQuery("SELECT a FROM Adresa a",
				Adresa.class);
		return query.getResultList();
	}

	@Override
	public boolean create(Adresa adresa) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(adresa));
	}

	@Override
	public boolean update(Adresa old, Adresa newObj) {
		old.setJudet(newObj.getJudet());
		old.setOras(newObj.getOras());
		old.setStrada(newObj.getStrada());
		old.setNumar(newObj.getNumar());
		old.setZip(newObj.getZip());
		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(Adresa adresa) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(adresa));
	}

	@Override
	public Adresa findById(int id) {
		
		Adresa toFind = databaseHelper.getEntityManager().find(Adresa.class, id);
		
		return toFind;
	}
	

}