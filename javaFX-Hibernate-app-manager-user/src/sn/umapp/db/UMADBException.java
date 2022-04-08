package sn.umapp.db;

import java.sql.SQLException;

public class UMADBException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UMADBException(String msg) {
		super(msg);
	}

}
