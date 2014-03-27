package com.walker.evolution;

public class God {

	/*
	 * The Idea of God, is to take two creatures and output a 
	 * child. 
	 * The number of children can be based on a weighted chance 
	 * of how many are produced. 
	 * The weighting direction depends on the type of creature
	 * 
	 * The output of the parents should produce an offspring
	 * that each of its properties produce four outcomes from:
	 * 
	 * Parent A property *0.5 + Parent B property * 0.5
	 * 
	 */
	private static God instance = null;
	private String alphanumricCharacters = "abcdefghijklmnopqrstuvwxyz0123456789";
	protected God(){
	}
	
	public static God getInstance(){
		if (instance == null){
			instance = new God();
		}
		return instance;
	}
	
	public String evolveCreature(Creature creature){
		
		 String currentGenome = creature.getGenome();
//		char[] characters = currentGenome.toCharArray();
		   int characterToChange = (int)(Math.random() * currentGenome.length());
		   int newCharacter = (int) (Math.random()*36);
//		   String temp = alphanumricCharacters.substring(newCharacter, newCharacter+1);
//		   characters[characterToChange] = temp.toCharArray()[0];
//		   String valueOf = new String (characters);
		   return changeCharInPosition(characterToChange, alphanumricCharacters.substring(newCharacter, newCharacter+1).toCharArray()[0], currentGenome);
	}
	public String changeCharInPosition(int position, char ch, String str){
	    char[] charArray = str.toCharArray();
	    charArray[position] = ch;
	    return new String(charArray);
	}
}
