/**
 * 
 */
package org.zoo.animal.factory.concrete;

import org.zoo.animal.Animal;
import org.zoo.animal.factory.AbstractAnimalFactory;
import org.zoo.animal.type.NonWildAnimal;

/**
 * @author prakash
 *
 */
public class NonWildAnimalFactory extends AbstractAnimalFactory {

	/* (non-Javadoc)
	 * @see org.zoo.animal.factory.AbstractAnimalFactory#animalFactory(java.lang.String, long, int)
	 */
	@Override
	protected Animal animalFactory(String breed, long size, int wildHeirarchy) {
		return new NonWildAnimal(breed, size);
	}

}
