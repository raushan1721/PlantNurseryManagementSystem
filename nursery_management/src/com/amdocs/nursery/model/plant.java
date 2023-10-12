package com.amdocs.nursery.model;

public class plant {
	private int plantId;
	private String name;
	private String country;
	private boolean sunlightRequired;
	private String waterSupplyFreq;
	private String plantType;
	private double cost;
	
	public plant() {
		
	}
	
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId=plantId;
	}
	
	public String getPlantName() {
		return name;
	}
	public void setPlantName(String name) {
		this.name=name;
	}
	
	public String getOriginCountry() {
		return country;
	}
	public void setOriginCountry(String country) {
		this.country=country;
	}
	
	public boolean getSunglightRequired() {
		return sunlightRequired;
	}
	public void setSunlightRequired(boolean sunlightRequired) {
		this.sunlightRequired=sunlightRequired;
	}
	
	public String getWaterSupplyFreq() {
		return waterSupplyFreq;
	}
	public void setWaterSupplyFreq(String waterSupplyFreq) {
		this.waterSupplyFreq=waterSupplyFreq;
	}
	
	public String getPlantType() {
		return plantType;
	}
	public void setPlantType(String plantType) {
		this.plantType=plantType;
	}
	
	public double getPlantCost() {
		return cost;
	}
	public void setPlantCost(double cost) {
		this.cost=cost;
	}
	
	public String toString() {
		return "Plant [plantid=" + plantId + ",Plant Name=" +name +",origin Country= ,"+country +",sun light required =" +sunlightRequired+
				",waterSupplyFrequency="+waterSupplyFreq +",plant type="+plantType+",cost ="+cost +" ]";
	}
}
