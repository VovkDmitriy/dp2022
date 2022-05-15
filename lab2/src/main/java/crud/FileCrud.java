package crud;

import fileIO.FileIO;
import fileIO.FileIOInteface;
import insect.Insect;

public class FileCrud implements Lab2Crud {
	
	FileIOInteface fio;
	
	

	public FileCrud() {
		this.fio = new FileIO();
	}

	@Override
	public Insect readInsect() {
		
		return (Insect) fio.loadFromFile();
	}

	@Override
	public void updateInsect(Insect insect) {
		fio.saveToFile(insect);

	}

}
