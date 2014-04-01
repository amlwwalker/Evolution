package com.walker.evolution;

public class Enviroment {

	/*
	 * This class specifies the conditions a species is in.
	 * 
	 * TODO: Later different creatures of the species will be able to 
	 * have different conditions
	 */
	private Conditions conditions;
	public Enviroment(String conditions){
		this.conditions = new Conditions(conditions);
	}
	public double getBirthSuccess(String fertility){
		String property = conditions.getProperty("Fertility");
		int enviromentFertilityConditions = Integer.parseInt(conditions.getProperty("Fertility"), 16);
		int success = Integer.parseInt(fertility, 16) - enviromentFertilityConditions;
		return (success == 0 ? 1 : success / Math.abs(success));
	}
}
