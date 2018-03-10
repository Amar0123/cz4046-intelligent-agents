package model;

import game.GameState;

public class GridWorldState extends GameState{
	
	public enum StateType{
		NORMAL(GridSettings.REWARD_NORMAL),
		WALL(GridSettings.REWARD_WALL),
		POSITIVE(GridSettings.REWARD_POSITIVE),
		NEGATIVE(GridSettings.REWARD_NEGATIVE);
		
		private double reward;
		
		StateType(double reward) {
			this.reward = reward;
		}
		
		public double getReward() {
			return reward;
		}
	}

	private int x;
	private int y;
	
	private StateType type;
	
	public GridWorldState(int x, int y, StateType type) {
		super(type.getReward());
		this.type = type;
		this.x = x;
		this.y = y;
	}
	
}
