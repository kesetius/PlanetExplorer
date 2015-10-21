package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void testGridCreationWithObstacles() {
		PlanetExplorer pe = new PlanetExplorer(100,100,"(1,1)(6,6)");
		
		int[][] array = new int[100][100];
		array[1][1] = 1;
		array[6][6] = 1;
		
		assertArrayEquals(array,pe.getGrid());
	}
}
