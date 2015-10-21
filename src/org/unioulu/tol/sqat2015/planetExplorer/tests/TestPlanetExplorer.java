package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void testGridCreation() {
		
		PlanetExplorer pe = new PlanetExplorer(100,100,"(1,1)(6,6)");
		assertArrayEquals(new int[100][99],pe.getGrid());
		
		
	}
}
