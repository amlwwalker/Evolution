package com.walker.evolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * To create a creature, first you must define its perfect form. Once
		 * you have a perfect creature type, you can generate a creature. Its
		 * "perfect form" defines its type. The evolution of a creature will
		 * always head for that perfection.
		 */
		List<Creature> listOfParents = new ArrayList<Creature>();
		List<Creature> listOfChildren = new ArrayList<Creature>();

		listOfParents = God.getInstance().performMiracle(
				"f6e622e2ff23483d8861445945d7d987");
		int bestCreature = 0;
		for (int i = 0; i < 20; i++) { // do for 5 generations

			for (Creature creature : listOfParents) {

				God.getInstance().evolveCreature(creature, 3);

//				System.out.println("Genome: " + creature.getGenome()
//						+ "\nChildG: "
//						+ creature.getChildren().get(0).getGenome()
//						+ " Perfection: "
//						+ God.getInstance().calculatePerfection(creature));
				creature.setPerfectness(God.getInstance().calculatePerfection(
						creature));
				God.getInstance().killWorstChild(creature);
				listOfChildren.addAll(creature.getChildren());
			}

			System.out.println(listOfParents.size() + " : "
					+ listOfChildren.size());

			// All parents die. Children become parents.
			listOfParents.clear();
			listOfParents.addAll(listOfChildren);
			listOfChildren.clear();
			System.out.println(listOfParents.size() + " : "
					+ listOfChildren.size());
			
			int minimum = listOfParents.get(0).getPerfectness();
			for (Creature creature : listOfParents) {
				System.out.println(creature.getPerfectness());
					if (creature.getPerfectness() < minimum){
						minimum = creature.getPerfectness();
					}
			}
			bestCreature = minimum;
			if (bestCreature < 300){ //break if a creature is within 400 of the perfect genome
				System.out.println("breaking:\n");
				System.out.println("Generation: " + i + " Number of Creatures: " + listOfParents.size() + " best Genome: " + bestCreature);
				break;
			}
		}

		// now we have a new creature
		// one option is to just kill the worst creature.
	}

}
