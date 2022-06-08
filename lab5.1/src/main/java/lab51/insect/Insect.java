package lab51.insect;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insect")
public class Insect implements Serializable {
	
	
	@Id
	@GeneratedValue
	int id;
	private String title, description;
	private int age;
	
	public Insect(int id, String title, int age, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.age = age;
	}
	
	
	
	public Insect() {
		super();
	}

	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "{ \"id\": " + id + ", \"title\": \"" + title + "\", \"age\": " + age + ", \"description\": \"" + description + "\"}";
	}
}
