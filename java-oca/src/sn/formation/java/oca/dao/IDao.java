package sn.formation.java.oca.dao;

import java.util.List;

public interface IDao<T> {
	
	public void create(T entity) throws Exception;
	public T read(int id) throws Exception;
	public List<T> list() throws Exception;
	public void update(T entity) throws Exception;
	public void delete(int id) throws Exception;

}
