package sn.umapp.model;

public enum Role {
	

	SIMPLE_USER("SIMPLE USER"),
    ADMINISTRATEUR("ADMINISTRAEUR");
	
	private String value;
	
	private Role(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
