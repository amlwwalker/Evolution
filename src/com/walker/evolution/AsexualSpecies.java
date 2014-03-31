package com.walker.evolution;

import java.util.ArrayList;
import java.util.List;

public class AsexualSpecies extends Species {
	
	//one evolved species per asexual species.
	private SexualSpecies evolvedSpecies = null;
	protected List<ASexualCreature> listOfParents = new ArrayList<ASexualCreature>();
	protected List<ASexualCreature> listOfChildren = new ArrayList<ASexualCreature>();
	public AsexualSpecies(String perfectGenome) {
		super(perfectGenome);
		listOfParents = God.getInstance().performMiracle(
				this);
	}

	public void reproduce(ASexualCreature creature) {
//		asexual species reproduce by mitosis;
//		I.e they copy themselves
//		God can choose to evolve the produced version.
		System.out.println("Reproducing ASexually");
		List<ASexualCreature> offspring = new ArrayList<ASexualCreature>();
		for (int i = 0; i < 2; i++){
			offspring.add(new ASexualCreature(this, God.getInstance().evolveGenetics(((Creature) creature).getGenetics())));
		}
		
		
		//need to test whether any of the offspring evolved to the point where in fact they are of a different species.
		//changing from one class type to another basically.
		
//		for (ASexualCreature c : offspring) {
//			// if the creatures sexuality matches perfect then it no
//			// longer breeds through mitosis and needs two parents
//			if (getPerfectGenetics()
//							.getProperty("Sexuality")
//							.equals(c.getGenetics()
//									.getProperty("Sexuality"))) {
//				createEvolvedSpecies().getParents()
//						.add(
//);
//			} else {
//				getChildren().add(c);
//			}
//		}
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

	public List<ASexualCreature> getParents() {
		// TODO Auto-generated method stub
		return listOfParents;
	}

	public List<ASexualCreature> getChildren() {
		// TODO Auto-generated method stub
		return listOfChildren;
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
		for (ASexualCreature c : listOfParents) {
			reproduce(c);
		}
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