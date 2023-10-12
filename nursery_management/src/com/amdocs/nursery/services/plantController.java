package com.amdocs.nursery.services;
import com.amdocs.nursery.model.plant;
import com.amdocs.nursery.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class plantController {
	private static Scanner scanner = new Scanner(System.in);
private static plantServiceImpl service=new plantServiceImpl();

public plant createPlant() {
	plant p=new plant();
    System.out.println(" Enter the plant Name: ");
    String plantName = scanner.nextLine();
    p.setPlantName(plantName);
    
    System.out.println(" Enter The Origin Country Name: ");
    String countryName = scanner.nextLine();
   p.setOriginCountry(countryName);
    System.out.println(" Sunlight required or Not: Y/N ");
    String sunlight = scanner.nextLine();

    if (sunlight.equalsIgnoreCase("Y"))
    {
    p.setSunlightRequired(true);
    }
    else if(sunlight.equalsIgnoreCase("N"))
    {
    p.setSunlightRequired(false);
    }
    else
    {
    System.out.println(" Invalid user Input ");
    }
   
    System.out.println("Enter the Plant Type : Indoor/Outdoor ");
    String plantType = scanner.nextLine();
    p.setPlantType(plantType);
   
    System.out.println("Enter Water Supply Frequency: daily/weekly/alternate days ");
    String waterSupply = scanner.nextLine();
    p.setWaterSupplyFreq(waterSupply);
   
    System.out.println("Enter the Plant Cost ");
    double plantCost = scanner.nextDouble();
    p.setPlantCost(plantCost);
	return p;
}

public void addPlant() {
	plant newplant=createPlant();
    boolean isAdded=service.addPlant(newplant);
    if(isAdded) System.out.println("plant added successfully!!");
    else System.out.println("oops!! something went wrong");
    }

public void deletePlant(){
	   System.out.println("Enter the Plant ID: ");
	    int plantId = scanner.nextInt();
		if(service.checkPlantById(plantId)) {
  
		    scanner.nextLine();
		    if(service.deletePlantById(plantId)) {
		        System.out.println("deleted");
		        }else {
		        System.out.println("not deleted");
		        }
		}
		else {
//			throw new plantNotFoundException("No plant found with this PlantId");	
		}
}

public void updatePlantCost(){

	   System.out.println("Enter the Plant ID: ");
	    int plantId = scanner.nextInt();
	if(service.checkPlantById(plantId)) {
	    System.out.println("Enter the New Cost: ");
	    double cost = scanner.nextInt();    
	    scanner.nextLine();
	    if(service.updatePlantPrice(plantId,cost)) {
	        System.out.println("updated");
	        }else {
	        System.out.println("not updated");
	        }
	}
	else {
//		throw new plantNotFoundException("No plant found with this PlantId");	
	}
}

public void getAllPlants(){
	service.getAllPlants();
}

public void searchByOriginCountry() {
    System.out.println("Enter the origin Country ");
    String country = scanner.nextLine();
	service.viewPlantByCountry(country);
}

public void viewPlantBySunlight() {
    System.out.println("Enter the sunglight requirement e.g. enter 0 for no sunlight and 1 for sunlight required ");
    int sunlight = scanner.nextInt();
	service.getPlantBySunglightRequirement(sunlight);
}
public void getCountByWaterSupply() {
    System.out.println("Enter the supply frequency like daily, weekly,monthly");
    String supply = scanner.nextLine();
	service.getCountByWaterSupply(supply);
}
}


