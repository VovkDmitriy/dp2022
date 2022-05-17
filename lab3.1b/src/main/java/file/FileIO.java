package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import insect.Insect;

public class FileIO {
	public static String fileName = "file.txt";
	
	

	
	public static void saveToFile(List<Insect> object) {

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			oos.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@SuppressWarnings("unchecked")
	public static List<Insect> loadFromFile() {
		List<Insect> result = null;
		
		
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			result = (List<Insect>) ois.readObject();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
