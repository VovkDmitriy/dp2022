package mock;

import crud.Lab2Crud;
import insect.Insect;

public class Lab2CrudMock implements Lab2Crud {

	@Override
	public Insect readInsect() {
		// TODO Auto-generated method stub
		return new Insect("Osa", 2, "Mock");
	}

	@Override
	public void updateInsect(Insect insect) {
		// TODO Auto-generated method stub

	}

}
