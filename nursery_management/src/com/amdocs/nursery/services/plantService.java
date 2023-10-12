package com.amdocs.nursery.services;
import com.amdocs.nursery.model.plant;
import com.amdocs.nursery.exceptions.plantNotFoundException;
import java.util.List;
import java.sql.SQLException;

public interface plantService {
	public boolean addPlant(plant newplant) throws SQLException ;
	
	public boolean updatePlantPrice(int id,double cost) ;
	
	public boolean deletePlantById (int plantId) ;
	
	public List<plant>getAllPlants();
	
	public List<plant> viewPlantByCountry(String country) throws plantNotFoundException;
	
	public List<plant>getPlantBySunglightRequirement(int sunlight) ;
	
	
	public int getCountByWaterSupply(String supply);
	
}
