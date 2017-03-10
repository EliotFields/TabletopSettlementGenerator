package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.NameGenerator;

public class NameGenTester {
	
	@Test
	public void printSeveralRandomNames() {
		NameGenerator ng = new NameGenerator();
		System.out.println(ng.getAny());
		System.out.println(ng.getAny());
		System.out.println(ng.getAny());
		System.out.println(ng.getAny());
		System.out.println(ng.getAny() + "\n");
		System.out.println(ng.getAmerican());
		System.out.println(ng.getGerman());
		System.out.println(ng.getEnglish());
		assertTrue(true);
	}
	
}
