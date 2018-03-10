package model;

import java.util.ArrayList;
import java.util.Arrays;

import game.Game;
import game.GameAction;
import game.GameState;
import model.GridWorldState.StateType;

public class GridWorld extends Game<GridWorldState, GridWorldAction>{

	public GridWorld(int row, int col) {
		states = new ArrayList<GridWorldState>();
		actions = (Arrays.asList(GridWorldAction.values()));
		for(int i = 0; i < col; i++) {
			for(int j =0; j<row; j++) {
				states.add(new GridWorldState(i,j,StateType.NORMAL));
			}
		}
	}
	
	@Override
	public double getUtility(GameState state, GameAction action) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
