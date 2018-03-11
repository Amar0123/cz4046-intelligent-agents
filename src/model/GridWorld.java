package model;

import java.util.ArrayList;
import java.util.Arrays;

import game.Game;
import model.GridWorldState.StateType;

public class GridWorld extends Game<GridWorldState, GridWorldAction>{

	int row;
	int col;
	
	public GridWorld(int row, int col) {
		states = new ArrayList<GridWorldState>();
		actions = (Arrays.asList(GridWorldAction.values()));
		this.row = row;
		this.col = col;
		for(int i = 0; i < col; i++) {
			for(int j =0; j<row; j++) {
				states.add(new GridWorldState(i,j,StateType.NORMAL));
			}
		}
	}
	
	@Override
	public double getUtility(GridWorldState state, GridWorldAction action, double discount) {
		double utility  = 0.0;
		
		int x = state.getX();
		int y = state.getY();
		
		int indexes[] = new int[4];
		double indexesUtility[] = new double[4];
		
		if(y - 1 < 0 || states.get(getIndexFromXY(x, y - 1)).getType() == StateType.WALL) {
			indexes[0] = getIndexFromXY(x , y);
		}else {
			indexes[0] = getIndexFromXY(x , y - 1);
		}

		if(y + 1 >= row || states.get(getIndexFromXY(x, y + 1)).getType() == StateType.WALL) {
			indexes[1] = getIndexFromXY(x , y);
		}else {
			indexes[1] = getIndexFromXY(x , y + 1);
		}
		
		if(x - 1 < 0 || states.get(getIndexFromXY(x - 1, y)).getType() == StateType.WALL) {
			indexes[2] = getIndexFromXY(x , y);
		}else {
			indexes[2] = getIndexFromXY(x - 1, y);
		}
		
		if(x + 1 >= col || states.get(getIndexFromXY(x + 1, y)).getType() == StateType.WALL) {
			indexes[3] = getIndexFromXY(x , y);
		}else {
			indexes[3] = getIndexFromXY(x + 1, y);
		}
		
		for(int i = 0; i < indexes.length; i ++) {
			indexesUtility[i] = utilities.get(indexes[i]);
		}
		
		switch(action) {
			case UP:
				utility = state.getReward() + discount *(0.8*indexesUtility[0] + 0.1*indexesUtility[2] + 0.1*indexesUtility[3]);
				break;
			case DOWN:
				utility = state.getReward() + discount *(0.8*indexesUtility[1] + 0.1*indexesUtility[2] + 0.1*indexesUtility[3]);
				break;
			case LEFT:
				utility = state.getReward() + discount *(0.8*indexesUtility[2] + 0.1*indexesUtility[0] + 0.1*indexesUtility[1]);
				break;
			case RIGHT:
				utility = state.getReward() + discount *(0.8*indexesUtility[3] + 0.1*indexesUtility[0] + 0.1*indexesUtility[1]);
				break;
		}
		
		return utility;
	}

	@Override
	public String toString() {
		String message = "";
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				StateType st = states.get(getIndexFromXY(j , i)).getType();
				if(st == StateType.WALL) {
					message += "@ ";
				}else if(st == StateType.POSITIVE) {
					message += "+ ";
				}else if(st == StateType.NEGATIVE) {
					message += "~ ";
				}else {
					message += "- ";
				}
			}
			message += "\n";
		}
		
		return message;
	}
	
	@Override
	public String printUtility() {
		String message = "";
		if(utilities == null) {
			return "Do value iteration once first.";
		}
		
		GridWorldState state;
		
		message += "Utilities for the grid:\n";
		for(int i = 0; i < utilities.size(); i++) {
			state = states.get(i);
			if(state.getType() == StateType.WALL) {
				continue;
			}
			message += "( " + state.getX()+ " , " + state.getY() +" ) = " + utilities.get(i) + "\tBest action : "+state.getOptimalAction().getActionName()+"\n";
		}
		
		return message;
	}

	public int getIndexFromXY(int x , int y){
		return y + x*col;
	}
	
	public int getXFromIndex(int index) {
		return index / col;
	}
	
	public int getYFromIndex(int index) {
		return index % col;
	}
	
	public void setState(int x, int y, StateType st) {
		int index = getIndexFromXY(x,y);
		states.get(index).setType(st);
	}
	
}
