package by.emptythoughts.colonizer.gui;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import by.emptythoughts.colonizer.Registry;
import by.emptythoughts.colonizer.graphics.TextureGenerator;
import by.emptythoughts.colonizer.tweeners.accessors.NavigationDrawerAccessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GUIManager {
    private Stage stage;
    private TweenManager tweenManager;
    private NavigationDrawer navigationDrawer;

    public GUIManager(Stage stage, TweenManager tweenManager) {
        this.stage = stage;
        this.tweenManager = tweenManager;
        registerAccessors();
    }

    public void showGameUI() {
        Sprite navigationDrawerSprite = new Sprite(TextureGenerator.generateNavigationDrawerTexture());
        navigationDrawer = new NavigationDrawer(navigationDrawerSprite, tweenManager,
                Registry.NAVIGATION_DRAWER_ALWAYS_SHOW_PART_WIDTH,
                Registry.VIEWPORT_WIDTH - Registry.NAVIGATION_DRAWER_MARGIN_END);
        stage.addActor(navigationDrawer);
        navigationDrawer.setZIndex(Registry.GUI_Z_INDEX);
        navigationDrawer.setColor(Color.GRAY);
    }

    private void registerAccessors() {
        Tween.setCombinedAttributesLimit(4);
        Tween.registerAccessor(NavigationDrawer.class, new NavigationDrawerAccessor());
    }
}
