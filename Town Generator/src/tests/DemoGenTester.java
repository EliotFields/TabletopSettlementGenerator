package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.DemoGenerator;
import java.util.ArrayList;

public class DemoGenTester {

	@Test
	public void testCommonValues() {
		DemoGenerator dg = new DemoGenerator();
		int p = dg.getPopulation();
		System.out.println("Population: " + p);
		ArrayList<String> list = dg.getShopsCommon(p);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("");
		assertEquals(12, list.size());
	}
	
	@Test
	public void testExtendedValues() {
		DemoGenerator dg = new DemoGenerator();
		int p = dg.getPopulation();
		System.out.println("Population: " + p);
		ArrayList<String> list = dg.getShopsExtended(p);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("");
		assertEquals(34, list.size());
	}
	
	@Test
	public void testPopGen() {
		DemoGenerator dg = new DemoGenerator();
		System.out.println(dg.getPopulation());
		System.out.println(dg.getPopulation());
		System.out.println(dg.getPopulation());
		System.out.println(dg.getPopulation());
		System.out.println(dg.getPopulation());
		System.out.println("");
		assertTrue(true);
	}
	
}
