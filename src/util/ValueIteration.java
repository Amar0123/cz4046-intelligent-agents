package util;

import model.GridSettings;

public class ValueIteration {
	/*
	 * This class is designed to be usable in situations apart from the grid world question.
	 * Thus, it aims to take in a 1D-array instead of a 2D-array more relevant to grid world.
	 * Instead, the index to coordinates conversion will be taken care of manually.
	 */
	ValueIterable target;
	
	public ValueIteration(ValueIterable target) {
		this.target = target;
	}
	
	public double[] doValueIteration(double discount) {
		int length = target.getLength();
		double[] currentUtilities = new double[length];
		double[] newUtilities;
		
		for(int i = 0; i < length; i ++) {
			currentUtilities[i] = target.getReward(i);
		}		
		
		double delta;
		int counter = 0;
		do {
			delta = 0.0;
			newUtilities = new double[length];
			
			for(int j = 0; j < length; j++) {
				newUtilities[j] = target.findUtility(j , currentUtilities, discount);
				if(Math.abs(newUtilities[j] - currentUtilities[j]) > delta) {
					delta = Math.abs(newUtilities[j] - currentUtilities[j]);
				}
				
			}
			currentUtilities = newUtilities;
			counter++;
		}while(delta >= GridSettings.CONVERGENCE_CRITERIA);
		System.out.println("iterated " + counter + " times.");
		return currentUtilities;
	}
	
	public interface ValueIterable{

		public double findUtility(int index, double[] currentUtilities, double discount) ;
		
		public int getLength();
		
		public double getReward(int index);
		
	}
		
	
}


