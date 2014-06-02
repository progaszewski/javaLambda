package pl.lambda.main;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		System.out.println("---- Serwis PersonManager ----\n\n");
		Scanner scanner = new Scanner(System.in);
		
		menu:
		do{
			System.out.println("d - dodaj Osobê\n" +
								"u - usun Osobe\n"
								+ "m - modyfikuj Osobe\n"
								+ "z - znajdz Osobe\n"
								+ "s - sortu Osoby\n"
								+ "w - wyjdz\n"
								+ "\n");
			
			String a = scanner.next();
			
			switch(a.toLowerCase()){
			case "d": 
				System.out.println("brak :("); break;
			case "u":
				System.out.println("brak :("); break;
			case "m":
				System.out.println("brak :("); break;
			case "z":
				System.out.println("brak :("); break;
			case "s":
				System.out.println("brak :("); break;
			case "w":
				System.out.println("Nara!"); break menu;
			default: break;
			
			}
		}while(true);
	}

}
