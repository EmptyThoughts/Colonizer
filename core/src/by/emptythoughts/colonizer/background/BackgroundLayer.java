package by.emptythoughts.colonizer.background;

import by.emptythoughts.colonizer.Registry;
import by.emptythoughts.colonizer.TextureHandler;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

public class BackgroundLayer {
    private BackgroundObject[] layerObjects;

    public BackgroundLayer(byte distance) {
        Random rand = new Random();
        short objectsGap = (short) Math.pow(Registry.backgroundObjectsGapConst, distance);
        short currentGap = (short) rand.nextInt(objectsGap);

        layerObjects = new BackgroundObject[Registry.viewportHeight / objectsGap];
        for (short i = 0; i < layerObjects.length; i++) {
            layerObjects[i] = new BackgroundObject((short) rand.nextInt(Registry.viewportWidth), currentGap,
                    TextureHandler.getBackgroundObjectTexture(distance, (byte) rand.nextInt(Registry.backgroundObjectsNum)));
            currentGap += objectsGap;
        }
    }

    public void draw(Batch batch) {
        for (BackgroundObject object : layerObjects) {
            object.draw(batch);
        }
    }
}
