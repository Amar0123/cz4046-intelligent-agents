package model;

import game.GameState;

public class GridWorldState extends GameState<GridWorldAction>{
	
	public enum StateType{
		NORMAL(GridSettingsLoader.REWARD_NORMAL),
		WALL(GridSettingsLoader.REWARD_WALL),
		POSITIVE(GridSettingsLoader.REWARD_POSITIVE),
		NEGATIVE(GridSettingsLoader.REWARD_NEGATIVE),
		POSITIVE_PLUS(GridSettingsLoader.REWARD_POSITIVE_PLUS),
		NEGATIVE_PLUS(GridSettingsLoader.REWARD_NEGATIVE_PLUS);
		
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
