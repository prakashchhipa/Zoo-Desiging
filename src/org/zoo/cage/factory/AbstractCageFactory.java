package org.zoo.cage.factory;

import org.zoo.cage.Cage;

public abstract class AbstractCageFactory {

	private  Cage cage;

	/**
	 * @param cage the cage to set
	 */
	public void setCage(Cage cage) {
		this.cage = cage;
	}

	/**
	 * @return the cage
	 */
	public Cage getCage() {
		return cage;
	}
	
	/*Method to create cage from outside word using factory-method design pattern*/
	public  void createCage () {
		cage = cageFactory();
	}
	
	protected abstract Cage cageFactory();
	
}
