package com.walker.evolution;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public final class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int bestCreature = 0;
		List<Species> listOfSpecies = new ArrayList<Species>();

		Frame frame = new Frame();
		frame.setTitle("Genetics");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		Species alex = new Species("f6e622e2ff23483d8861445945d7d987");
		listOfSpecies.add(alex);
		for (Species species : listOfSpecies) {

			// An amount of Generations to calculate
			for (int i = 0; i < 15; i++) {
				species.copulate(3);
				bestCreature = species.bestChild();

				if (species.bestChild() < 500) { // break if a creature is
													// within 400
					// of the perfect genome
					System.out.println("breaking:\n");
					System.out.println("Generation: " + i
							+ " Number of Creatures: "
							+ species.getPopulation().size() + " best Genome: "
							+ species.bestChild());
					
					int index = 0;
					for (String g : species.getBestCreature().getGenetics()
							.getProperties()) {
						// number syntax
						Color bestColour = parseStringtoColor(species
								.getBestCreature().getGenetics().getProperty(g));
						System.out.println(g
								+ " : "
								+ species.getBestCreature().getGenetics()
										.getProperty(g) + " : " + bestColour);
						frame.addSquare(bestColour, index * 30 + 10);
						index++;
					}
					frame.addBestSquare(parseStringtoColor(species.getPerfectGenetics()
							.getProperty("Speed")));
					break;
				}
				species.prepForNextGen();
			}
		}

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
