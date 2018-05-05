package org.zoo.master;

import java.util.List;

import org.zoo.animal.Animal;
import org.zoo.animal.Wild;
import org.zoo.animal.factory.AbstractAnimalFactory;
import org.zoo.animal.factory.concrete.NonWildAnimalFactory;
import org.zoo.animal.factory.concrete.WildAnimalFactory;
import org.zoo.cage.Cage;

public class ZooManager {

	private static ZooManager manager = null;
	private AbstractAnimalFactory animalFactory = null;

	/* Singleton pattern used to get instance of manager */
	public static ZooManager getInstance() {
		synchronized (ZooManager.class) {
			if (null == manager) {
				manager = new ZooManager();
			}
			return manager;
		}
	}

	/*
	 * Below two methods: OCP & SRP in OOD has been followed by using factory
	 * method and chaining of class hierarchy
	 */
	public Animal createWildAnimal(String breed, long size, int wildHeirarchy) {
		animalFactory = new WildAnimalFactory();
		animalFactory.createAnimal(breed, size, wildHeirarchy);
		return animalFactory.getAnimal();
	}

	public Animal createNonWildAnimal(String breed, long size) {
		animalFactory = new NonWildAnimalFactory();
		animalFactory.createAnimal(breed, size);
		return animalFactory.getAnimal();
	}

	/*
	 * Below method uses Visitor pattern to add Animal(take care of both type of
	 * animal) in available cages and keep cages creation away from addition of
	 * animals
	 */
	public void addAnimalinSuitableCage(Animal animal, List<Cage> cages) {
		boolean status = false;
		while (true) {
			for (Cage cage : cages) {
				/*
				 * Method cage.putAnimalInCage(animal): Addition of animal in
				 * cage will take care of all required business rules for each
				 * type of animal in cage classes specific implementation
				 */
				if (cage.putAnimalInCage(animal)) {
					status = true;
					break;
				}
			}
			if (!status) {
				/* re- setup of cages required- need to add more cages */
				System.out.println("Added more Cages :");
				if(animal instanceof Wild)
					ZooApplicationInitializer.setupZooCages(cages, 1, 0);
				else
				    ZooApplicationInitializer.setupZooCages(cages, 0, 1);

			} else {
				break;
			}
		}
		ZooApplicationInitializer.showCagesDetails(cages);

	}

}
