package com.walker.evolution;

import java.util.ArrayList;
import java.util.List;

public abstract class Species {

	/*
	 * We will always have children and parents. Except the first time
	 * when God performs a miracle.
	 */
	private Genetics perfectGenetics;
	public Species(String perfectGenome){
		perfectGenetics = new Genetics(perfectGenome);
		/*
		 * God is performing a miracle. A seed genome is fed in
		 * as the "perfect Genome"
		 */
	}
	
	//this may be a bad idea - finding the "healthiest" offspring
//	public int bestChild(){
//		//Find the best child of the generation
//		int minimum = listOfChildren.get(0).getPerfectness();
//		for (Creature creature : listOfChildren) {
//				if (creature.getPerfectness() < minimum){
//					minimum = creature.getPerfectness();
//					bestCreature = creature;
//				}
//		}
//		return minimum;
//	}
	
	public String getPerfectGenome() {
		return perfectGenetics.getGenetics();
	}
	public Genetics getPerfectGenetics() {
		return perfectGenetics;
	}

	public abstract void prepForNextGen();
	public abstract Species evolveSpecies();
	public abstract void initiateReproduction();
}
