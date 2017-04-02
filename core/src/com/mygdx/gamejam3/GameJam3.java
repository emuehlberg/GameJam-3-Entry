package com.mygdx.gamejam3;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ai.GdxLogger;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.gamejam3.enums.Facing;

public class GameJam3 extends ApplicationAdapter
{
	GEngine eng;
	Entity Player;
	
	@Override
	public void create() {
		eng = new GEngine();
		Texture img = new Texture("player.png");
		Entity e = new Entity();
		e.add(new PositionComponent(200,200)).add(new DisplayComponent(img)).add(new VelocityComponent(0,0)).add(new CollisionComponent(0,0,24,24)).add(new PhysicsComponent(0,-10)).add(new StateComponent());
		eng.addEntity(e);
		Player = e;
		eng.jamcam.setFollow(Player);
		Entity e2;
		for(int x = 0; x<20; x++)
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
		StateComponent sc = Player.getComponent(StateComponent.class);

		if(vc.vy == 0)
		{
			sc.state.jumptime = 0;
			sc.state.Jumping = false;
		}

		if(Gdx.input.isKeyPressed(Keys.LEFT))
		{
			sc.state.facing=Facing.Left;
			sc.state.Moving=true;
		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			sc.state.facing=Facing.Right;
			sc.state.Moving=true;
		}
		else
			sc.state.Moving=false;
		if(Gdx.input.isKeyPressed(Keys.UP) && sc.state.jumptime < 5)
		{
			sc.state.Jumping=true;
			if(sc.state.jumptime == 0)
			{
				vc.vy+=5f;
			}
			sc.state.jumptime+=Gdx.graphics.getDeltaTime();
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.PLUS))
			vc.vx+=2.5;
		if(Gdx.input.isKeyJustPressed(Keys.MINUS))
			vc.vx-=2.5;
		
		if(Gdx.input.isKeyJustPressed(Keys.F1))
		{
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
