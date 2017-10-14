package by.emptythoughts.colonizer.space;

import by.emptythoughts.colonizer.Registry;
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
        batch.draw(planetTexture, (Registry.viewportWidth - planetTexture.getWidth()) / 2,
                (Registry.viewportHeight - planetTexture.getHeight()) / 2);
    }
}
