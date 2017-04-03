package com.mygdx.gamejam3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.Align;

public class ScreenWriter
{
	public FreeTypeFontGenerator ttf;
	public FreeTypeFontParameter fp;
	public BitmapFont font;
	public Color c;
	public SpriteBatch batch;
	public int alignment;
	
	public ScreenWriter(String filename, SpriteBatch batch)
	{
		ttf = new FreeTypeFontGenerator(Gdx.files.internal(filename));
		fp = new FreeTypeFontParameter();
		this.batch = batch;
		alignment = Align.topLeft;
	}
	
	public ScreenWriter(SpriteBatch batch)
	{
		this.batch = batch;
		alignment = Align.topLeft;
	}
	
	public void setTTF(String filename)
	{
		ttf = new FreeTypeFontGenerator(Gdx.files.internal(filename));
		fp = new FreeTypeFontParameter();
	}
	
	
	public void setFontSize(int size)
	{
		fp.size = size;
		fp.characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.!?'>[]1234567890:,/";
		font = ttf.generateFont(fp);
	}
	
	public void setColor(Color c)
	{
		this.c = c;
	}
	
	public void writeScreen(String text, float x, float y, int start, int end, float width)
	{
		batch.begin();
		font.setColor(c);
		font.draw(batch, text, x, y, start, end, width, alignment, true);
		batch.end();
	}
	
	public void dispose()
	{
		font.dispose();
		ttf.dispose();
	}

}
