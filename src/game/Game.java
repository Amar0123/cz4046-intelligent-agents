package game;

import java.util.ArrayList;
import java.util.List;

public abstract class Game<T extends GameState<S>, S extends GameAction> {
	protected List<T> states;
	protected List<S> actions;
	protected List<Double> utilities = new ArrayList<Double>();
	protected List<Double> avgUtility;
	
	protected Game() {
		
	}
	
	/**
	 * This methods performs value iteration and returns the number of iterations before reaching the convergence criteria
	 * 
	 * @param discount
	 * @param convergenceCriteria
	 * @return
	 */
	public int doValueIteration(double discount, double convergenceCriteria){
		initUtilities();
		double delta;
		int counter = 0;
		List<Double> temp;
		
		do {
			delta = 0.0;
			temp = new ArrayList<Double>();
			
			for(int j = 0; j < states.size();j++) {
				temp.add(getMaxUtility(states.get(j), discount));
				if(Math.abs(temp.get(j) - utilities.get(j)) > delta) {
					delta = Math.abs(temp.get(j) - utilities.get(j));
				}
			}
			utilities = temp;
			counter++;
			avgUtility.add(findAverageUtility());
		}while(delta > convergenceCriteria);
		
		return counter;
	}
	
	/**
	 * This methods performs policy iteration and returns the number of iterations before reaching the convergence criteria
	 * 
	 * @param discount
	 * @return
	 */
	public int doPolicyIteration(double discount) {
		initUtilities();
		int counter = 0;
		boolean changed;
		List<Double> tempUtility;
		List<S> tempAction = new ArrayList<S>();
		
		for(int i = 0; i < states.size(); i++) {
			tempAction.add(states.get(i).getOptimalAction());
		}
		
		do {
			
			changed = false;
			tempUtility = new ArrayList<Double>();
			
			for(int j = 0; j < states.size();j++) {
				tempUtility.add(getMaxUtility(states.get(j), discount));
				if(!tempAction.get(j).equals(states.get(j).getOptimalAction())) {
					tempAction.set(j, states.get(j).getOptimalAction());
					changed = true;
				}
			}
			utilities = tempUtility;
			
			counter++;
			avgUtility.add(findAverageUtility());
		}while(changed);

		return counter;
		
	}
	
	private double getMaxUtility(T state, double discount) {
		double max = Double.NEGATIVE_INFINITY;
		double utility;
		for(int i = 0; i < actions.size(); i ++) {
			utility = getUtility(state , actions.get(i), discount);
			if( utility > max) {
				state.setOptimalAction(actions.get(i));
				max = utility;
			}
		}
		return max;
	}
	
	private void initUtilities() {
		utilities = new ArrayList<Double>();
		for(int i = 0; i < states.size(); i++) {
			utilities.add(states.get(i).getReward());
		}
		avgUtility = new ArrayList<Double>();
	}
	
	private double findAverageUtility() {
		double total = 0;
		double avg = 0;
		
		for(int i = 0; i < states.size(); i++) {
			total+=utilities.get(i);
		}
		
		avg = total / states.size();
		
		return avg;
	}
	
	public int getLength() {
		return states.size();
	}
	
	public String printUtilityEstimate() {
		String msg = "Number of iteration,Average utility\n";
		
		for(int i = 1; i <= avgUtility.size(); i ++) {
			msg += (i+","+avgUtility.get(i-1)+"\n");
		}
		
		return msg;
	}
	
	public abstract String printUtility();
	
	public abstract double getUtility(T state, S action, double discount);
	
}
