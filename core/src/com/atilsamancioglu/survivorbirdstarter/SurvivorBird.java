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
    Texture bee1;
    Texture bee2;
    Texture bee3;
    float birdX = 0, birdY = 0;
    int gameState = 0;
    float velocity = 0;
    float gravity = 0.50f;
    int numberOfEnemies = 4;
    float[] enemyX = new float[numberOfEnemies];
    float distance = 0;

    float enemyVelocity = 2;

    //Proje başladığında çalışacak olan metod
    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("background.png");
        bird = new Texture("bird.png");
        birdX = Gdx.graphics.getWidth() / 3 - bird.getHeight() / 2;
        birdY = Gdx.graphics.getHeight() / 3;
        bee1 = new Texture("bee.png");
        bee2 = new Texture("bee.png");
        bee3 = new Texture("bee.png");

        distance = Gdx.graphics.getWidth() / 2;

        for (int i = 0; i < numberOfEnemies; i++) {
            enemyX[i] = Gdx.graphics.getWidth() - bee1.getWidth() / 2 + i * distance;
        }


    }

    //Oyun döngüsü
    @Override
    public void render() {

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        if (Gdx.input.justTouched()) {
            velocity = -10;
        }

        for (int i = 0; i < numberOfEnemies; i++) {

            if (enemyX[i] < Gdx.graphics.getWidth() / 15) {
                enemyX[i]=enemyX[i]+numberOfEnemies*distance;
            }else{
                enemyX[i] -= enemyVelocity;
            }

            batch.draw(bee1, enemyX[i], 50, Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);
            batch.draw(bee2, enemyX[i], 150, Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);
            batch.draw(bee3, enemyX[i], 350, Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);

        }
        if (gameState == 1) {


            if (birdY > 0 || velocity < 0) {
                velocity += gravity;
                birdY -= velocity;
            }
        } else {
            if (Gdx.input.justTouched()) {
                gameState = 1;
            }
        }

        //Hangi objeleri çizeceğimizi yazıcaz
        batch.draw(bird, birdX, birdY, Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);
        batch.end();

    }

    //Oyun kapatıldığında çalışacak olan metod
    @Override
    public void dispose() {

    }
}
