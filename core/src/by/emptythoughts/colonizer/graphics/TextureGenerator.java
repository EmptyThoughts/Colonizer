package by.emptythoughts.colonizer.graphics;

import by.emptythoughts.colonizer.Registry;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class TextureGenerator {
    private static Pixmap pixmap;

    public static Texture generatePlanetTexture() {
        Texture result;
        pixmap = new Pixmap(Registry.planetRadius * 2, Registry.planetRadius * 2, Pixmap.Format.RGBA8888);

        pixmap.setColor(192, 168, 0, 1);
        pixmap.fillCircle(pixmap.getWidth() / 2, pixmap.getHeight() / 2, Registry.planetRadius);

        result = new Texture(pixmap);
        pixmap.dispose();

        return result;
    }

    public static Texture generateNavigationDrawerTexture() {
        Texture result;
        pixmap = new Pixmap(Registry.viewportWidth, Registry.viewportHeight, Pixmap.Format.RGBA8888);

        pixmap.setColor(Color.GRAY);
        pixmap.fillRectangle(0, 0, pixmap.getWidth(), pixmap.getHeight());

        result = new Texture(pixmap);
        pixmap.dispose();

        return result;
    }
}
