package org.zoo.animal.factory;

import org.zoo.animal.Animal;

public abstract class AbstractAnimalFactory {
	
	private Animal animal;

	/*Methods to create animal from outside word using factory-method design pattern*/

	public void createAnimal(String breed, long size, int wildHeirarchy) {
		animal = animalFactory(breed, size, wildHeirarchy);
	}
	
	public void createAnimal(String breed, long size) {
		animal = animalFactory(breed, size, 0);
	}
	
	protected abstract Animal animalFactory(String breed, long size, int wildHeirarchy);

	/**
	 * @return the animal
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * @param animal the animal to set
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
