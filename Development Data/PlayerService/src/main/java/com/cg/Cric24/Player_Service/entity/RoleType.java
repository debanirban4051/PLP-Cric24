package com.cg.Cric24.Player_Service.entity;

public enum RoleType {

	WICKET_KEEPER("Wicketkeeper"), BATSMAN("Batsman"), BOWLER("Bowler");

	private String typeValue;

	private RoleType(String type) {
		typeValue = type;
	}
	
	public String getValue() {
		return typeValue;
	}

}
