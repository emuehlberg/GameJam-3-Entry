package com.mygdx.gamejam3;

import com.badlogic.ashley.core.Component;
import com.mygdx.gamejam3.enums.Facing;

public class StateComponent implements Component
{
	public State state;
	
	
	public StateComponent()
	{
		state = new State();
	}
	

}
