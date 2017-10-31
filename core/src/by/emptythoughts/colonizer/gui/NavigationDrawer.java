package by.emptythoughts.colonizer.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class NavigationDrawer extends Actor {
    private Texture navigationDrawerTexture;
    private Vector2 touchDownPosition;
    private Vector2 touchPosition;

    public NavigationDrawer(Texture rectangleTexture) {
        this.navigationDrawerTexture = rectangleTexture;
        this.touchDownPosition = new Vector2();
        this.touchPosition = new Vector2();
        this.setBounds(0, 0, rectangleTexture.getWidth(), rectangleTexture.getHeight());
        addListener();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(navigationDrawerTexture, getX(), getY());
    }

    private void addListener() {
        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touchDownPosition.x = x;
                touchDownPosition.y = y;
                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                touchPosition.x = x;
                touchPosition.y = y;
                Vector2 stagePosition = localToStageCoordinates(touchPosition);
                setPosition(stagePosition.x - touchDownPosition.x, getY());
            }
        });
    }
}
