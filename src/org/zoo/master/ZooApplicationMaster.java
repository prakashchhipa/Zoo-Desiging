package org.zoo.master;

import java.util.ArrayList;
import java.util.List;

import org.zoo.animal.Animal;
import org.zoo.cage.Cage;

public class ZooApplicationMaster {

	/* Storage data structure */
	private static List<Cage> cagesInZoo = new ArrayList<Cage>();

	/* Zoo manager- responsible to add all types of animal in suitable cages */
	private static ZooManager zooManager = ZooManager.getInstance();

	/*** APPLICATION INITIALIZATION : setting up zoo by creating cages *****/
	static {
		ZooApplicationInitializer.setupZooCages(cagesInZoo, 5, 5);
		ZooApplicationInitializer.showCagesDetails(cagesInZoo);
	}

	/* Main thread execution */
	public static void main(String[] args) throws Exception {

		/*
		 * Parameter's description for method createWildAnimal("Wild",4, 4) : 1)
		 * breed - unique significance of animal 2) size - It consider as animal
		 * size. Before keeping animal in cage, first available size in cage
		 * must be check with animal size. In case if animal 's size is larger
		 * than available size of any specific cage then animal cannot be kept
		 * there. 3) WildHierarchy - It defines the the food hierarchy for
		 * animal i.e. Animal A has lower wildHierarchy than Animal B, it means
		 * Animal B can eat Animal A as food As per the requirement, If Wild
		 * Hierarchy of two animals are not same then both animal must keep in
		 * different cages
		 */

		for (int requestCount = 0; requestCount < 10; requestCount++) {
			/*** USE CASE 1 : creating and Adding Wild Animal ***/
			/* Wild Animal getting created in below statement */
			Animal wildAnimal = zooManager.createWildAnimal("Wild", 10, 10);
			/*
			 * Keeping animal in suitable cage which follow the required
			 * business rule Note : In case, all cages are occupied then it iwll
			 * re-setup the cages with new one
			 */
			zooManager.addAnimalinSuitableCage(wildAnimal, cagesInZoo);
			// wildAnimal.showAnimalDetails();

			/*** USE CASE 2 : creating and Adding Non-Wild Animal ***/
			/* Wild Animal getting created in below statement */
			Animal nonWildAnimal = zooManager.createNonWildAnimal("NonWild",10);
			/*
			 * Keeping animal in suitable cage which follow the required
			 * business rule Note : In case, all cages are occupied then it iwll
			 * re-setup the cages with new one
			 */
			zooManager.addAnimalinSuitableCage(nonWildAnimal, cagesInZoo);
			// nonWildAnimal.showAnimalDetails();
		}
	}

}
