package com.globalClasses;

import java.util.ArrayList;
import com.github.javafaker.Faker;

public class TestValues{
	
	Faker faker = new Faker();
	
	public String randomFirstName() {
		String firstName = faker.name().firstName();
		return firstName;
	}
	
	public String randomLastName() {
		String lastName = faker.name().lastName();
		return lastName;
	}
	
	public String randomEmail() {
		String name = faker.name().firstName();
		String domain = "", dot="";
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("gmail");		list.add("yahoo");		list.add("mail");
		list.add("hotmail");		list.add("ymail");		list.add("outlook");
		
			domain = list.get((int) (Math.random()*(5-0+1)+0));
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add(".es");		list2.add(".com");
			
			dot = list2.get((int) (Math.random()*(1-0+1)+0));
		
		String email = name.toLowerCase()+"@"+domain+dot;
		return email;
	}
	
	public String randomDomainPart() {
		String domain = "", dot="";
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("gmail");		list.add("yahoo");		list.add("mail");
		list.add("hotmail");		list.add("ymail");		list.add("outlook");
		
			domain = list.get((int) (Math.random()*(5-0+1)+0));
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add(".es");		list2.add(".com");
			
			dot = list2.get((int) (Math.random()*(1-0+1)+0));
		
		String dpart = "@"+domain+dot;
		return dpart;
	}
	
	
	public String randomPassword() {
		String pass = "";
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");		list.add("b");		list.add("c");		list.add("d");		list.add("e");
		list.add("0");		list.add("1");		list.add("2");		list.add("3");		list.add("4");
		list.add("F");		list.add("G");		list.add("H");		list.add("I");		list.add("J");
		list.add("+");		list.add("_");		list.add("-");		list.add(".");		list.add("*");
		list.add("k");		list.add("l");		list.add("m");		list.add("n");		list.add("o");
		list.add("5");		list.add("6");		list.add("7");		list.add("8");		list.add("9");
		list.add("P");		list.add("Q");		list.add("R");		list.add("S");		list.add("T");
		
		for(int i = 0; i < 8; i++) {
			pass = pass+list.get((int) (Math.random()*(34-0+1)+0));
		}
		
		return pass;
	}

	public String randomSpecialCharacteres() {
		String specialCharacters = "";
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("#");		list.add("$");		list.add("%");		list.add("&");		list.add("/");
		list.add("(");		list.add(")");		list.add("=");		list.add("?");		list.add("@");
		list.add("*");		list.add("{");		list.add("[");		list.add("}");		list.add("]");
		list.add(":");		list.add(";");		list.add(">");		list.add("¿");		list.add("!");
		list.add(",");		list.add("<");						
		
		for(int i = 0; i < 3; i++) {
			specialCharacters = specialCharacters+list.get((int) (Math.random()*(20-0+1)+0));
		}
		
		return specialCharacters;
	}

	
	public String randomAlphanumeric() {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("zero");		list.add("one");		list.add("two");		list.add("three");		list.add("four");
		list.add("five");		list.add("six");		list.add("seven");		list.add("eight");		list.add("nine");

		int random = (int) (Math.random()*(9-0+1)+0);
		return list.get(random)+ String.valueOf(random);
	}
	

	public String randomNumber() {
		String num = "";
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("0");		list.add("1");		list.add("2");		list.add("3");		list.add("4");
		list.add("5");		list.add("6");		list.add("7");		list.add("8");		list.add("9");
		
		for(int i = 0; i < 8 ; i++) {
			num = num+list.get((int) (Math.random()*(9-0+1)+0));
		}
		
		return num;
	}
	
	public String randomAccentMark() {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("á");		list.add("é");		list.add("í");		
		list.add("ó");		list.add("ú");
		
		String v = list.get((int) (Math.random()*(4-0+1)+0));
		return v;
	}
}
