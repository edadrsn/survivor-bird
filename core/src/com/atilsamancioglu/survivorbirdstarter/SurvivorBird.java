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
	float birdX=0,birdY=0;

	//Proje başladığında çalışacak olan metod
	@Override
	public void create () {
		batch=new SpriteBatch();
		background=new Texture("background.png");
		bird=new Texture("bird.png");
		birdX=Gdx.graphics.getWidth()/2-bird.getHeight()/2;
		birdY=Gdx.graphics.getHeight()/3;

	}
	//Oyun döngüsü
	@Override
	public void render () {
		//Hangi objeleri çizeceğimizi yazıcaz
		batch.begin();
		batch.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch.draw(bird,birdX,birdY,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()/10	);


		batch.end();

	}

	//Oyun kapatıldığında çalışacak olan metod
	@Override
	public void dispose () {

	}
}
