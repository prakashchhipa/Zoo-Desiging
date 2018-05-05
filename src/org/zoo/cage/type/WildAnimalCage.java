/**
 * 
 */
package org.zoo.cage.type;

import java.util.HashMap;
import java.util.Map;

import org.zoo.animal.Animal;
import org.zoo.animal.Wild;
import org.zoo.cage.Cage;

/**
 * @author prakash
 * 
 */
public class WildAnimalCage extends Cage {

	private Map<Wild, Long> animalsInCage = new HashMap<Wild, Long>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.zoo.cage.Cage#addAnimal(org.zoo.animal.Animal)
	 */
	@Override
	public boolean putAnimalInCage(Animal animal) {
		boolean status = false;
		/*Both the business requirements of size and animal case has been checked here*/
		if (animal instanceof Wild && getFreeSize() >= animal.getSize() && canStayInCage(animal)) {
			animalsInCage.put((Wild) animal, animal.getSize());
			this.setCageSize(getFreeSize() - animal.getSize());
			status = true;
		}
		return status;
	}

	@Override
	protected long getFreeSize() {
		long occupiedSize = 0;
		for (Wild wildAnimalAsKey : animalsInCage.keySet()) {
			if (null == wildAnimalAsKey) {
				occupiedSize += animalsInCage.get(wildAnimalAsKey);
			}
		}
		return this.getCageSize() - occupiedSize;
	}

	@Override
	protected boolean canStayInCage(Animal animal) {
		boolean status = true;
		if(0 != animalsInCage.size()) {
			for (Wild wildAnimalAsKey : animalsInCage.keySet()) {
				if (null != wildAnimalAsKey
						&& ((Animal) wildAnimalAsKey).getWildHeirarchy() != animal
								.getWildHeirarchy()) {
					status = false;
					break;
				}
			}
		}
		return status;
	}

}
