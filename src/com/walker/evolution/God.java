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
		char[] characters = currentGenome.toCharArray();
		   int characterToChange = (int)(Math.random() * currentGenome.length());
		   int newCharacter = (int) (Math.random()*36);
		   String temp = alphanumricCharacters.substring(newCharacter, newCharacter+1);
		   characters[characterToChange] = temp.toCharArray()[0];
		   String valueOf = new String (characters);
//		   return changeCharInPosition(characterToChange, alphanumricCharacters.substring(newCharacter, newCharacter+1).toCharArray()[0], currentGenome);
		   return valueOf;
	}
	
	public int calculatePerfection(Creature creature){
		
		/*
		 *  turn both strings into char arrays.
		 *  take each character in a row and compare to the other
		 *  add total to a score. Remember to take absolute
		 *  
		 */
		char[] genome = creature.getGenome().toCharArray();
		char[] perfection = creature.getPerfectForm().toCharArray();
		int total = 0;
		for (int i = 0; i < creature.getGenome().length(); i++){
			total += Math.pow(Math.pow(perfection[i] - genome[i], 2), 0.5);
//			System.out.println(Math.pow(Math.pow(perfection[i] - genome[i], 2), 0.5) + " total: " + total);
		}
		return total;
	}
	public String changeCharInPosition(int position, char ch, String str){
	    char[] charArray = str.toCharArray();
	    charArray[position] = ch;
	    return new String(charArray);
	}
}
