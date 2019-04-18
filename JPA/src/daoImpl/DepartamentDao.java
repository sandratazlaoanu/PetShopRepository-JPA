package daoImpl;

import model.Departament;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;

public class DepartamentDao implements Dao<Departament>{

	private DatabaseHelper databaseHelper;

	public DepartamentDao(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<Departament> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(Departament.class, id));
	}

	@Override
	public List<Departament> getAll() {
		TypedQuery<Departament> query = databaseHelper.getEntityManager().createQuery("SELECT d FROM Departament d",
				Departament.class);
		return query.getResultList();
	}

	@Override
	public boolean create(Departament departament) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(departament));
	}

	@Override
	public boolean update(Departament old, Departament newObj) {
		old.setDenumire(newObj.getDenumire());
		old.setNrRaioane(newObj.getNrRaioane());

		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(Departament departament) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(departament));
	}

	@Override
	public Departament findById(int id) {
		Departament toFind = databaseHelper.getEntityManager().find(Departament.class, id);
		
		return toFind;
	}
}
