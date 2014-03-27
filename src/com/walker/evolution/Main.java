package com.walker.evolution;

import java.util.ArrayList;
import java.util.List;

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
		//Creating a creature with the type: f6e622e2ff23483d8861445945d7d987
		for (int i = 0; i < 10; i++){
			Creature creature1 = new Creature("f6e622e2ff23483d8861445945d7d987");
//			System.out.println("Perfectness: " + creature1.compareTo(creature1.getPerfectForm()));
			listOfCreatures.add(creature1);
		}

		
//		System.out.println(creature2.compareTo("45daf9ef38f94cfa8b4b77562622dc78"));
		for (Creature creature : listOfCreatures) {
			String currentGenome = creature.getGenome();
			System.out.println("Perfectness: " + creature.getPerfectness());
			creature.setGenome(God.getInstance().evolveCreature(creature));
			System.out.println("Old genome: " + currentGenome + "\nNew Genome: " + creature.getGenome());
			System.out.println("Perfectness: " + creature.getGenome().compareTo(currentGenome));
		}
	}

}
