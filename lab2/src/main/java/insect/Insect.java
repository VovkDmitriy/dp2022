package insect;

import java.io.Serializable;

public class Insect implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title, desc;
	private int age;
	public Insect(String title, int age, String desc) {
		super();
		this.title = title;
		this.desc = desc;
		this.age = age;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "{\"title\": \"" + title + "\", \"age\": " + age + ", \"desc\": \"" + desc + "\"}";
	}
	
	
}
