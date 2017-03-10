package model;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class NameGenerator {
	
	private Random _rand;
	
	private ArrayList<String> _American0;
	private ArrayList<String> _American1;
	private ArrayList<String> _German0;
	private ArrayList<String> _German1;
	private ArrayList<String> _English0;
	private ArrayList<String> _English1;
	
	public NameGenerator() {
		_rand = new Random();
		
		_American0 = new ArrayList<String>();
		_American1 = new ArrayList<String>();
		_German0 = new ArrayList<String>();
		_German1 = new ArrayList<String>();
		_English0 = new ArrayList<String>();
		_English1 = new ArrayList<String>();
		
		try {
			populateLists();
		}
		catch (FileNotFoundException e) {
			System.out.println("Exception: " + e.toString());
		}
	}
	
	public String getAny() {
		int i = _rand.nextInt(3);
		switch (i) {
		case 0: return getAmerican();
		case 1: return getGerman();
		case 2: return getEnglish();
		}
		return "";
	}
	
	public String getAmerican() {
		return makeName(_American0, _American1);
	}
	
	public String getGerman() {
		return makeName(_German0, _German1);
	}
	
	public String getEnglish() {
		return makeName(_English0, _English1);
	}
	
	private String makeName(ArrayList<String> first, ArrayList<String> second) {
		int i0 = _rand.nextInt(first.size());
		int i1 = _rand.nextInt(second.size());
		String s = first.get(i0) + second.get(i1);
		return s;
	}
	
	private void populateLists() throws FileNotFoundException {
		Scanner sc;
		
		File file = new File("lists/name/American0.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_American0.add(sc.nextLine());
		}
		sc.close();
		
		file = new File("lists/name/American1.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_American1.add(sc.nextLine());
		}
		sc.close();
		
		file = new File("lists/name/German0.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_German0.add(sc.nextLine());
		}
		sc.close();
		
		file = new File("lists/name/German1.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_German1.add(sc.nextLine());
		}
		sc.close();
		
		file = new File("lists/name/English0.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_English0.add(sc.nextLine());
		}
		sc.close();
		
		file = new File("lists/name/English1.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_English1.add(sc.nextLine());
		}
		sc.close();
	}
}
