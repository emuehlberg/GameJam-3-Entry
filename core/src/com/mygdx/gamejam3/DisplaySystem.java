package com.mygdx.gamejam3;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DisplaySystem extends EntitySystem
{
	private ImmutableArray<Entity> entities;
	
	private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
	private ComponentMapper<DisplayComponent> dm = ComponentMapper.getFor(DisplayComponent.class);
	
	private GEngine eng;
	
	public DisplaySystem(GEngine eng)
	{
		this.eng = eng;
	}
	
	public void addedToEngine(Engine engine)
	{
		entities = engine.getEntitiesFor(Family.all(PositionComponent.class, DisplayComponent.class).get());
	}
	
	public void update(float deltaTime)
	{
		Gdx.gl.glClearColor(1, 1, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		eng.batch.setProjectionMatrix(eng.camera.combined);
		eng.batch.begin();
		for(Entity e:entities)
		{
			PositionComponent pc = pm.get(e);
			DisplayComponent dc = dm.get(e);
			eng.batch.draw(dc.getTexture(), pc.x, pc.y);
		}
		eng.batch.end();
		PositionComponent pc = eng.Player.getComponent(PositionComponent.class);
		eng.camera.position.set(pc.x,pc.y,0);
	}
	
}
