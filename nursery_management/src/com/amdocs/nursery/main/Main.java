package com.amdocs.nursery.main;
import java.util.Scanner;


import java.sql.SQLException;


import com.amdocs.nursery.exceptions.*;
import com.amdocs.nursery.services.plantService;
import com.amdocs.nursery.services.plantServiceImpl;
import com.amdocs.nursery.services.plantController;


public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static String jdbcUrl="oracle.jdbc.driver.OracleDriver";
	public static void main(String[] args)  {
		
//		try {
//			Class.forName(jdbcUrl);
		boolean start=true;
			while(start) {
				System.out.println("Welcome to my nursery");
				System.out.println("Press 1 to Add Plant");
				System.out.println("Press 2 to delete Plant");
				System.out.println("Press 3 to update plant");
				System.out.println("Press 4 to view all plants");
				System.out.println("Press 5 to search plants by country");
				System.out.println("Press 6 to seaerch plants by which require sunlight");
				System.out.println("Press 7 to get count of plants by water supply");
				System.out.println("Press 8 to Exit");
				
				int option = Integer.parseInt(scanner.nextLine()); 
				plantController pc=new plantController();
				switch(option) {
				case 1:
					pc.addPlant();
					break;
				case 2:
					pc.deletePlant();
					break;
				case 3:
					pc.updatePlantCost();
					break;
				
				case 4:
					pc.getAllPlants();
					break;
				case 5:
					pc.searchByOriginCountry();
					break;
				case 6:
					pc.viewPlantBySunlight();
					break;
				case 7:
					pc.getCountByWaterSupply();
					break;
				case 8:
					start=false;
			        System.out.println("Thank you !! visit again");
			        break;
					
			}
		
		
	}
	}
}
