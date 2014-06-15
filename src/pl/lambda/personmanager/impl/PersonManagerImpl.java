package pl.lambda.personmanager.impl;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import pl.lambda.person.Person;
import pl.lambda.personmanager.PersonManager;

public class PersonManagerImpl implements PersonManager{

	private Scanner scanner = new Scanner(System.in);

	private int getAge(){
		System.out.print("Podaj wiek: ");
		try{
			int age = scanner.nextInt();
			if(age < 0){
				return 0;
			}
			return age;

		}catch(Exception e){
			return 0;
		}
	}
	@Override
	public List<Person> addPerson(List<Person> persons) {
		// TODO Auto-generated method stub
		String name = "", lastName = "", hobby = null;
		int age = -1;

		System.out.print("Podaj imie: ");
		name = scanner.next();
		System.out.print("Podaj nazwisko: ");
		lastName = scanner.next();
		age = getAge();

		persons.add(new Person(name, lastName, age, null));
		return persons;
	}

	@Override
	public List<Person> deletePerson(List<Person> persons) {
		// TODO Auto-generated method stub
		System.out.print("Podaj id osoby: ");
		try{
			Long id = scanner.nextLong();
			persons = persons.stream().filter(p -> p.getId() != id).collect(Collectors.toList());
		}catch(Exception e){
			//noop
		}
		return persons;
	}

	@Override
	public List<Person> sortPerson(List<Person> persons) {
		// TODO Auto-generated method stub
		
		Collections.sort(persons, Person::compareByName);
		return persons;
	}
	@Override
	public Integer sumAgePerson(List<Person> persons) {
		// TODO Auto-generated method stub
		Function<List<Person>, Integer> sumAge = per -> {
			int sum = 0;
			for(Person p: per){
				AgeOp ap = (x, y) -> x + y;
				sum = ap.s(sum, p.getAge());
			}
			return sum;
		};
		return sumAge.apply(persons);
	}
	@Override
	public Person eldestPerson(List<Person> persons) {
		// TODO Auto-generated method stub

		return Collections.max(persons, Person::compareByAge);
	}
	@Override
	public Person youngestPerson(List<Person> persons) {
		// TODO Auto-generated method stub
		
		return Collections.min(persons, Person::compareByAge);
	}
	@Override
	public Double avgPerson(List<Person> persons) {
		// TODO Auto-generated method stub
		
		Function<List<Person>, Double> avgAge = per -> {
			double sum = 0.0;
			AgeAvg aa;
			for(Person p: per){
				aa = (x, n) -> x + n;
				sum = aa.op(sum, p.getAge());
			}
			aa = (x, n) -> x/n;
			
			return aa.op(sum, per.size()); 
		};
		
		return avgAge.apply(persons);
	}
	@Override
	public List<Person> incAgeAllPeople(List<Person> persons) {
		// TODO Auto-generated method stub
		System.out.println("Zwiêksz wiek o: ");
		try{
			int incAge = scanner.nextInt();
			
			Function<List<Person>, List<Person>> incAgeAll = p -> p.stream().map(per -> {
				AgeOp ap = (x, y) -> x + y;
				per.setAge(ap.s(incAge, per.getAge()));
				return per;
			})
			.collect(Collectors.toList());;
			
			return incAgeAll.apply(persons);
			
		}catch(Exception e){
			//noop
		}
		
		return persons;
	}

	interface AgeOp{
		int s(int x, int y);
	}
	interface AgeAvg{
		double op(double x, double n);
	}


}
