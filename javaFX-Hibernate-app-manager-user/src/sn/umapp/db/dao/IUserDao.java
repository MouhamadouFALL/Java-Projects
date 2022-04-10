package sn.umapp.db.dao;

import java.util.List;

import sn.umapp.db.UMADBException;
import sn.umapp.model.User;

/**
 * @author nabyFall
 *
 */
public interface IUserDao {

	
	/**
	 * @param user
	 * @throws UMADBException
	 */
	void create(User user) throws UMADBException;
	
	/**
	 * @param id
	 * @return
	 * @throws UMADBException
	 */
	User read(Integer id) throws UMADBException;
	
	/**
	 * @param user
	 * @throws UMADBException
	 */
	void update(User user) throws UMADBException;
	
	/**
	 * @param id
	 * @throws UMADBException
	 */
	void delete(Integer id) throws UMADBException;
	
	/**
	 * @return
	 * @throws UMADBException
	 */
	List<User> list() throws UMADBException;
}
