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
	private String alphanumricCharacters = "abcdefghijklmnopqrstuvwxyz0123456789";

	protected God() {
	}

	public static God getInstance() {
		if (instance == null) {
			instance = new God();
		}
		return instance;
	}

	public void evolveCreature(Creature creature, int number) {

		String currentGenome = creature.getGenome();
		char[] characters = currentGenome.toCharArray();
		for (int i = 0; i < number; i++){
			
		int characterToChange = (int) (Math.random() * currentGenome.length());
		int newCharacter = (int) (Math.random() * 36);
		String temp = alphanumricCharacters.substring(newCharacter,
				newCharacter + 1);
		characters[characterToChange] = temp.toCharArray()[0];
		String valueOf = new String(characters);

		Creature child = new Creature(valueOf);
		child.setPerfectGenome(creature.getPerfectForm());
		child.setPerfectness(God.getInstance().calculatePerfection(child));
		creature.addChild(child);
		}
	}

	public int calculatePerfection(Creature creature) {

		char[] genome = creature.getGenome().toCharArray();
		char[] perfection = creature.getPerfectForm().toCharArray();
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
//				System.out.println("Perfectness: " + creature.getPerfectness()
//						+ " Worst: " + worst);
			}
		}
		System.out.println("Worst: " + worst);
		children.remove(newCreature);
	}
	
	public List<Creature> performMiracle(String perfectGenome){
		List<Creature> listOfFirstGens = new ArrayList<Creature>();
		
		for (int i = 0; i < 5; i++){
			Creature creature = new Creature();
			creature.setPerfectGenome(perfectGenome);
			listOfFirstGens.add(creature);
		}
		return listOfFirstGens;
	}
}
