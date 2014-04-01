package com.walker.evolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SexualSpecies extends Species {

	private Map<SexualCreature, SexualCreature> partners = new HashMap<SexualCreature, SexualCreature>();
//	private List<SexualCreature> listOfParents = new ArrayList<SexualCreature>();
//	private List<SexualCreature> listOfChildren = new ArrayList<SexualCreature>();

	public SexualSpecies(String perfectGenome) {
		super(perfectGenome);
		/*
		 * An sexual creature must find a mate before it can mutiple However it
		 * can multiply more than once, change its mate and also survive the
		 * process
		 */

		// temporary creation of sexual creatures to test reproduction

		for (int i = 0; i < 10; i++) {
			SexualCreature temp = new SexualCreature(this);
			listOfParents.add(temp);

		}
	}

	public void reproduce(SexualCreature creature1, SexualCreature creature2) {

//		boolean testFertility = testFertility(creature1);
//		System.out.println("Testing fertility: " + testFertility);
		if (!testFertility(creature1) || !testFertility(creature2)) {
			System.out.println("It found a mate, but they aren't fertile!");
			return;
		}
		System.out.println("Pair are fertile!");
		// add here any restrictions on the two reproducing
		List<SexualCreature> offspring = new ArrayList<SexualCreature>();
		// in here merge the two genes
		for (int i = 0; i < 1; i++) {
			Genetics mergedGenes = mergeGenes(creature1.getGenetics(),
					creature2.getGenetics());
			offspring.add(new SexualCreature(this, mergedGenes));
		}

		for (Creature c : offspring) {
			// test for evolution...
		}
		listOfChildren.addAll(offspring);
	}

	private Genetics mergeGenes(Genetics g1, Genetics g2) {
		Genetics genetics = new Genetics((g1.getGenetics() + g2.getGenetics()));
		// evolve the resulting genetics of the parents
		return God.getInstance().evolveGenetics(genetics);
	}

	@Override
	public void prepForNextGen() {
		/*
		 * Nothing is different for the next generation. A child becomes a
		 * parent when it gets children.
		 */
		for (SexualCreature c : getParents()) {
			c.isMated(false);
		}
		listOfParents.addAll(listOfChildren);
		listOfChildren.clear();
	}

	public void findMates() {
		Random randomizer = new Random();
		List<SexualCreature> tempList = (List<SexualCreature>)(List<?>) listOfParents;
		for (SexualCreature c : tempList) {
			if (c.isMated()) {
				System.out.println("Is Mated! " + c.toString());
				continue;
			}
			// if the potential mate is not of the same sex and is not already mated.
			SexualCreature random = (SexualCreature) tempList.get(randomizer
					.nextInt(tempList.size()));
			
			if (!random.isMated() && c.getSex() != random.getSex()) {
				System.out.println("Found a Mate! " + c.toString() + " : "
						+ random.toString());
				c.setMate(random);
				random.setMate(c);
				partners.put(c, random);
				c.isMated(true);
				random.isMated(true);
			} else {
				System.out.println("Didnt Find a mate. " + c.toString());
			}
		}
	}

	@Override
	public Species evolveSpecies() {
		// if a child evolves a certain amount it becomes a new species.
		// Definitions of evolved species will be required
		// for this to work.
		return null;
	}

	public List<SexualCreature> getParents() {
		// TODO Auto-generated method stub
		return (List<SexualCreature>)(List<?>) listOfParents;
	}

	public List<SexualCreature> getChildren() {
		// TODO Auto-generated method stub
		return (List<SexualCreature>)(List<?>) listOfChildren;
	}

	@Override
	public void initiateReproduction() {
		/*
		 * Loop through all the parents and start reproducing.
		 * 
		 * Firstly they must find a mate. Only the ones mated can reproduce. .
		 */
		findMates();
		System.out.println("Sexual Species: " + partners.size());
		Iterator it = partners.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			reproduce((SexualCreature) pairs.getKey(),
					(SexualCreature) pairs.getValue());
			it.remove();
		}
		prepForNextGen();
	}
	private boolean testFertility(SexualCreature creature){
		double enviromentQuality = enviroment.getBirthSuccess(creature.getGenetics().getProperty("Fertility"));
		if (enviromentQuality < 0.5){
			return true;
		}
		return false;
	}

}
