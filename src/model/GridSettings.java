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
	static final String WALL_GRIDS		= "1,0 1,4 2,4 3,4 4,1";
	static final String POSITIVE_GRIDS	= "0,0 2,0 3,1 4,2 5,0 5,3";
	static final String NEGATIVE_GRIDS	= "1,1 2,2 3,3 4,4 5,1";
	
	// factors to determine convergence
	public static final double DISCOUNT_FACTOR = 0.99;
	// what values to use ?????
	static final double R_MAX = 1.0; // is this the max reward??
	static final double C = 1; // what is this even?
	static final double EPISILON =1; // ????? book say this is C*R_MAX
	// check this formula again in the future
	public static final double CONVERGENCE_CRITERIA = EPISILON*(1.0 - DISCOUNT_FACTOR)/DISCOUNT_FACTOR;
	
}
