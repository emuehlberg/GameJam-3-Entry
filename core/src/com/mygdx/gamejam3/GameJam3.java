package com.mygdx.gamejam3;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

public class GameJam3 extends ApplicationAdapter
{
	GEngine eng;
	Entity Player;
	
	@Override
	public void create() {
		eng = new GEngine();
		Texture img = new Texture("player.png");
		Entity e = new Entity();
		e.add(new PositionComponent(0,0)).add(new DisplayComponent(img)).add(new VelocityComponent(0,0));
		eng.addEntity(e);
		Player = e;
		Entity e2 = new Entity();
		
	}

	@Override
	public void render() 
	{
		/**
		 * For testing collisions
		 */
		VelocityComponent vc = Player.getComponent(VelocityComponent.class);
		if(Gdx.input.isKeyPressed(Keys.LEFT))
			vc.vx=-10;
		else if(Gdx.input.isKeyPressed(Keys.RIGHT))
			vc.vx=10;
		else
			vc.vx=0;
		if(Gdx.input.isKeyPressed(Keys.UP))
			vc.vy=10;
		else if(Gdx.input.isKeyPressed(Keys.DOWN))
			vc.vy=-10;
		else
			vc.vy=0;
		
		eng.update(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose()
	{
		eng.dispose();
	}


}
