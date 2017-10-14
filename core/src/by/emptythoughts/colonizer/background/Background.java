package by.emptythoughts.colonizer.background;

import by.emptythoughts.colonizer.Registry;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor {
    private BackgroundLayer[] layers;

    public Background() {
        setZIndex(0);
        layers = new BackgroundLayer[Registry.backgroundMaxDistance];
        for (byte i = 0; i < Registry.backgroundMaxDistance; i++) {
            layers[i] = new BackgroundLayer(i);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (BackgroundLayer layer : layers) {
            layer.draw(batch);
        }
    }
}