/**
 * 
 */
package org.zoo.animal.type;

import org.zoo.animal.Animal;
import org.zoo.animal.Wild;

/**
 * @author prakash
 *
 */
public class WildAnimal extends Animal implements Wild {

	
	
	public WildAnimal(String breed, long size, int wildHeirarchy) {
		super(breed, size, wildHeirarchy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showAnimalDetails() {
		System.out.println("Animal Breed : "+getBreed()+"\nAnimal Size"+getSize()+"\nWild Heirarchy :"+ getWildHeirarchy());
		
	}

	

}
