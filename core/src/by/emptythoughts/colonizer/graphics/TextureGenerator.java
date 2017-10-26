package by.emptythoughts.colonizer.graphics;

import by.emptythoughts.colonizer.Registry;
import by.emptythoughts.colonizer.util.PerlinNoise;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class TextureGenerator {
    private static Pixmap pixmap;

    public static Texture generatePlanetTexture(short planetRadius, long seed) {
        PerlinNoise noise = new PerlinNoise(Registry.octavesNum, Registry.roughness, Registry.scale, seed);
        Texture result;
        pixmap = new Pixmap(planetRadius * 2, planetRadius * 2, Pixmap.Format.RGBA8888);

        pixmap.setColor(192, 168, 0, 1);
        pixmap.fillCircle(pixmap.getWidth() / 2, pixmap.getHeight() / 2, planetRadius);

        result = new Texture(pixmap);
        pixmap.dispose();

        return result;
    }
}
