package dao;

import java.util.List;
import java.util.Optional;

/**
 * Generic interface for DAO purposes
 * All CRUD options to be implemented in classes. 
 * 
 * @param <T> Generic parameter
 */

public interface Dao<T> {
	Optional<T> get(int id);
	
	List<T> getAll();
	
	boolean create(T t);
	
	boolean update(T old, T newObj);
	
	boolean delete(T t);
	
	T findById(int id);
}
