package sn.boom.javaws.dao;

import java.util.List;

public interface IDao<T> {
	
	public void create(T obj) throws Exception;
	
	public T read(Integer id) throws Exception;
	
	public void update(T obj) throws Exception;
	
	public void delete(Integer id) throws Exception;
	
	public List<T> list() throws Exception;
}
