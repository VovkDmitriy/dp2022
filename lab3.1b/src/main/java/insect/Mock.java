package insect;

import java.util.ArrayList;
import java.util.List;

public class Mock {
	
	private List<Insect> insectList = new ArrayList<>();
	
	
	public Mock () {		
		this.insectList.add(new Insect(1, "Insect 1",0,"first"));
		this.insectList.add(new Insect(2, "Insect 2",2,"second"));
		this.insectList.add(new Insect(3, "Insect 3",3, "third"));
	}

	public List<Insect> getInsectList() {
		return insectList;
	}

	public void setUserList(List<Insect> insectList) {
		this.insectList = insectList;
	}
	
	

}
