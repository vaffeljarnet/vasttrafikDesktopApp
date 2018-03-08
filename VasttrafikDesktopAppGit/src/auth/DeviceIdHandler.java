package auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

public class DeviceIdHandler {

	private static String deviceId;

	private DeviceIdHandler() {}
	/**
	 * Used by AccessTokenHandler to give a unique ID for the device running
	 * the application, and thereby giving it a unique access token.  
	 * 
	 * Checks if there's a previously stored device ID on the device, if not generates  
	 * a new one and store it on the device. Otherwhise it returns the stored device ID. 
	 * 
	 * @return String - with previously or newly created device ID.
	 */
	public static String deviceId() {
		if(!(new File("deviceId.dat").exists())) {
			DeviceIdHandler.generateDeviceId();
			DeviceIdHandler.storeDeviceId();
			return deviceId;
		}else {
			DeviceIdHandler.deviceIdFromFile();
			return deviceId;
		}
	}
	/**
	 *Creates a randomly generated String to use as device ID. 
	 */
	private static void generateDeviceId() {
		deviceId = UUID.randomUUID().toString();
	}

	/**
	 * Stores the deviceId String in the deviceId.dat file to 
	 * be able to use it between boots.
	 */
	private static void storeDeviceId() {

		ObjectOutputStream oos = null;

		if(!(new File("deviceId.dat").exists())) {
			new File("deviceId.dat");
		}

		try {
			oos = new ObjectOutputStream(new FileOutputStream("deviceId.dat"));
			oos.writeObject(deviceId);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Sets the deviceId String in the class with the value of the
	 * String object stored in the deviceId.dat file.  
	 */
	private static void deviceIdFromFile() {

		ObjectInputStream ois = null;

		if(!(new File("deviceId.dat").exists())) {
			System.err.println("Hittar inte deviceId.dat");
		}else {
			try {
				ois = new ObjectInputStream(new FileInputStream("deviceId.dat"));
				deviceId = (String) ois.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}finally {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}





}
