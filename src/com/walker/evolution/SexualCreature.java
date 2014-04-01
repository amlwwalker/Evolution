package com.walker.evolution;

import java.util.List;
import java.util.Random;



public class SexualCreature extends Creature{

	private Creature mate;
	private boolean isMated;
	private Sexualities sex;
	private enum Sexualities {
		A, B
	}
	private static final RandomEnum<Sexualities> r = new RandomEnum<Sexualities>(
			Sexualities.class);
	
	public SexualCreature(Species species) {
		super(species);
		sex = r.random();
		isMated(false);
	}
	public SexualCreature(Species species, Genetics genetics){
		super(species, genetics);
		sex = r.random();
	}
	public void setMate(Creature mate){
		this.mate = mate;
	}
	public Creature getMate(){
		return mate;
	}
	private static class RandomEnum<E extends Enum> {

        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[RND.nextInt(values.length)];
        }
    }
	public boolean isMated(){
		return isMated;
	}
	public void isMated(boolean isMated){
		this.isMated = isMated;
	}
	public Sexualities getSex() {
		return sex;
	}
}
