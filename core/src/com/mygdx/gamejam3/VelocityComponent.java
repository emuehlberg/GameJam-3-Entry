package com.mygdx.gamejam3;

import com.badlogic.ashley.core.Component;

public class VelocityComponent implements Component
{
	public float vx, vy;
	
	public VelocityComponent()
	{
		vx = vy = 0;
	}
	
	public VelocityComponent(float dx, float dy)
	{
		vx = dx;
		vy = dy;
	}

}
