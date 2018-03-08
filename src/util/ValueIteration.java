package util;



public abstract class ValueIteration {
	/*
	 * This class is designed to be usable in situations apart from the grid world question.
	 * Thus, it aims to take in a 1D-array instead of a 2D-array more relevant to grid world.
	 * Instead, the index to coordinates conversion will be taken care of manually.
	 */
	ValueIterable target;
	double[] utilities;
	
	public ValueIteration(ValueIterable target) {
		this.target = target;
		utilities = new double[target.getLength()];
	}
	
	public interface ValueIterable{

		public double findUtility(int index) ;
		
		public int getLength();
		
	}
		
	
}


