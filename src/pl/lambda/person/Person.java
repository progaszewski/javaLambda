package pl.lambda.person;

import java.util.Date;

public class Person {
	
	private static long counter = 0;
	private final long id = counter++;
	
	private String name;
	private String lastName;
	private int age;
	private String hobby;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public long getId() {
		return id;
	}
	
	public Person(String name, String lastName, int age, String hobby){
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.hobby = hobby;
	}
	
	public static int compareByName(Person p1, Person p2){
		return p1.getName().compareTo(p2.getName());
	}
	
	public static int compareByAge(Person p1, Person p2){
		return p1.getAge() == p2.getAge() ? 0 : p1.getAge() < p2.getAge() ? -1 : 1;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String output = this.id + ". " + this.name + " " + this.lastName +", " + this.age;
		if(this.hobby != null) {
			output += ", Hobby: " + this.hobby;
		}
		return output;
	}
}
