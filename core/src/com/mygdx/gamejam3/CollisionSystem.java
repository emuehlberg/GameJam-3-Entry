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
	
	public void update(float deltaTime)
	{
		for(int x = 0; x<entities.size();x++)
		{
			Entity e1 = entities.get(x);
			VelocityComponent vc = e1.getComponent(VelocityComponent.class);
			if((vc.vx != 0 || vc.vy != 0) && vc != null)
			{
				CollisionComponent cc1 = cm.get(e1);
				
				for(int i = 0; i < sentities.size(); i++)
				{
					Entity e2 = sentities.get(i);
					
					if(!e1.equals(e2))
					{						
						CollisionComponent cc2 = cm.get(e2);
						
						if(cc1.x+cc1.w < cc2.x || cc1.x > cc2.x+cc2.w)
						{
							System.out.println("Collision - Player:"+cc1.x+"x"+cc1.y+"y/"+cc1.w+"x"+cc1.h+" Object:"+cc2.x+"x"+cc2.y+"y/"+cc2.w+"x"+cc2.h);	
							vc.vx = 0;
							continue;
						}
						if(cc1.y+cc1.h < cc2.y || cc1.y > cc2.y+cc2.h)
						{
							System.out.println("Collision - Player:"+cc1.x+"x"+cc1.y+"y/"+cc1.w+"x"+cc1.h+" Object:"+cc2.x+"x"+cc2.y+"y/"+cc2.w+"x"+cc2.h);
							vc.vy = 0;
							continue;
						}
						
					}
				}				
			}

		}
		
	}
}
