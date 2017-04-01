package com.mygdx.gamejam3;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends AbstractScreen
{

	public GameScreen(Game game)
	{
		super(game);
	}
	
	public void show()
	{
		
	}
	
	public void render(float delta)
	{
		delta = Math.min(0.06f, Gdx.graphics.getDeltaTime());
		 
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
		if (Gdx.input.isKeyPressed(Keys.ESCAPE))
		{
			game.setScreen(new MainMenu(game));
		}
	}
	
	public void hide()
	{
		Gdx.app.debug("GameJam3", "dipose game screen");
	}

}
