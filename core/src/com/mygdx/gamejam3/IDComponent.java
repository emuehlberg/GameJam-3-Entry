package com.mygdx.gamejam3;

import com.badlogic.ashley.core.Component;

public class IDComponent implements Component
{
	public int ID;
	
	public IDComponent(int ID)
	{
		this.ID = ID;
	}
}
