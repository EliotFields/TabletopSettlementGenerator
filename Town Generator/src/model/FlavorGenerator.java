package model;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FlavorGenerator {
	
	private Random _rand;
	
	private ArrayList<String> _calamity;
	private ArrayList<String> _govType0;
	private ArrayList<String> _govType1;
	private ArrayList<String> _knownFor;
	private ArrayList<String> _traits;
	private ArrayList<String> _raceRelations;
	private ArrayList<String> _rulerStatus;
	
	public FlavorGenerator() {
		_rand = new Random();
		
		_calamity = new ArrayList<String>();
		_govType0 = new ArrayList<String>();
		_govType1 = new ArrayList<String>();
		_knownFor = new ArrayList<String>();
		_traits = new ArrayList<String>();
		_raceRelations = new ArrayList<String>();
		_rulerStatus = new ArrayList<String>();
		
		try {
			populateLists();
		}
		catch (FileNotFoundException e) {
			System.out.println("Exception: " + e.toString());
		}
	}
	
	public String getCalamity() {
		return pull(_calamity);
	}
	
	public String getGovernment() {
		String s = pull(_govType0) + pull(_govType1);
		return s;
	}
	
	public String getKnownFor() {
		return pull(_knownFor);
	}

	public String getNotableTrait() {
		return pull(_traits);
	}
	
	public String getRaceRelations() {
		return pull(_raceRelations);
	}
	
	public String getRulerStatus() {
		return pull(_rulerStatus);
	}
	
	private String pull(ArrayList<String> list) {
		int i = _rand.nextInt(list.size());
		return list.get(i);
	}
	
	private void populateLists() throws FileNotFoundException {
		Scanner sc;
		File file;
		
		file = new File("lists/tables/CalamityTable.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_calamity.add(sc.nextLine());
		}
		sc.close();
		
		file = new File("lists/tables/GovTypeTable0.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_govType0.add(sc.nextLine());
		}
		sc.close();
		
		file = new File("lists/tables/GovTypeTable1.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_govType1.add(sc.nextLine());
		}
		sc.close();
		
		file = new File("lists/tables/KnownForTable.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_knownFor.add(sc.nextLine());
		}
		sc.close();
		
		file = new File("lists/tables/NotableTraitsTable.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_traits.add(sc.nextLine());
		}
		sc.close();
		
		file = new File("lists/tables/RaceRelationsTable.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_raceRelations.add(sc.nextLine());
		}
		sc.close();
		
		file = new File("lists/tables/RulerStatusTable.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_rulerStatus.add(sc.nextLine());
		}
		sc.close();
	}
	
}
