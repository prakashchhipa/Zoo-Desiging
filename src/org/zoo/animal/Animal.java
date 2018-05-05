/**
 * 
 */
package org.zoo.animal;


/**
 * @author prakash
 *
 */
public abstract class Animal /* implements Wild, NonWild*/{

	private String breed;
	private long size;
	private int wildHeirarchy;
	
	public Animal(String breed, long size, int  wildHeirarchy) {
		this.breed = breed;
		this.size = size;
		this.wildHeirarchy = wildHeirarchy;
		System.out.println("Animal type : "+this.breed +"Size : "+this.size+" WildHierarchy :" + this.wildHeirarchy);
	}
		
	public boolean canStayTogether(Animal animal) {
		if(this.getWildHeirarchy() == animal.getWildHeirarchy())
			return true;
		return false;
	}
	
	public abstract void showAnimalDetails();
	
	
	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}

	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}

	/**
	 * @return the wildHeirarchy
	 */
	public int getWildHeirarchy() {
		return wildHeirarchy;
	}

	/**
	 * @param wildHeirarchy the wildHeirarchy to set
	 */
	public void setWildHeirarchy(int wildHeirarchy) {
		this.wildHeirarchy = wildHeirarchy;
	}
	
	
	
}
