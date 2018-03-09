import model.GridSettings;
import model.GridState;
import model.GridWorld;
import util.ValueIteration;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GridWorld gridWorld = new GridWorld(6,6);
		
		GridSettings.loadSettings(gridWorld);
		
		System.out.println(gridWorld);
		System.out.println("The criteria for convergence is: "+GridSettings.CONVERGENCE_CRITERIA);
		
		ValueIteration vi = new ValueIteration(gridWorld);
		
		double[] utility= vi.doValueIteration(GridSettings.DISCOUNT_FACTOR);
		
		for(int i = 0; i < utility.length; i++) {
			if(gridWorld.getGridState(i) != GridState.WALL) {
				System.out.println("index " + i +" is: " + utility[i]);
			}
		}
		
	}

}
