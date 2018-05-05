/**
 * 
 */
package org.zoo.cage.factory.concrete;

import org.zoo.cage.Cage;
import org.zoo.cage.factory.AbstractCageFactory;
import org.zoo.cage.type.WildAnimalCage;

/**
 * @author lenovo
 *
 */
public class WildAnimalCageFactory extends AbstractCageFactory {

	/* (non-Javadoc)
	 * @see org.zoo.cage.factory.AbstractCageFactory#cageFactory()
	 */
	@Override
	protected Cage cageFactory() {
		return new WildAnimalCage();
	}

}
