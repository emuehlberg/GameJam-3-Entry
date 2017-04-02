package com.mygdx.gamejam3;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ai.GdxLogger;
import com.badlogic.gdx.graphics.Texture;

public class GameJam3 extends ApplicationAdapter
{
	GEngine eng;
	Entity Player;
	float ms = 5;
	
	@Override
	public void create() {
		eng = new GEngine();
		Texture img = new Texture("player.png");
		Entity e = new Entity();
		e.add(new PositionComponent(200,200)).add(new DisplayComponent(img)).add(new VelocityComponent(0,0)).add(new CollisionComponent(0,0,24,24)).add(new PhysicsComponent(0,-5));
		eng.addEntity(e);
		Player = e;
		Entity e2;
		for(int x = 0; x<100; x++)
		{			
			e2 = new Entity();
			e2.add(new PositionComponent(16*x,0)).add(new DisplayComponent(new Texture("tile.png"))).add(new CollisionComponent(16*x,0,16,16));
			eng.addEntity(e2);
		}
	}

	@Override
	public void render() 
	{
		/**
		 * For testing collisions
		 */
		VelocityComponent vc = Player.getComponent(VelocityComponent.class);
		if(Gdx.input.isKeyPressed(Keys.LEFT))
			vc.vx=-ms;
		else if(Gdx.input.isKeyPressed(Keys.RIGHT))
			vc.vx=ms;
		else
			vc.vx=0;
		if(Gdx.input.isKeyPressed(Keys.UP))
			vc.vy=ms;
		else if(Gdx.input.isKeyPressed(Keys.DOWN))
			vc.vy=-ms;

		
		if(Gdx.input.isKeyJustPressed(Keys.PLUS))
			ms+=2.5;
		if(Gdx.input.isKeyJustPressed(Keys.MINUS))
			ms-=2.5;
		
		if(Gdx.input.isKeyJustPressed(Keys.F1))
		{
			System.out.println("Speed: "+ms);
			eng.printVars();
		}
			
		eng.update(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose()
	{
		eng.dispose();
	}


}
