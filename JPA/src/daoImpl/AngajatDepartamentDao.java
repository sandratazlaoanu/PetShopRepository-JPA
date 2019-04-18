package daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;
import model.AngajatDepartament;

public class AngajatDepartamentDao implements Dao<AngajatDepartament>{

	private DatabaseHelper databaseHelper;

	public AngajatDepartamentDao(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<AngajatDepartament> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(AngajatDepartament.class, id));
	}

	@Override
	public List<AngajatDepartament> getAll() {
		TypedQuery<AngajatDepartament> query = databaseHelper.getEntityManager().createQuery("SELECT a FROM AngajatDepartament a",
				AngajatDepartament.class);
		return query.getResultList();
	}

	@Override
	public boolean create(AngajatDepartament angajatDepartament) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(angajatDepartament));
	}

	@Override
	public boolean update(AngajatDepartament old, AngajatDepartament newObj) {
		old.setAngajat(newObj.getAngajat());
		old.setDepartament(newObj.getDepartament());

		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(AngajatDepartament angajatDepartament) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(angajatDepartament));
	}

	@Override
	public AngajatDepartament findById(int id) {
		AngajatDepartament toFind = databaseHelper.getEntityManager().find(AngajatDepartament.class, id);
		
		return toFind;
	}
	
}
