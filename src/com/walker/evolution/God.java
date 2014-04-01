package com.walker.evolution;

import java.util.ArrayList;
import java.util.List;

public class God {

	/*
	 * The Idea of God, is to take two creatures and output a child. The number
	 * of children can be based on a weighted chance of how many are produced.
	 * The weighting direction depends on the type of creature
	 * 
	 * The output of the parents should produce an offspring that each of its
	 * properties produce four outcomes from:
	 * 
	 * Parent A property *0.5 + Parent B property * 0.5
	 */
	private static God instance = null;
	private String alphanumricCharacters = "0123456789abcdef";

	protected God() {
	}

	public static God getInstance() {
		if (instance == null) {
			instance = new God();
		}
		return instance;
	}

	public Genetics evolveGenetics(Genetics genetics) {

		String currentGenome = genetics.getGenetics();
		char[] characters = currentGenome.toCharArray();
			
		int characterToChange = (int) (Math.random() * currentGenome.length());
		int newCharacter = (int) (Math.random() * 16);
		String temp = alphanumricCharacters.substring(newCharacter,
				newCharacter + 1);
		characters[characterToChange] = temp.toCharArray()[0];
		String valueOf = new String(characters);
		
		return new Genetics(valueOf);
	}

	public int calculatePerfection(Creature creature) {

		char[] genome = creature.getGenome().toCharArray();
		char[] perfection = creature.getSpecies().getPerfectGenome().toCharArray();
		int total = 0;
		for (int i = 0; i < creature.getGenome().length(); i++) {
			total += Math.pow(Math.pow(perfection[i] - genome[i], 2), 0.5);
		}
		return total;
	}

	public void killWorstChild(Creature parent) {

		List<Creature> children = parent.getChildren();
		int worst = 0;
		Creature newCreature = children.get(0);
		for (Creature creature : children) {
			if (creature.getPerfectness() > worst) {
				worst = creature.getPerfectness();
				newCreature = creature;
			}
		}
		children.remove(newCreature);
	}
	
	public List<ASexualCreature> performMiracle(Species species){
		List<ASexualCreature> listOfFirstGens = new ArrayList<ASexualCreature>();
		
		for (int i = 0; i < 2; i++){
			ASexualCreature creature = new ASexualCreature(species);
			listOfFirstGens.add(creature);
		}
		return listOfFirstGens;
	}
}
