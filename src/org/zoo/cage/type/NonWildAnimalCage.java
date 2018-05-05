/**
 * 
 */
package org.zoo.cage.type;

import java.util.HashMap;
import java.util.Map;

import org.zoo.animal.Animal;
import org.zoo.animal.NonWild;
import org.zoo.cage.Cage;

/**
 * @author prakash
 * 
 */
public class NonWildAnimalCage extends Cage {

	private Map<NonWild, Long> animalsInCage = new HashMap<NonWild, Long>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.zoo.cage.Cage#addAnimal(org.zoo.animal.Animal)
	 */
	@Override
	public boolean putAnimalInCage(Animal animal) {
		boolean status = false;
		/*business requirements of size and animal case has been checked here*/
		if (animal instanceof NonWild && getFreeSize() >= animal.getSize() ) {
			animalsInCage.put((NonWild) animal, animal.getSize());
			status = true;
			this.setCageSize(getFreeSize() - animal.getSize());
		}
		return status;
	}

	@Override
	protected long getFreeSize() {
		long occupiedSize = 0;
		for (NonWild wildAnimalAsKey : animalsInCage.keySet()) {
			if (null == wildAnimalAsKey) {
				occupiedSize += animalsInCage.get(wildAnimalAsKey);
			}
		}
		return this.getCageSize() - occupiedSize;
	}

	@Override
	protected boolean canStayInCage(Animal animal) {
		return true;
	}

}
