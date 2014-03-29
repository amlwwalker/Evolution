package com.walker.evolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int bestCreature = 0;
		List<Species> listOfSpecies = new ArrayList<Species>();

		Species alex = new Species("f6e622e2ff23483d8861445945d7d987");
		listOfSpecies.add(alex);
		// An amount of Generations to calculate
		for (Species species : listOfSpecies) {

				species.copulate(3);
				bestCreature = species.bestChild();
				species.prepForNextGen();

				if (bestCreature < 300) { // break if a creature is within 400
											// of the perfect genome
					break;
				}
				System.out.println("breaking:\n");
				System.out.println("Generation: " + 0
						+ " Number of Creatures: "
						+ species.getPopulation().size() + " best Genome: "
						+ bestCreature);
		}

	}

}
