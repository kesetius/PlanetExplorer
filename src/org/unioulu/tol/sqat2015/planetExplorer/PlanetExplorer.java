package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:
public class PlanetExplorer {
	
	private int[][] grid;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		
		// Initialize the grid
		this.setGrid(x, y);
		
		Pair[] obs = this.parseObstacles(obstacles);
		
		for( Pair p : obs ) {
			this.setObstacle(p.getX(), p.getY());
		}
		
	}
		
	public int[][] getGrid() {
		return grid;
	}

	// Creates grid based on given x & y [initializes with zeros by lang spec]
	public void setGrid(int x, int y) {
		this.grid = new int[x][y];
	}
	
	public Pair[] parseObstacles( String obstacles ) {
		
		if( obstacles == null)
			return null;
		
		String obs = obstacles;
		
		obs = obs.replace("(", "").replace(")","x"); // Output: "1,2)3,4)5,6).."
		String[] coords = obs.split("x");
		Pair[] thePairs = new Pair[ coords.length ];
		
		int i = 0;
		for( String c : coords) {
			String[] oneCoord = c.split(","); 
			Pair pair = new Pair( Integer.parseInt(oneCoord[0]), Integer.parseInt(oneCoord[1]));
			thePairs[i] = pair;
			i++;
		}
		
		return thePairs;
	}
	
	
	// Add obstacle to a spesific field of a grid, [mark as 1]
	public void setObstacle(int x,int y) {
		this.grid[x][y] = 1;
	}
	
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		
		System.out.println( command );
		
		
		return null;
	}


}
