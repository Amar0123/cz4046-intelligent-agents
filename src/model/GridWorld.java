package model;

import java.util.Arrays;

import exceptions.PositionOutOfGridException;
import util.ValueIteration.ValueIterable;

public class GridWorld implements ValueIterable{
	
	GridState[][] states;
	
	int col;
	int row;
	
	GridPosition position;
	
	public GridWorld(int col, int row) {
		this.col = col;
		this.row = row;
		
		position = new GridPosition(col,row);
		states = new GridState[col][row];
		for(GridState[] i : states) {
			Arrays.fill(i,GridState.NORMAL);
		}
	}

	public void setPosition(int x, int y) {
		try {
			position.setPosition(x, y);
		} catch (PositionOutOfGridException e) {
			e.printStackTrace();
		}
	}
	
	public GridPosition getPosition() {
		return position;
	}
	
	@Override
	public String toString() {
		String layout = "";
		
		for(int j = 0; j < row; j++) {
			for(int i = 0; i < col; i++) {
				switch(states[i][j]) {
					case WALL:
						layout += "@";
						break;
					case POSITIVE:
						layout += "+";
						break;
					case NEGATIVE:
						layout += "~";
						break;
					default:
						layout += "-";
						break;
				}

				layout += " ";
			}
			layout += "\n";
		}
		
		return layout;
	}
	
	@Override
	public double findUtility(int index, double[] currentUtilities, double discount) {
		double currentReward = getReward(index);
		
		double upUtil,downUtil,leftUtil,rightUtil;
		
		if(index % col == 0 || getGridState(index-1) == GridState.WALL) {
			upUtil = currentUtilities[index];
		}else {
			upUtil = currentUtilities[index-1];
		}
		
		if(index % col == 5 || getGridState(index+1) == GridState.WALL) {
			downUtil = currentUtilities[index];
		}else {
			downUtil = currentUtilities[index+1];
		}
		
		if(index + col >= getLength() || getGridState(index+col) == GridState.WALL) {
			rightUtil = currentUtilities[index];
		}else {
			rightUtil = currentUtilities[index+col];
		}
		
		if(index - col < 0 || getGridState(index-col) == GridState.WALL) {
			leftUtil = currentUtilities[index];
		}else {
			leftUtil = currentUtilities[index-col];
		}
		
		double upReward, downReward,leftReward,rightReward;
		
		upReward	= currentReward + discount *(0.8 * upUtil + 0.1*leftUtil + 0.1*rightUtil);
		downReward	= currentReward + discount *(0.8 * downUtil + 0.1*leftUtil + 0.1*rightUtil);
		leftReward	= currentReward + discount *(0.8 * leftUtil + 0.1*upUtil + 0.1*downUtil);
		rightReward	= currentReward + discount *(0.8 * rightUtil + 0.1*upUtil + 0.1*downUtil);
		
		return Math.max(Math.max(upReward, downReward), Math.max(leftReward, rightReward));
	}

	@Override
	public int getLength() {
		return col*row;
	}

	@Override
	public double getReward(int index) {
		return states[getXfromIndex(index)][getYfromIndex(index)].getReward();
	}

	public void setGridState(int x, int y, GridState gs) {
		states[x][y] = gs;
	}
	
	public void setGridState(int index, GridState gs) {
		states[getXfromIndex(index)][getYfromIndex(index)] = gs;
	}
	
	public GridState getGridState(int x, int y) {
		return states[x][y];
	}
	
	public GridState getGridState(int index) {
		return states[getXfromIndex(index)][getYfromIndex(index)];
	}
	
	
	private int getXfromIndex(int index) {
		return index / col;
	}

	private int getYfromIndex(int index) {
		return index % col;
	}
	
	
}
