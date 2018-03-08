package model;

public enum GridState {
	NORMAL(GridSettings.REWARD_NORMAL),
	WALL(GridSettings.REWARD_WALL),
	POSITIVE(GridSettings.REWARD_POSITIVE),
	NEGATIVE(GridSettings.REWARD_NEGATIVE);
	
	private double reward;
	
	GridState(double reward) {
		this.reward = reward;
	}
	
	public double getReward() {
		return reward;
	}
	
	public void setReward(double reward) {
		this.reward = reward;
	}
}
