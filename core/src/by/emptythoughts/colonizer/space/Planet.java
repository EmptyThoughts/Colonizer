package by.emptythoughts.colonizer.space;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Planet extends Actor {
    private Texture planetTexture;

    public Planet(Texture planetTexture) {
        this.planetTexture = planetTexture;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(planetTexture, getX(), getY());
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return super.hit(x, y, touchable);
    }
}
