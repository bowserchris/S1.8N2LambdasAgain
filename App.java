package n2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {

		//////Ejercicio 1////// list of names and return only A with exactly 3 letters
		System.out.println("Exercise 1:");
		List<String> listNames = new ArrayList<>();
		
		listNames.add("Harry");
		listNames.add("Ace");
		listNames.add("ava");
		listNames.add("Violet");
		listNames.add("sherry");
		listNames.add("Adam");
		listNames.add("Mark");
		listNames.add("anthony");

		listNames.forEach( name -> { System.out.print(name + ", "); } );
		System.out.println("");
		
		List<String> listNamesWithA = new ArrayList<>();
		listNamesWithA.addAll(listNames);
		
		listNamesWithA.removeIf(string -> !string.contains("A"));
		System.out.println(listNamesWithA);
		listNamesWithA.removeIf(string -> string.length() != 3);
		System.out.println(listNamesWithA);
		
		//////Ejercicio 2////// 
		System.out.println("");
		System.out.println("Exercise 2:");
		String numsStringList = "3, 4, 5, 56, 28, 39, 40";					//string with commas and whitespace
		String[] arrayStringNums = numsStringList.split(", ");						//split the string into array of strings
		List<String> listArrayString1 = Arrays.asList(arrayStringNums);		//add array to arraylist
		listArrayString1.forEach(System.out::println);					
			
		//lambda with custom functional interface
		ArrayReturn evenOdd = (list) -> {
			List<String> array = new ArrayList<>();
			String numEvenOdd;
			for (int i = 0; i < list.size(); i++) {				//go thru string arraylist and parse it into integers and add to arraylist
				int index = Integer.parseInt(list.get(i));
				if (index % 2 == 0) {
					numEvenOdd = "e" + index;
				} else {
					numEvenOdd = "o" + index;
				}
				array.add(numEvenOdd);
			}
			return array;
		};
		
		System.out.println(evenOdd.arrayReturn(listArrayString1));
		
		
		//////Ejercicio 3//////
		Operation addition = (a, b) -> {
			return a + b;
		};	
		Operation subtraction = (a, b) -> {
			return a - b;
		};
		Operation multiplication = (a, b) -> {
			return a * b;
		};
		Operation division = (a, b) -> {
			return a / b;
		};
		System.out.println(addition.operation(10, 3));
		System.out.println(subtraction.operation(10, 3));
		System.out.println(multiplication.operation(10, 3));
		System.out.println(division.operation(10, 3));
		
		//////Ejercicio 4//////
		List<String> listWithNums = new ArrayList<>();
		listWithNums.add("12esrt45");
		listWithNums.add("hi123");
		listWithNums.add("supercadrefrajalisticexpialadoshis");
		listWithNums.add("24");
		listWithNums.add("was12up2bab4");
		listWithNums.add("02noway");
		listWithNums.add("exagerrate");
		listWithNums.add("extupefacting");
		listWithNums.add("aaaaa");
		listWithNums.add("a4");
		listWithNums.add("23456");
		
		//sort alphabetically by first char
		Collections.sort(listWithNums, Comparator.comparing(s -> s.charAt(0)));
		System.out.println("Alphabetically: " + listWithNums);
		
		//sort by e first then others after others. code directly in lambda
		ArrayReturn onlyE = (list) -> {
			List<String> array = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).startsWith("e")) {
					array.add(list.get(i));
				}
			}
			return array;
		};
		List<String> listStartWithE = onlyE.arrayReturn(listWithNums);
		List<String> listWithNums2 = listWithNums;
		listWithNums2.removeIf(string -> string.startsWith("e"));
		listStartWithE.addAll(listWithNums2);
		System.out.println("Only with e: " + listStartWithE);
		
		System.out.println("Starting with 'e': " + listWithNums2);
		
		//modify all in list with 'a' to 4
		List<String> listAto4  = listWithNums.stream().map(i -> i.replace("a", "4")).collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Modifying 'a' to 4: " + listAto4);
		
		//show only numeric
		ArrayReturn onlyNums = (list) -> {
			List<String> array = new ArrayList<>();
			String nums;
			for (int i = 0; i < list.size(); i++) {				//go thru string arraylist and parse it into integers and add to arraylist
				if (list.get(i).matches("[0-9]+")) {
					array.add(list.get(i));
				}
			}
			return array;
		};

		System.out.println("Only numeric: " + onlyNums.arrayReturn(listWithNums));

	}

}
/*
- Exercise 4

    Create a list containing some strings of text and numbers.

    Sort them by:
        Alphabetically by first character. (Note: charAt(0) returns
         the numeric code of the first character)
        Strings containing an "e" first, other strings after. Put 
        the code directly in the lambda.
        Modifies all elements in the list that have an 'a'. Change 
        the 'a' to a '4'.
        Show only items that are numeric. (Even if they are saved 
        as Strings).
 * 
 * 
 * */
