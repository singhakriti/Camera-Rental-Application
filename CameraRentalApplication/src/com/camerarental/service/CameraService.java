package com.camerarental.service;

	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Scanner;

	import com.camerarental.bean.Camera;
import com.camerarental.bean.User;

	public class CameraService {

		List<Camera> listOfCamera = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		static int cameraId=1;
		public void addCamera() {
			System.out.println("Enter the camera brand");
			String brand = sc.next();
			System.out.println("Enter the camera model");
			String model = sc.next();
			System.out.println("Enter the camera per day amount");
			float amount = sc.nextFloat();
			System.out.println("Enter the camera status");
			String status = sc.next();
			Camera cc = new Camera();
			cc.setCameraId(cameraId++);
			cc.setBrand(brand);
			cc.setModel(model);
			cc.setPerDayPrice(amount);
			cc.setStatus(status);
				listOfCamera.add(cc);
			System.out.println("Camere details added successfully");
		}
		
		public void removeCamera() {
			System.out.println("Enter the camera id to remove");
			int idToBeRemoved = sc.nextInt();
			Iterator<Camera> li = listOfCamera.iterator();
			while(li.hasNext()) {
				Camera camera = li.next();
				if(camera.getCameraId()==idToBeRemoved)  {
					li.remove();
					System.out.println("Camera successfully removed from the list.");
					return;
				}
			}
			System.out.println("This camera id is not present in the list.");
		}
		public void viewAllCamera() {
			if(listOfCamera.size()==0) {
				System.out.println("No Data Present at This Moment.");
			}
			Iterator<Camera> li = listOfCamera.iterator();
			while(li.hasNext()) {
				Camera cc = li.next();
				System.out.println(cc);  
			}
			
		}
		
		public void viewAllAvailableCamera() {
			if(listOfCamera.size()==0) {
				System.out.println("No Data Present at This Moment.");
			}
			System.out.println("Following is the list of available cameras");
			Iterator<Camera> li = listOfCamera.iterator();
			while(li.hasNext()) {
				Camera cc = li.next();
				if(cc.getStatus().equalsIgnoreCase("available")) {
					System.out.println(cc);
				}
			}
			
		}
		
		public void rentCamera(int cameraId, User user) {
			Iterator<Camera> li = listOfCamera.iterator();
			boolean cameraFound=false;
			while(li.hasNext()) {
				Camera camera = li.next();
				if(camera.getCameraId()==cameraId)  {
					cameraFound=true;
					if(user.getWalletBalance()>=camera.getPerDayPrice()) {
						camera.setStatus("Rented");
						System.out.println("YOUR TRANSACTION FOR CAMERA " + camera.getBrand()
						+ " " + camera.getModel() + " with rent "+ camera.getPerDayPrice() + " HAS SUCCESSFULLY COMPLETED.");
					} else {
						System.out.println("ERROR: TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE. PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET.");
					}
				}
			}
			if(!cameraFound) {
				System.out.println("Camera is not available.");
			}
		}
		

	
	

}
