/**
 * 
 */
package org.zoo.animal.type;

import org.zoo.animal.Animal;
import org.zoo.animal.NonWild;

/**
 * @author prakash
 *
 */
public class NonWildAnimal extends Animal implements NonWild {

	
	
	
	public NonWildAnimal(String breed, long size) {
		super(breed, size, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showAnimalDetails() {
		System.out.println("Animal Breed : "+getBreed()+"\nAnimal Size"+getSize());

		
	}

	

}
