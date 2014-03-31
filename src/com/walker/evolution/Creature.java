package com.walker.evolution;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Creature {

	private int perfectness;
	private Genetics genetics;
	private Species species;
	private List<Creature> listOfChildren= new ArrayList<Creature>();
	
//	Can create a Creature from a random genome, or can create one by passing in a genome.
//	All creatures need a perfect Genome.
	public Creature(Species species){
		this.species = species;
		genetics = new Genetics(UUID.randomUUID().toString().replace("-", ""));
	}
	public Creature (Species species, Genetics genetics){
		this.species = species;
		this.genetics = genetics;
	}
	
	//get a creatures genome
	public String getGenome(){
		return genetics.getGenetics();
	}
	public int getPerfectness(){
		return perfectness;
	}
	public void setPerfectness(int perfectness){
		this.perfectness= perfectness; 
	}
	public void addChild(Creature c){
		listOfChildren.add(c);
	}
	public List<Creature> getChildren(){
		return listOfChildren;
	}
	public Genetics getGenetics() {
		return genetics;
	}
	public Species getSpecies() {
		return species;
	}
}
