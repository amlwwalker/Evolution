package com.walker.evolution;

import java.util.UUID;

public class Creature {

	private String genome;
	private String perfectGenome;
	public Creature(String perfectGenome){
		this.perfectGenome = perfectGenome;
		
		genome = UUID.randomUUID().toString().replace("-", "");
//		System.out.println("new Creature = " + perfectGenome);
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
	
	//find out how close the creature is to its perfect form.
	public int getPerfectness(){
		return compareTo(getPerfectForm());
	}
}
