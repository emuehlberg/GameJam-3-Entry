package com.mygdx.gamejam3;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

public class GameJam3 extends Game
{
	GEngine eng;
	
	@Override
	public void create () {
		eng = new GEngine();
		Texture img = new Texture("badlogic.jpg");
		Entity e = new Entity();
		e.add(new PositionComponent(0,0)).add(new DisplayComponent(img));
		eng.addEntity(e);
	}

	@Override
	public void render () 
	{
		eng.update(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose ()
	{
		eng.dispose();
	}


}
