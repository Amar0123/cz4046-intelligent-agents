package model;

import model.GridWorldState.StateType;

public class GridSettings {

	static final double REWARD_NORMAL	= -0.04;
	static final double REWARD_WALL		= 0.0;
	static final double REWARD_POSITIVE	= 1.0;
	static final double REWARD_NEGATIVE	= -1.0;
	
	// starting position
	static final int START_X = 2;
	static final int START_Y = 2;
	
	// the following are coordinates delimited by space
	static final String WALL_GRIDS		= "1,0 1,4 2,4 3,4 4,1";
	static final String POSITIVE_GRIDS	= "0,0 2,0 3,1 4,2 5,0 5,3";
	static final String NEGATIVE_GRIDS	= "1,1 2,2 3,3 4,4 5,1";
	
	// factors to determine convergence
	public static final double DISCOUNT_FACTOR = 0.99;
	static final double EPISILON = 80;
	// check this formula again in the future
	public static final double CONVERGENCE_CRITERIA = EPISILON*(1.0 - DISCOUNT_FACTOR)/DISCOUNT_FACTOR;
	
	public static void loadSettings(GridWorld gw) {
		String[] wall_coord = WALL_GRIDS.split(" ");
		String[] positive_coord = POSITIVE_GRIDS.split(" ");
		String[] negative_coord = NEGATIVE_GRIDS.split(" ");
		
		String temp;
		
		for(int a = 0; a < wall_coord.length; a++) {
			temp = wall_coord[a];
			gw.setState(Integer.parseInt(temp.split(",")[0]), Integer.parseInt(temp.split(",")[1]), StateType.WALL);
		}
		
		for(int a = 0; a < positive_coord.length; a++) {
			temp = positive_coord[a];
			gw.setState(Integer.parseInt(temp.split(",")[0]), Integer.parseInt(temp.split(",")[1]), StateType.POSITIVE);
		}
		
		for(int a = 0; a < negative_coord.length; a++) {
			temp = negative_coord[a];
			gw.setState(Integer.parseInt(temp.split(",")[0]), Integer.parseInt(temp.split(",")[1]), StateType.NEGATIVE);
		}
		
	}
	
}
