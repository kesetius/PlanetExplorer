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
		// Set the explorer at position 0,0
		this.setExplorer( 0, 0);
		
		Pair[] obs = this.parseObstacles(obstacles);
		
		if (obs != null)
		{
			for( Pair p : obs ) {
				this.setObstacle(p.getX(), p.getY());
			}	
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
		
		if( obstacles == "") // No obstacles set
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
		this.grid[x][y] = 2;
	}
	
	public void setExplorer( int x, int y) {
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
		
		
		
		char[] cmdArr = command.toCharArray();

		
		for( char c : cmdArr) {
			
			
			// TODO: wrap in to a method and record obstacles
			//       inside that method
			
			Pair myPos = this.getExplorerPosition();
			System.out.println(myPos.getY());
			this.grid[myPos.getX()][myPos.getY()] = 0;
			switch (c) {
				case 'f':
					System.out.println("im here");
					this.grid[myPos.getX()][myPos.getY()+1] = 1;
					break;
				case 'b':
					this.grid[myPos.getX()][myPos.getY()-1] = 1;
					break;
				case 'l':
					this.grid[myPos.getX()-1][myPos.getY()] = 1;
					break;
				case 'r':
					this.grid[myPos.getX()+1][myPos.getY()] = 1;
					break;
				default:
					this.grid[myPos.getX()][myPos.getY()] = 1;
					break;
			}
		}
			
		return null;
	}
		
	
	public Pair getExplorerPosition() {

		for(int x=0; x<this.grid.length; x++ ) {
			for(int y=0; y<this.grid[0].length; y++) {
				if(this.grid[x][y] == 1) 
					return new Pair(x,y);
			}
		}
		
		return null;
	}


}
