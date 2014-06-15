package pl.lambda.personmanager;


import java.util.List;

import pl.lambda.person.Person;

public interface PersonManager {
	public List<Person> addPerson(List<Person> persons);
	public List<Person> deletePerson(List<Person> persons);
	public List<Person> sortPerson(List<Person> persons);
	public Integer sumAgePerson(List<Person> persons);
	public Person eldestPerson(List<Person> persons);
	public Person youngestPerson(List<Person> persons);
	public Double avgPerson(List<Person> persons);
	public List<Person> incAgeAllPeople(List<Person> persons);
}