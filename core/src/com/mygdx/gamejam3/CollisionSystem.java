package com.mygdx.gamejam3;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;

public class CollisionSystem extends EntitySystem
{
	private ImmutableArray<Entity> entities;
	private ImmutableArray<Entity> sentities;
	
	private ComponentMapper<CollisionComponent> cm = ComponentMapper.getFor(CollisionComponent.class);
	
	public CollisionSystem(){}
	
	public void addedToEngine(Engine engine)
	{
		sentities = engine.getEntitiesFor(Family.all(CollisionComponent.class).get());
		entities = engine.getEntitiesFor(Family.all(VelocityComponent.class,CollisionComponent.class).get());
	}
	
	/**
	 * Checks the collision of basic bounding boxes
	 * @param e1 Entity 1 collision component
	 * @param e2 Entity 2 collision component
	 * @return returns true if collision
	 */
	public boolean collide(CollisionComponent e1, CollisionComponent e2)
	{
		//Find Centers
		float cx1 = e1.x+(e1.w/2);
		float cy1 = e1.y+(e1.h/2);
		float cx2 = e2.x+(e2.w/2);
		float cy2 = e2.y+(e2.h/2);
		
		
		return true;
	}

}
