package org.zoo.master;

import java.util.List;

import org.zoo.cage.Cage;
import org.zoo.cage.factory.AbstractCageFactory;
import org.zoo.cage.factory.concrete.NonWildAnimalCageFactory;
import org.zoo.cage.factory.concrete.WildAnimalCageFactory;

public class ZooApplicationInitializer {
	
	
	
	public static List<Cage> setupZooCages(List<Cage> cages, int numberOfWildAnimalCages, int numberOfNonWildAnimalCages){
		/*Using Factory-method design pattern, wild cages are getting created in loosely coupled way*/
		for(short count =0 ; count<numberOfWildAnimalCages;count ++){
			AbstractCageFactory cageFactory = new WildAnimalCageFactory();
			cageFactory.createCage();
			cageFactory.getCage().setId("Wild-Cage-"+ (cages.size()+count));
			cageFactory.getCage().setCageSize(40);
			cages.add(cageFactory.getCage());
		}
		/*Using Factory-method design pattern, non wild cages are getting created in loosely coupled way*/
		for(short count =0 ; count<numberOfNonWildAnimalCages;count ++){
			AbstractCageFactory cageFactory = new NonWildAnimalCageFactory();
			cageFactory.createCage();
			cageFactory.getCage().setId("Non-Wild-Cage-"+ (cages.size()+count));
			cageFactory.getCage().setCageSize(40);
			cages.add(cageFactory.getCage());
		}
		return cages;
	}
	
	public static void showCagesDetails(List<Cage> cages) {
		for(Cage cage: cages) {
			System.out.println(cage.getId() +"  Size : "+cage.getCageSize());
		}
	}

}
