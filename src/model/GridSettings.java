package model;

public class GridSettings {

	static final double REWARD_NORMAL	= -0.04;
	static final double REWARD_WALL		= 0;
	static final double REWARD_POSITIVE	= 1;
	static final double REWARD_NEGATIVE	= -1;
	
	// starting position
	static final int START_X = 2;
	static final int START_Y = 2;
	
	// the following are coordinates delimited by space
	static final String WALL_GRIDS		= "1,1 2,1 3,1 1,5 4,4";
	static final String POSITIVE_GRIDS	= "0,5 2,5 3,4 4,3 5,2 5,5";
	static final String NEGATIVE_GRIDS	= "1,4 2,3 3,2 4,1 5,4";
	
	public static void loadSettings(GridWorld gw) {
		int x;
		int y;
		String[] coor;

		String[] wall = WALL_GRIDS.split(" ");
		String[] positive = POSITIVE_GRIDS.split(" ");
		String[] negative = NEGATIVE_GRIDS.split(" ");
		
		for(int i = 0; i < wall.length; i++) {
			coor = wall[i].split(",");
			x = Integer.parseInt(coor[0]);
			y = Integer.parseInt(coor[1]);
			gw.setGridState(x,y, GridState.WALL);
		}

		for(int i = 0; i < positive.length; i++) {
			coor = positive[i].split(",");
			x = Integer.parseInt(coor[0]);
			y = Integer.parseInt(coor[1]);
			gw.setGridState(x,y, GridState.POSITIVE);
		}
		
		for(int i = 0; i < negative.length; i++) {
			coor = negative[i].split(",");
			x = Integer.parseInt(coor[0]);
			y = Integer.parseInt(coor[1]);
			gw.setGridState(x,y, GridState.NEGATIVE);
		}
		
		gw.setPosition(START_X, START_Y);
	}
	
}
