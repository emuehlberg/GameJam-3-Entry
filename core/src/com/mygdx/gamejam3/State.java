package com.mygdx.gamejam3;

import com.mygdx.gamejam3.enums.Facing;

public class State
{
	Facing facing;
	boolean Jumping;
	boolean Moving;
	boolean Dead;
	float jumptime;
	
	public State()
	{
		facing = Facing.Right;
		Jumping = false;
		Moving = false;
		Dead = false;
	}

}
