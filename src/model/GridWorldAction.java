package model;

import game.GameAction;

public enum GridWorldAction implements GameAction{

	UP("up"),
	DOWN("down"),
	LEFT("left"),
	RIGHT("right");
	
	private String name;
	
	GridWorldAction(String name) {
		this.name = name;
	}

	@Override
	public String getActionName() {
		return name;
	}

	
}
