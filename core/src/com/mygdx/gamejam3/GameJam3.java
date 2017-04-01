package com.mygdx.gamejam3;

import com.badlogic.gdx.Game;

public class GameJam3 extends Game
{

	@Override
	public void create()
	{
		setScreen(new MainMenu(this));	
	}

}
