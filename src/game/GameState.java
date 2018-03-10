package game;

public abstract class GameState {

	private double reward;
	
	protected GameState(double reward) {
		this.reward = reward;
	}
	
	public double getReward() {
		return reward;
	}
	
}
