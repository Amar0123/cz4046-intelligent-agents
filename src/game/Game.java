package game;

import java.util.ArrayList;
import java.util.List;

public abstract class Game<T extends GameState, S extends GameAction> {
	protected List<T> states;
	protected List<S> actions;
	protected List<Double> utilities;
	
	protected Game() {
		
	}
	
	public List<Double> getUtilFromValueIteration(double convergenceCriteria){
		
		for(int i = 0; i < states.size(); i++) {
			utilities.add(states.get(i).getReward()); // instantiate list with zeros
		}
		
		double delta;
		int counter = 0;
		List<Double> temp;
		
		do {
			delta = 0.0;
			temp = new ArrayList<Double>();
			
			for(int j = 0; j < states.size();j++) {
				temp.add(getMaxUtility(j));
				if(Math.abs(temp.get(j) - utilities.get(j)) > delta) {
					delta = Math.abs(temp.get(j) - utilities.get(j));
				}
			}
			utilities = temp;
			counter++;
		}while(delta > convergenceCriteria);
		
		System.out.println("Number of iterations is : " + counter);
		
		return utilities;
	}
	
	public double getMaxUtility(int index) {
		double max = Double.MIN_VALUE;
		double utility = Double.MIN_VALUE;
		for(int i = 0; i < actions.size(); i ++) {
			utility = getUtility(states.get(index) , actions.get(i));
			if( utility > max) {
				max = utility;
			}
		}
		return max;
	}
	
	public abstract double getUtility(GameState state, GameAction action);
}
