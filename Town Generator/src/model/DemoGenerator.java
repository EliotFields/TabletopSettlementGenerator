package model;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DemoGenerator {

	private Random _rand;
	
	private ArrayList<String> _jobs;
	private ArrayList<Integer> _supportValues;
	private ArrayList<String> _jobsExtended;
	private ArrayList<Integer> _supportValuesExtended;
	
	public DemoGenerator() {
		_rand = new Random();
		
		_jobs = new ArrayList<String>();
		_supportValues = new ArrayList<Integer>();
		_jobsExtended = new ArrayList<String>();
		_supportValuesExtended = new ArrayList<Integer>();
		
		try {
			populateLists();
		}
		catch (FileNotFoundException e) {
			System.out.println("Exception: " + e.toString());
		}
		catch (NoSuchFieldException e) {
			System.out.println("Exception: Profession not matched to a support value");
		}
	}
	
	public int getPopulation() {
		int ret = -1;
		int cat = _rand.nextInt(8);
		switch (cat) {
		case 0: ret = 15 + _rand.nextInt(10);
		break;
		case 1: ret = 20 + _rand.nextInt(40);
		break;
		case 2: ret = 60 + _rand.nextInt(140);
		break;
		case 3: ret = 200 + 10*_rand.nextInt(180);
		break;
		case 4: ret = 2000 + 10*_rand.nextInt(300);
		break;
		case 5: ret = 5000 + 100*_rand.nextInt(50);
		break;
		case 6: ret = 10000 + 100*_rand.nextInt(150);
		break;
		case 7: ret = 25000 + 100*_rand.nextInt(750);
		break;
		}
		return ret;
	}
	
	public ArrayList<String> getShopsCommon(int population) {
		ArrayList<String> ret = new ArrayList<String>();
		ArrayList<Integer> vals = howManyCommon(population);
		int i = 0;
		for (String s : _jobs) {
			ret.add(s + ": " + vals.get(i));
			i++;
		}
		return ret;
	}
	
	public ArrayList<String> getShopsExtended(int population) {
		ArrayList<String> ret = new ArrayList<String>();
		ArrayList<Integer> vals = howManyExtended(population);
		int i = 0;
		for (String s : _jobsExtended) {
			ret.add(s + ": " + vals.get(i));
			i++;
		}
		return ret;
	}
	
 	private ArrayList<Integer> howManyCommon(int population) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		float jitter;
		float j;
		int n;
		int count = 0;
		
		for (Integer i : _supportValues) {
			jitter = _rand.nextFloat();
			jitter -= 0.5;
			j = i + i*jitter;
			n = Math.round(population/j);
			if (_rand.nextInt(i/10) < 8) {
				n += 1;
			}
			if (count + n > population) {
				n = 0;
			}
			count += n;
			ret.add(n);
		}
		return ret;
	}
	
	private ArrayList<Integer> howManyExtended(int population) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		float jitter;
		float j;
		int n;
		int count = 0;
		
		for (Integer i : _supportValuesExtended) {
			jitter = _rand.nextFloat();
			jitter -= 0.5;
			j = i + i*jitter;
			n = Math.round(population/j);
			if (_rand.nextInt(i/10) < 8) {
				n += 1;
			}
			if (count + n > population) {
				n = 0;
			}
			count += n;
			ret.add(n);
		}
		return ret;
	}
	
	private void populateLists() throws FileNotFoundException, NoSuchFieldException {
		Scanner sc;
		File file;
		
		file = new File("lists/tables/SupportValuesCommon.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_jobs.add(sc.nextLine());
			if (sc.hasNextLine()) {
				_supportValues.add(sc.nextInt());
				if (sc.hasNextLine()) {
					sc.nextLine();
				}
			}
			else {
				_jobs.remove(_jobs.size()-1);
				sc.close();
				throw new NoSuchFieldException();
			}
		}
		sc.close();
		
		file = new File("lists/tables/SupportValuesExtended.txt");
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			_jobsExtended.add(sc.nextLine());
			if (sc.hasNextLine()) {
				_supportValuesExtended.add(sc.nextInt());
				if (sc.hasNextLine()) {
					sc.nextLine();
				}
			}
			else {
				_jobsExtended.remove(_jobsExtended.size()-1);
				sc.close();
				throw new NoSuchFieldException();
			}
		}
		sc.close();
	}
}
