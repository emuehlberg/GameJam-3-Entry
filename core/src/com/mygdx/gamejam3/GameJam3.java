package com.mygdx.gamejam3;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

public class GameJam3 extends Game
{
	Texture img;
	GEngine eng;
	TextureMap tm;
	
	@Override
	public void create () {
		eng = new GEngine();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () 
	{
		
		
		eng.update(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
		eng.dispose();
		img.dispose();
	}


}
