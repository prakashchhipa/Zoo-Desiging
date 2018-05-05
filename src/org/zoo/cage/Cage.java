package org.zoo.cage;

import org.zoo.animal.Animal;

public abstract class Cage {
	private String id;
	private long cageSize;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the size
	 */
	public long getCageSize() {
		return cageSize;
	}

	/**
	 * @param size the size to set
	 */
	public void setCageSize(long size) {
		this.cageSize = size;
	}

	public abstract boolean putAnimalInCage(Animal animal);
	protected abstract long getFreeSize();
	protected abstract boolean canStayInCage(Animal animal);
}
