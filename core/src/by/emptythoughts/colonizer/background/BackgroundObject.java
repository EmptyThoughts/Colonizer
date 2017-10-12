package by.emptythoughts.colonizer.background;

import by.emptythoughts.utils.Vector2Short;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BackgroundObject {
    private Vector2Short position;
    private TextureRegion texture;

    public BackgroundObject(short x, short y, TextureRegion texture) {
        position = new Vector2Short(x, y);
        this.texture = texture;
    }

    public void draw(Batch batch) {
        batch.draw(texture, position.x, position.y);
    }
}
