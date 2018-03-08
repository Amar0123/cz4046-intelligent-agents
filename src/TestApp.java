import model.GridSettings;
import model.GridState;
import model.GridWorld;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GridWorld gridWorld = new GridWorld(6,6);
		
		GridSettings.loadSettings(gridWorld);
		
		System.out.println(gridWorld);
		
	}

}
