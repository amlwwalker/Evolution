package com.walker.evolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * To create a creature, first you must define its perfect form. 
		 * Once you have a perfect creature type, you can generate a creature.
		 * Its "perfect form" defines its type.
		 * The evolution of a creature will always head for that perfection.
		 * 
		 */
		List<Creature> listOfCreatures = new ArrayList<Creature>();
		for (int i = 0; i < 5; i++){
			Creature creature1 = new Creature("f6e622e2ff23483d8861445945d7d987");
			listOfCreatures.add(creature1);
		}

		for (Creature creature : listOfCreatures) {
			String currentGenome = creature.getGenome();
			God.getInstance().calculatePerfection(creature);
			creature.setGenome(God.getInstance().evolveCreature(creature));
			System.out.println("Old genome: " + currentGenome + "\nNew Genome: " + creature.getGenome() + " Perfection: " + God.getInstance().calculatePerfection(creature));
			creature.setPerfectness(God.getInstance().calculatePerfection(creature));
		}
		
		int best = listOfCreatures.get(0).getPerfectness();
		Creature newCreature = listOfCreatures.get(0);
		for (Creature creature : listOfCreatures) {
			System.out.println("Perfectness: " + creature.getPerfectness() + " Best: " + best);
			if (creature.getPerfectness() < best){
				best = creature.getPerfectness();
				newCreature = creature;
			}
		}
		System.out.println("Best: " + best);
		//now we have a new creature
		//one option is to just kill the worst creature.
	}

}
