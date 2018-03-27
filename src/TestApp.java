import model.GridSettingsLoader;
import model.GridWorld;

public class TestApp {

	public static void main(String[] args) {

		System.out.println("Part 1: ");
		GridWorld gw = new GridWorld(6 ,6) ;
		
		GridSettingsLoader.loadSettings(gw);
		
		System.out.println(gw);

		System.out.println("Number of iterations for value iteration is : " + gw.doValueIteration(GridSettingsLoader.DISCOUNT_FACTOR, GridSettingsLoader.CONVERGENCE_CRITERIA));
		System.out.println(gw.printUtility());
		System.out.println("Utility Estimate for value iteration");
		System.out.println(gw.printUtilityEstimate());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		

		System.out.println("Number of iterations for policy iteration is : " + gw.doPolicyIteration(GridSettingsLoader.DISCOUNT_FACTOR));
		System.out.println(gw.printUtility());
		System.out.println("Utility Estimate for policy iteration");
		System.out.println(gw.printUtilityEstimate());
		
		System.out.println("Part 2: ");
		GridWorld gw2 = new GridWorld(10 ,10) ;
		
		GridSettingsLoader.loadSettings2(gw2);
		
		System.out.println(gw2);
		
		System.out.println("Number of iterations for value iteration is : " + gw2.doValueIteration(GridSettingsLoader.DISCOUNT_FACTOR, GridSettingsLoader.CONVERGENCE_CRITERIA));
		System.out.println(gw2.printUtility());
		System.out.println("Utility Estimate for value iteration");
		System.out.println(gw2.printUtilityEstimate());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.println("Number of iterations for policy iteration is : " + gw2.doPolicyIteration(GridSettingsLoader.DISCOUNT_FACTOR));
		System.out.println(gw2.printUtility());
		System.out.println("Utility Estimate for policy iteration");
		System.out.println(gw2.printUtilityEstimate());
		
	}
	
	

}
