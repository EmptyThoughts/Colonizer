package by.emptythoughts.colonizer;

import aurelienribon.tweenengine.TweenManager;
import by.emptythoughts.colonizer.background.Background;
import by.emptythoughts.colonizer.graphics.TextureGenerator;
import by.emptythoughts.colonizer.gui.GUIManager;
import by.emptythoughts.colonizer.space.Planet;
import by.emptythoughts.colonizer.space.PlanetLayer;
import by.emptythoughts.utils.DebugActor;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class ColonizerGame extends ApplicationAdapter {
    private Stage mainStage;
    private TweenManager guiTweenManager;

    @Override
    public void create() {
        Camera camera = new OrthographicCamera();
        Actor debugActor = new DebugActor();
        Planet planet = new Planet(TextureGenerator.generatePlanetTexture(Registry.OCTAVES_NUM, Registry.ROUGHNESS,
                Registry.SCALE, Registry.STEP_COEF, Registry.NODES_NUM,
                new PlanetLayer(Registry.PLANET_RADIUS, Registry.MAX_HILL_HEIGHT, System.nanoTime(), 0, 0.4f, 0.4f, 1),
                new PlanetLayer((short) (Registry.PLANET_RADIUS * 7 / 8), (short) 0, System.nanoTime(), 1f, 0.75f, 0.1f, 1),
                new PlanetLayer((short) (Registry.PLANET_RADIUS / 5), (short) 0, System.nanoTime(), 1f, 1f, 0, 1)));
        Background background = new Background();
        guiTweenManager = new TweenManager();

        planet.setWidth(2 * (Registry.PLANET_RADIUS + Registry.MAX_HILL_HEIGHT));
        planet.setHeight(2 * (Registry.PLANET_RADIUS + Registry.MAX_HILL_HEIGHT));
        planet.setPosition(Math.round((Registry.VIEWPORT_WIDTH - planet.getWidth()) / 2),
                Math.round((Registry.VIEWPORT_HEIGHT - planet.getHeight()) / 2));

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, Registry.CAMERA_POSITION_Z);
        mainStage = new Stage(new ScreenViewport(camera));
        Gdx.input.setInputProcessor(mainStage);

        GUIManager guiManager = new GUIManager(mainStage, guiTweenManager);
        guiManager.showGameUI();

        mainStage.addActor(debugActor);
        mainStage.addActor(background);
        mainStage.addActor(planet);

        background.setZIndex(Registry.BACKGROUND_Z_INDEX);
        planet.setZIndex(Registry.PLANET_Z_INDEX);
        debugActor.setZIndex(Registry.DEBUG_Z_INDEX);

        Gdx.input.setInputProcessor(mainStage);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.act();
        mainStage.draw();

        guiTweenManager.update(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        mainStage.dispose();
    }
}
