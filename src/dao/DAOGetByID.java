package dao;

public interface DAOGetByID<T> extends DAO<T>{

	public abstract T getById(int id);
	
}
