package model;

import game.GameState;

public class GridWorldState extends GameState<GridWorldAction>{
	
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
		super(type.getReward() , GridWorldAction.UP);
		this.type = type;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public StateType getType() {
		return type;
	}

	public void setType(StateType type) {
		this.type = type;
		setReward(type.getReward());
	}
	
}
