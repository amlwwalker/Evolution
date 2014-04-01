package com.walker.evolution;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Environment;

public class AsexualSpecies extends Species {
	
	//one evolved species per asexual species.
	private SexualSpecies evolvedSpecies = null;
	public AsexualSpecies(String perfectGenome) {
		super(perfectGenome);
		listOfParents = (List<Creature>)(List<?>) God.getInstance().performMiracle(
				this);
	}

	public void reproduce(ASexualCreature creature) {
//		asexual species reproduce by mitosis;
//		I.e they copy themselves
//		God can choose to evolve the produced version.
		boolean testFertility = testFertility(creature);
		if (!testFertility)
			return;
		for (int i = 0; i < 6; i++){
//			if (getEnviroment().getBirthSuccess(creature.getGenetics().getProperty("Fertility")));
			listOfChildren.add(new ASexualCreature(this, God.getInstance().evolveGenetics(((Creature) creature).getGenetics())));
		}
	}

	public SexualSpecies createEvolvedSpecies(){ 
		//TODO: Work out how to create genetics for new species.
		if (evolvedSpecies == null){
			evolvedSpecies =  new SexualSpecies("f6e622e2ff23483d8861445945d7d987");
			return evolvedSpecies;
		} else {
			return evolvedSpecies;
		}
	}
	public SexualSpecies getEvolvedSpecies(){
		return evolvedSpecies;
	}
	
	@Override
	public void prepForNextGen() {
			// All parents die. Children become parents.
			listOfParents.clear();
			listOfParents.addAll(listOfChildren);
			//Clear the children as they are now ready to be the next generations parents
			listOfChildren.clear();
		}

	@Override
	public Species evolveSpecies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initiateReproduction() {
		
		/*
		 * Loop through all the parents and start reproducing.
		 */
		List<ASexualCreature> temp = (List<ASexualCreature>)(List<?>) listOfParents;
		System.out.println("ASexual Species:\n");
		for (ASexualCreature c : temp) {
			reproduce(c);
		}
		prepForNextGen();
		for (ASexualCreature c : temp) {
		}
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	public List<ASexualCreature> getParents() {
		// TODO Auto-generated method stub
		return (List<ASexualCreature>)(List<?>) listOfParents;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ASexualCreature> getChildren() {
		// TODO Auto-generated method stub
		return (List<ASexualCreature>)(List<?>) listOfChildren;
	}
	private boolean testFertility(ASexualCreature creature){
		double enviromentQuality = enviroment.getBirthSuccess(creature.getGenetics().getProperty("Fertility"));
		if (enviromentQuality < 0.5){
			return true;
		}
		return false;
	}
}


/*
{
for (Creature creature : listOfParents) {
	//For each creature, create a number of children
	//in the process of "evolution"
	God.getInstance().evolveCreature(creature, childCount);
	
	//Let a creature know its perfectness so that God can ask for it later. How humiliating
//	creature.setPerfectness(God.getInstance().calculatePerfection(
//			creature));
	//Kill a parents worst quality child - its weak
	God.getInstance().killWorstChild(creature);
	//Add all the children to the list of all children of this creature type
	listOfChildren.addAll(creature.getChildren());
}
//how many parents : children
}
*/