package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	
	@Test
	public void test100x100GridCreationWithTwoObstacles() {
		PlanetExplorer pe = new PlanetExplorer(100,100,"(1,1)(6,6)");
		
		int[][] array = new int[100][100];
		array[0][0] = 1;
		array[1][1] = 2;
		array[6][6] = 2;
		
		assertArrayEquals(array,pe.getGrid());
	}

	@Test
	public void test100x100GridCreationWithNoObstacles() {
		PlanetExplorer pe = new PlanetExplorer(100,100,"");
		
		int[][] array = new int[100][100];
		array[0][0] = 1;
		
		assertArrayEquals(array,pe.getGrid());
	}
	

	@Test
	public void executeCommand() {
		
		PlanetExplorer pe = new PlanetExplorer(100,100,"");

		pe.executeCommand("ffr");
		
		
	}

}
