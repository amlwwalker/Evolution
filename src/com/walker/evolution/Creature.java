package com.walker.evolution;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Creature {

//	private String genome;
//	private String perfectGenome;
	private int perfectness;
	private Genetics genetics;
//	private Genetics perfectGenetics;
	private Species species;
	private List<Creature> listOfChildren= new ArrayList<Creature>();
	
//	Can create a Creature from a ranom genome, or can create one by passing in a genome.
//	All creatures need a perfect Genome.
	public Creature(Species species){
		this.species = species;
		genetics = new Genetics(UUID.randomUUID().toString().replace("-", ""));
	}
	public Creature (Species species, String genome){
		this.species = species;
		genetics = new Genetics(genome);
	}
//	public void setPerfectGenome(String perfectGenome){
//		perfectGenetics = new Genetics(perfectGenome);
//	}
	
	//get a creatures genome
	public String getGenome(){
		return genetics.getGenetics();
	}
	//get the perfect form of this creature type
//	public String getPerfectForm(){
//		return perfectGenetics.getGenetics();
//	}
	
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
