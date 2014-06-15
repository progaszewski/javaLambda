package pl.lambda.main;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.lambda.person.Person;
import pl.lambda.personmanager.PersonManager;
import pl.lambda.personmanager.impl.PersonManagerImpl;

public class MainProject {
	
	private List<Person> persons = new ArrayList<Person>(){{
		add(new Person("Iwona", "Kierel", 29, null));
		add(new Person("Damian", "Kierel", 35, null));
		add(new Person("Andrzej", "Nowak", 17, null));
		add(new Person("Anna", "Kowalska", 20, null));
	}};

	private Scanner scanner = new Scanner(System.in);
	private PersonManager pm = new PersonManagerImpl();

	public static void main(String[] args) {
		MainProject mp = new MainProject();
		System.out.println("---- Serwis PersonManager ----\n\n");

		mp.menuPersonManager();
	}

	public void menuPersonManager() {

		menu:
			do{
				System.out.println(persons + "\n");
				System.out.println("d - dodaj Osobê\n" +
						"u - usun Osobe\n"
						+ "o - operacje na Osobach\n"
						+ "w - wyjdz\n"
						+ "\n");

				System.out.print("Wprowadz: ");
				String a = scanner.next();

				switch(a.toLowerCase()){
				case "d": 
					System.out.println(this.persons = this.pm.addPerson(this.persons));
					break;
				case "u":
					System.out.println(this.persons = this.pm.deletePerson(this.persons));
					break;
				case "o":
					operations(); break;
				case "w":
					System.out.println("Nara!"); break menu;
				default: break;

				}

				System.out.println();
			}while(true);
	}

	private void operations() {
		back:
			do{
				System.out.println(persons + "\n");
				System.out.println("\ts - sortuj Osoby\n" +
						"\to - suma wieku wszystkich Osob\n"
						+ "\td - najstarsza Osaba\n"
						+ "\tn - najmlodsza Osoba\n"
						+ "\ta - sredni wiek Osob\n"
						+ "\ti - zwieksz wiek Osobom\n"
						+ "\tw - wroc\n"
						+ "\n");

				System.out.print("Wprowadz: ");
				String a = scanner.next();

				switch(a.toLowerCase()){
				case "s": 
					System.out.println(this.persons = this.pm.sortPerson(this.persons));
					break;
				case "o":
					System.out.println("Laczny wiek wszystkich osob: " + this.pm.sumAgePerson(this.persons));
					break;
				case "d":
					System.out.println("Najstrasza osoba: "+ this.pm.eldestPerson(this.persons));
					break;
				case "n":
					System.out.println("Najmlodcza osoba: " + this.pm.youngestPerson(this.persons));
					break;
				case "a":
					System.out.println("Sredni wiek wszystkich osob: " + this.pm.avgPerson(this.persons));
					break;
				case "i":
					System.out.println(this.pm.incAgeAllPeople(this.persons));
					break;
				case "w": break back;
				default: break;

				}

				System.out.println();

			}while(true);
	}

}
