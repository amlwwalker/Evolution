package com.walker.evolution;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Genetics {
	
	private List<String> properties = new ArrayList<String>();
	private HashMap<String, String> DNA = new HashMap<String, String>();
	private List<String> splices = new ArrayList<String>();
	private String genetics;
	/*
	 * Genetics can either tell you the genetics of a creature as an output to the user
	 * Or it can take two sets of genetics and blend them into an offspring
	 * Which God can then decide whether or not to mutate.
	 * 
	 * The genetics map will be required when decisions over natural selection
	 * are made based on an enviromental situation.
	 */
	public Genetics(String genetics){
		this.genetics = genetics;
		
		initiateProperties();
		for (int i = 0; i < 32; i = i + 2){
			String substring = genetics.substring(i, i + 2);
			splices.add(substring);
		}
		for (int i=0; i<properties.size(); i++) {
		      DNA.put(properties.get(i), splices.get(i));
//		      System.out.println(properties.get(i) + " : " + splices.get(i));
		    }
	}
	
	private void initiateProperties(){
//		can have up to 32 properties 
		properties.add("Strength"); //can hunt for bigger food with less help
		properties.add("Speed"); //can catch faster food with less help
		properties.add("Eye Sight"); //can see food further away
		properties.add("Jealousy"); //potential for killing a more successful hunter
		properties.add("tactics"); //understanding of group work
		properties.add("Kindness"); //chance that will give away food to others, affected by other persons strength and kindness
		properties.add("Fertility"); //Capability of having offspring
		/*
		 * possibly so a creature can evolve into another creature
		 * i.e if its "Species" property changes to another
		 * it becomes that
		 */
		properties.add("Species");
	}
	public List<String> getProperties(){
	
		return properties;
	}
	public String getProperty(String property){
		return DNA.get(property);
	}
	public int getPropertyAsValue(String property, String perfection){
		char[] genome = property.toCharArray();
		return 0;
	}
	
	public String toHex(String arg) {
			return String.format("%x", new BigInteger(1, arg.getBytes()));
		}

	public String getGenetics() {
		return genetics;
	}
}
