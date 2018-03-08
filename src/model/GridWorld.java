package model;

import java.util.Arrays;

import exceptions.PositionOutOfGridException;

public class GridWorld{
	
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
		
		for(int j = row -1; j >= 0; j--) {
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
		return index % col;
	}

	private int getYfromIndex(int index) {
		return index / col;
	}
	
	
}
