package com.camerarental.bean;

public class Camera {
	private String brand;
	private String model;
	private float perDayPrice;
	private int cameraId;
	private String status;
	
	public int getCameraId() {
		return cameraId;
	}
	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public float getPerDayPrice() {
		return perDayPrice;
	}
	
	public void setPerDayPrice(float perDayPrice) {
		this.perDayPrice = perDayPrice;
	}
	
	public Camera(String brand, String model, float perDayPrice, int cameraId, String status) {
		this.brand = brand;
		this.model = model;
		this.perDayPrice = perDayPrice;
		this.cameraId = cameraId;
		this.status = status;
	}
	
	public Camera() {
	}
	
	@Override
	public String toString() {
		return "Camera [brand=" + brand + ", model=" + model + ", perDayPrice=" + perDayPrice + ", cameraId=" + cameraId
				+ ", status=" + status + "]";
	}
	

	

}
