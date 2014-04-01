package com.walker.evolution;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public final class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int bestCreature = 0;
		List<Species> listOfSpecies = new ArrayList<Species>();
		Enviroment e = new Enviroment("f6e622e2ff23483d8861445945d7d987");

		Species asexualSpecies = new AsexualSpecies(
				"f6e622e2ff23483d8861445945d7d987");
		listOfSpecies.add(asexualSpecies);
		Species sexualSpecies = new SexualSpecies(
				"f6e622e2ff23483d8861445945d12345");
		listOfSpecies.add(sexualSpecies);

		asexualSpecies.setEnviroment(e);
		sexualSpecies.setEnviroment(e);
		for (int i = 0; i < 5; i++){
			
			for (Species species : listOfSpecies) {
				
				species.initiateReproduction();
			}
		}
		
		for (Species species : listOfSpecies) {
			
			int size = species.getParents().size() + species.getChildren().size();
			System.out.println("Population = " + size);
		}

		// An amount of Generations to calculate
		// for (int i = 0; i < 15; i++) {
		// species.reproduce(creature);
		// bestCreature = species.bestChild();
		//
		// if (species.bestChild() < 500) {
		// // of the perfect genome
		// System.out.println("breaking:\n");
		// System.out.println("Generation: " + i
		// + " Number of Creatures: "
		// + species.getParents().size() + " best Genome: "
		// + species.bestChild());
		//
		// int index = 0;
		// for (String g : species.getBestCreature().getGenetics()
		// .getProperties()) {
		// // number syntax
		// Color bestColour = parseStringtoColor(species
		// .getBestCreature().getGenetics().getProperty(g));
		// System.out.println(g
		// + " : "
		// + species.getBestCreature().getGenetics()
		// .getProperty(g) + " : " + bestColour);
		// index++;
		// }
		// break;
		// }
		// species.prepForNextGen();
		// }

	}

	private static Color parseStringtoColor(String hexstring) {
		Integer i = Integer.parseInt(hexstring.substring(1), 16);
		Color color = new Color(i);
		return color;
	}

	public static Color hex2Rgb(String colorStr) {
		return new Color(Integer.valueOf(colorStr.substring(1, 2), 16),
				Integer.valueOf(colorStr.substring(2, 3), 16), Integer.valueOf(
						colorStr.substring(3, 4), 16));
	}

}
