package by.emptythoughts.colonizer.gui;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;
import by.emptythoughts.colonizer.Registry;
import by.emptythoughts.colonizer.tweeners.accessors.NavigationDrawerAccessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class NavigationDrawer extends Actor {
    private Sprite navigationDrawerSprite;
    private Vector2 touchDownPosition;
    private Vector2 touchDownStagePosition;
    private Vector2 touchPosition;
    private Color color;
    private TweenManager tweenManager;
    private boolean isOpened;
    private float beginPosition;
    private float endPosition;
    private float differenceEndBeginPosition;

    public NavigationDrawer(Sprite sprite, TweenManager tweenManager, float alwaysShowPartWidth, float endPosition) {
        this.navigationDrawerSprite = sprite;
        this.touchDownPosition = new Vector2();
        this.touchDownStagePosition = new Vector2();
        this.touchPosition = new Vector2();
        this.setBounds(0, 0, sprite.getWidth(), sprite.getHeight());
        this.color = Color.WHITE;
        this.tweenManager = tweenManager;
        this.isOpened = false;
        this.beginPosition = alwaysShowPartWidth - getWidth();
        this.endPosition = endPosition - getWidth();
        this.differenceEndBeginPosition = this.endPosition - this.beginPosition;
        setX(beginPosition);
        addListener();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color defaultColor = batch.getColor();
        batch.setColor(color);
        batch.draw(navigationDrawerSprite, getX(), getY());
        batch.setColor(defaultColor);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    private void addListener() {
        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Vector2 originalTouchDownPosition;
                touchDownPosition.x = x;
                touchDownPosition.y = y;

                originalTouchDownPosition = touchDownPosition.cpy();
                touchDownStagePosition = localToStageCoordinates(touchDownPosition);
                touchDownPosition = originalTouchDownPosition;

                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                float newPositionX;
                touchPosition.x = x;
                touchPosition.y = y;

                localToStageCoordinates(touchPosition);
                newPositionX = touchPosition.x - touchDownPosition.x;
                if (newPositionX >= beginPosition && newPositionX <= endPosition) {
                    setPosition(newPositionX, getY());
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                float touchDownUpDifference;
                float durationCoef;
                Vector2 touchUpPosition = new Vector2(x, y);
                localToStageCoordinates(touchUpPosition);
                touchDownUpDifference = touchDownStagePosition.x - touchUpPosition.x;

                if (touchDownUpDifference > 0 && isOpened) {
                    durationCoef = (getX() - beginPosition) / differenceEndBeginPosition;
                    Tween.to(NavigationDrawer.this, NavigationDrawerAccessor.POSITION,
                            Registry.NAVIGATION_DRAWER_TWEEN_DURATION * durationCoef)
                            .target(beginPosition, getY())
                            .ease(TweenEquations.easeNone)
                            .start(tweenManager);
                    isOpened = !isOpened;
                } else if (touchDownUpDifference < 0 && !isOpened) {
                    durationCoef = (endPosition - getX()) / differenceEndBeginPosition;
                    Tween.to(NavigationDrawer.this, NavigationDrawerAccessor.POSITION,
                            Registry.NAVIGATION_DRAWER_TWEEN_DURATION * durationCoef)
                            .target(endPosition, getY())
                            .ease(TweenEquations.easeNone)
                            .start(tweenManager);
                    isOpened = !isOpened;
                }
            }
        });
    }
}
