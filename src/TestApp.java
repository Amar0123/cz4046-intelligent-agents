import model.GridSettings;
import model.GridWorldState;
import model.GridWorld;

public class TestApp {

	public static void main(String[] args) {
		
		GridWorld gw = new GridWorld(6 ,6) ;
		
		GridSettings.loadSettings(gw);
		
		System.out.println(gw);
		
		gw.doPolicyIteration(GridSettings.DISCOUNT_FACTOR);
		System.out.println(gw.printUtility());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		gw.doValueIteration(GridSettings.DISCOUNT_FACTOR, GridSettings.CONVERGENCE_CRITERIA);
		System.out.println(gw.printUtility());
		
	}
	
	

}
