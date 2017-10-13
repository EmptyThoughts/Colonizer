package by.emptythoughts.colonizer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

public class TextureHandler implements Disposable {
    static TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("Background.atlas"));

    public static TextureRegion getBackgroundObjectTexture(byte distance, byte objectType) {
        switch (distance) {
            case 0:
                return atlas.findRegion("FarStar" + objectType);
            case 1:
                return atlas.findRegion("MiddleStar" + objectType);
            default:
                return atlas.findRegion("NearStar" + objectType);
        }
    }

    @Override
    public void dispose() {
        atlas.dispose();
    }
}
