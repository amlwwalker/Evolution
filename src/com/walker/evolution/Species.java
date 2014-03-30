package com.walker.evolution;

import java.util.ArrayList;
import java.util.List;

public class Species {

	/*
	 * We will always have children and parents. Except the first time
	 * when God performs a miracle.
	 */
	private List<Creature> listOfParents = new ArrayList<Creature>();
	private List<Creature> listOfChildren = new ArrayList<Creature>();
	private Genetics perfectGenetics;
	private Creature bestCreature;
	
	public Species(String perfectGenome){
		perfectGenetics = new Genetics(perfectGenome);
		
		/*
		 * God is performing a miracle. A seed genome is fed in
		 * as the "perfect Genome"
		 */
		listOfParents = God.getInstance().performMiracle(
				this);
		
	}
	public void copulate(int childCount){
		for (Creature creature : listOfParents) {
			//For each creature, create a number of children
			//in the process of "evolution"
			God.getInstance().evolveCreature(creature, childCount);
			
			//Let a creature know its perfectness so that God can ask for it later. How humiliating
//			creature.setPerfectness(God.getInstance().calculatePerfection(
//					creature));
			//Kill a parents worst quality child - its weak
			God.getInstance().killWorstChild(creature);
			//Add all the children to the list of all children of this creature type
			listOfChildren.addAll(creature.getChildren());
		}
		//how many parents : children
	}
	
	public int bestChild(){
		//Find the best child of the generation
		int minimum = listOfChildren.get(0).getPerfectness();
		for (Creature creature : listOfChildren) {
				if (creature.getPerfectness() < minimum){
					minimum = creature.getPerfectness();
					bestCreature = creature;
				}
		}
		return minimum;
	}
	
	public void prepForNextGen(){
		// All parents die. Children become parents.
		listOfParents.clear();
		listOfParents.addAll(listOfChildren);
		//Clear the children as they are now ready to be the next generations parents
		listOfChildren.clear();
	}
	public String getPerfectGenome() {
		return perfectGenetics.getGenetics();
	}
	public Genetics getPerfectGenetics() {
		return perfectGenetics;
	}
	public List<Creature> getPopulation() {
		return listOfParents;
	}
	public Creature getBestCreature() {
		return bestCreature;
	}
}
