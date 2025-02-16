package com.atilsamancioglu.survivorbirdstarter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SurvivorBird extends ApplicationAdapter {

	SpriteBatch batch;
	Texture background;
	Texture bird;

	//Proje başladığında çalışacak olan metod
	@Override
	public void create () {
		batch=new SpriteBatch();
		background=new Texture("background.png");
		bird=new Texture("bird.png");

	}
	//Oyun döngüsü
	@Override
	public void render () {
		//Hangi objeleri çizeceğimizi yazıcaz
		batch.begin();
		batch.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());


		batch.end();

	}

	//Oyun kapatıldığında çalışacak olan metod
	@Override
	public void dispose () {

	}
}
