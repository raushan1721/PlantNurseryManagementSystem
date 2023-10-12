
package com.amdocs.nursery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.amdocs.nursery.exceptions.plantNotFoundException;
import com.amdocs.nursery.model.plant;
import com.amdocs.nursery.services.dbConnection;


public class plantServiceImpl implements plantService {
	Connection connection=dbConnection.getConnection();
	
	public boolean checkPlantById(int plantId) {
		String addStmt="select * from plants where plantId=?";
		boolean isFound=false;
		try {
			PreparedStatement ps=connection.prepareStatement(addStmt);
			ps.setInt(1, plantId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) isFound=true;
			} catch (SQLException e) {
			e.printStackTrace();
			}
		return isFound;
	}
	
	public boolean addPlant(plant newPlant)  {
		String addStmt="insert into plants (plantId,name,originCountry,sunlightRequired,waterSupplyFrequency,plantType,cost)"
				+"values(id_seq.nextval,?,?,?,?,?,?)";
				int count=0;
				try {
					PreparedStatement ps=connection.prepareStatement(addStmt);

					ps.setString(1,newPlant.getPlantName());
					ps.setString(2,newPlant.getOriginCountry());
					ps.setBoolean(3,newPlant.getSunglightRequired());
					ps.setString(4,newPlant.getWaterSupplyFreq());
					ps.setString(5,newPlant.getPlantType());
					ps.setDouble(6,newPlant.getPlantCost());
					count=ps.executeUpdate();
					
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				if(count>0) return true;
				else return false;

	}

	@Override
	public boolean updatePlantPrice(int id,double cost)  {
		boolean res=false;
		String query="update plants set cost=? where plantId=?";
		int rowsUpdated = 0;
        try {
    		PreparedStatement ps=connection.prepareStatement(query);
    		ps.setDouble(1, cost);
    		ps.setInt(2, id);
    		
    		rowsUpdated = ps.executeUpdate();
        	} catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        	}
        	return rowsUpdated > 0;
	}


	@Override
	public boolean deletePlantById(int plantId) {
		String query = "DELETE FROM plants WHERE plantId = ?";
		try {
	   		PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, plantId);

			int rowsDeleted = ps.executeUpdate();
			if(rowsDeleted>0) return true;
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<plant> getAllPlants()  {

		List<plant> plantList = new ArrayList<>();
		String query = "SELECT * FROM plants";

		try {
	   	PreparedStatement ps=connection.prepareStatement(query);
		ResultSet result = ps.executeQuery();
		while(result.next()) {
			int    PlantId= result.getInt("plantId");
			String PlantName= result.getString("name");
			String showCountryByOrigin= result.getString("originCountry");
			String sunlightRequired= result.getString("SunlightRequired");
			String waterSupplyFrequency= result.getString("waterSupplyFrequency");
			String plantType= result.getString("plantType");
			String cost= result.getString("cost");

			System.out.println(" \n ");
			System.out.println("Plant ID: " +" " + PlantId + "\n" + "Plant Name: " + PlantName + "\n" +
			          "Origin Country: " + showCountryByOrigin + "\n" +
			          "Sunlight Required: " + sunlightRequired + "\n" +
			          "Water Supply Frequency: " + waterSupplyFrequency + "\n" +
			          "Plant Type: " + plantType + "\n" +
			          "Plant Cost: " + cost +"\n" );			
		}

		}
			 catch (SQLException e) {
		            System.err.println("Error retrieving plants from the database: " + e.getMessage());
		        }
				
return plantList;
	}
	
	
	@Override
	public  List<plant> viewPlantByCountry(String country) {


		List<plant> PlantList = new ArrayList<>();
		String query = "SELECT * FROM plants WHERE ORIGINCOUNTRY = ?";
try {
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, country);
		ResultSet result = ps.executeQuery();

		while(result.next()) {
			int    PlantId= result.getInt("plantId");
			String PlantName= result.getString("name");
			String showCountryByOrigin= result.getString("originCountry");
			String sunlightRequired= result.getString("SunlightRequired");
			String waterSupplyFrequency= result.getString("waterSupplyFrequency");
			String plantType= result.getString("plantType");
			String cost= result.getString("cost");

			System.out.println(" \n ");
			System.out.println("Plant ID: " +" " + PlantId + "\n" + "Plant Name: " + PlantName + "\n" +
			          "Origin Country: " + showCountryByOrigin + "\n" +
			          "Sunlight Required: " + sunlightRequired + "\n" +
			          "Water Supply Frequency: " + waterSupplyFrequency + "\n" +
			          "Plant Type: " + plantType + "\n" +
			          "Plant Cost: " + cost +"\n" );			
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}

		return PlantList;

	}


	@Override
	public List<plant> getPlantBySunglightRequirement(int sunlight) {

		List<plant> PlantList = new ArrayList<>();
		String query = "SELECT * FROM plants WHERE SUNLIGHTREQUIRED = ?";
try {
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setInt(1, sunlight);
		ResultSet result = ps.executeQuery();

		while(result.next()) {
			int    PlantId= result.getInt("plantId");
			String PlantName= result.getString("name");
			String showCountryByOrigin= result.getString("originCountry");
			String sunlightRequired= result.getString("SunlightRequired");
			String waterSupplyFrequency= result.getString("waterSupplyFrequency");
			String plantType= result.getString("plantType");
			String cost= result.getString("cost");

			System.out.println(" \n ");
			System.out.println("Plant ID: " +" " + PlantId + "\n" + "Plant Name: " + PlantName + "\n" +
			          "Origin Country: " + showCountryByOrigin + "\n" +
			          "Sunlight Required: " + sunlightRequired + "\n" +
			          "Water Supply Frequency: " + waterSupplyFrequency + "\n" +
			          "Plant Type: " + plantType + "\n" +
			          "Plant Cost: " + cost +"\n" );			

		}
		} catch (SQLException e) {
		e.printStackTrace();
		}

		return PlantList;

	}

	
	@Override
	public int getCountByWaterSupply(String supply)  {
		   int count=0;
		   try {
		   String query = "Select count(*) from plants where WATERSUPPLYFREQUENCY=?";
		   PreparedStatement ps=connection.prepareStatement(query);
		   
		ps.setString(1,supply);
		        ResultSet result = ps.executeQuery();
		        result.next();
		       
		        count=result.getInt(1);
		        System.out.println("Counted: " + count);

		}  catch (SQLException e) {
		            System.err.println("Error retrieving plants from the database: " + e.getMessage());
		        }


		return count;

	}
}
	
