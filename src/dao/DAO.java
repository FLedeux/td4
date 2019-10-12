package dao;

public interface DAO<T> {
	

	public abstract boolean create(T object);
	public abstract boolean update(T object);
	public abstract boolean delete(T object);

}
