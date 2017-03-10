package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.FlavorGenerator;

public class FlavorGenTester {
		
	@Test public void getSomeFlavor() {
		FlavorGenerator fg = new FlavorGenerator();
		System.out.println("Calamity: " + fg.getCalamity());
		System.out.println("Government Type: " + fg.getGovernment());
		System.out.println("Ruler Status: " + fg.getRulerStatus());
		System.out.println("Known For: " + fg.getKnownFor());
		System.out.println("Notable Trait: " + fg.getNotableTrait());
		System.out.println("Race Relations: " + fg.getRaceRelations() + "\n");

		System.out.println("Calamity: " + fg.getCalamity());
		System.out.println("Government Type: " + fg.getGovernment());
		System.out.println("Ruler Status: " + fg.getRulerStatus());
		System.out.println("Known For: " + fg.getKnownFor());
		System.out.println("Notable Trait: " + fg.getNotableTrait());
		System.out.println("Race Relations: " + fg.getRaceRelations() + "\n");
		
		System.out.println("Calamity: " + fg.getCalamity());
		System.out.println("Government Type: " + fg.getGovernment());
		System.out.println("Ruler Status: " + fg.getRulerStatus());
		System.out.println("Known For: " + fg.getKnownFor());
		System.out.println("Notable Trait: " + fg.getNotableTrait());
		System.out.println("Race Relations: " + fg.getRaceRelations() + "\n");
		
		assertTrue(true);
	}
	
}
