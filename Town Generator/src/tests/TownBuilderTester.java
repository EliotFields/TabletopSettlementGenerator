package tests;

import model.TownBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class TownBuilderTester {
	
	@Test
	public void FlavorTest() {
		TownBuilder tb = new TownBuilder();
		System.out.println(tb.flavor() + "\n");
		assertTrue(true);
	}
	
	@Test
	public void DemoTest() {
		TownBuilder tb = new TownBuilder();
		tb.randDemo();
		System.out.println(tb.demographics() + "\n");
		tb.demoSet(TownBuilder.DEMO_LONG);
		tb.randDemo();
		System.out.println(tb.demographics() + "\n");
		assertTrue(true);
	}
	
}
