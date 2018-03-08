package model;

import exceptions.PositionOutOfGridException;

public class GridPosition {
	int x;
	int y;
	
	int max_x;
	int max_y;
	
	public GridPosition(int col, int row) {
		this.x = 0;
		this.y = 0;
		max_x = col;
		max_y = row;
	}
	
	public void setPosition(int x, int y) throws PositionOutOfGridException {
		if(x < 0 || y < 0 || x >= max_x || y >= max_y) {
			throw new PositionOutOfGridException();
		}
		
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
