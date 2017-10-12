package by.emptythoughts.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class DebugActor extends Actor {
    private BitmapFont font;

    public DebugActor() {
        font = new BitmapFont();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond() + " Memory: " +
                (Gdx.app.getNativeHeap() + Gdx.app.getJavaHeap()) / 1024 / 1024, 1, 15);
    }
}
