package com.mygdx.gamejam3;

import java.lang.reflect.Field;

public class EngineDebugger
{
	public EngineDebugger()
	{
		
	}
	
	public void Inspect(Object o)
	{
		System.out.println(">"+o.getClass().getSimpleName()+":");
		for(Field f:o.getClass().getFields())
		{
			try
			{
				System.out.println("->"+f.getName()+": "+f.get(o));
			} catch (IllegalArgumentException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
