/**
 * 
 */
package org.zoo.animal.factory.concrete;

import org.zoo.animal.Animal;
import org.zoo.animal.factory.AbstractAnimalFactory;
import org.zoo.animal.type.WildAnimal;

/**
 * @author prakash
 *
 */
public class WildAnimalFactory extends AbstractAnimalFactory {

	/* (non-Javadoc)
	 * @see org.zoo.animal.factory.AbstractAnimalFactory#animalFactory(java.lang.String, int, long)
	 */
	@Override
	protected Animal animalFactory(String breed, long size, int wildHeirarchy) {
		
		return new WildAnimal(breed, size, wildHeirarchy);
	}

}
