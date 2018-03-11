package game;

public abstract class GameState<T extends GameAction> {

	private double reward;
	private T optimalAction;
	
	protected GameState(double reward, T action) {
		this.reward = reward;
		this.optimalAction = action;
	}
	
	public double getReward() {
		return reward;
	}
	
	public void setReward(double reward) {
		this.reward = reward;
	}

	public T getOptimalAction() {
		return optimalAction;
	}

	public void setOptimalAction(T optimalAction) {
		this.optimalAction = optimalAction;
	}
	
}
