package com.walker.evolution;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Creature {

	private String genome;
	private String perfectGenome;
	private int perfectness;
	private List<Creature> listOfChildren= new ArrayList<Creature>();
	
//	Can create a Creature from a ranom genome, or can create one by passing in a genome.
//	All creatures need a perfect Genome.
	public Creature(){
		genome = UUID.randomUUID().toString().replace("-", "");
	}
	public Creature (String genome){
		this.genome = genome;
	}
	public void setPerfectGenome(String perfectGenome){
		this.perfectGenome = perfectGenome;
	}
	
	//comparing two creatures for likeness.
	public int compareTo(Creature creature){
		 String creatureIdentity = creature.genome;
	      int result = genome.compareTo(creatureIdentity);
	      return result;
	}
	//compare the genome of two creatures
	public int compareTo(String genome){
		int result = this.genome.compareTo(genome);
		return result;
	}
	//get a creatures genome
	public String getGenome(){
		return genome;
	}
	//set a creatures genome (God)
	public void setGenome(String string){
		genome = string;
	}
	//get the perfect form of this creature type
	public String getPerfectForm(){
		return perfectGenome;
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
}
