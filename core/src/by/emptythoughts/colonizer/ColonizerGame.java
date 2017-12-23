package by.emptythoughts.colonizer;

import by.emptythoughts.colonizer.background.Background;
import by.emptythoughts.colonizer.graphics.TextureGenerator;
import by.emptythoughts.colonizer.gui.NavigationDrawer;
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

    @Override
    public void create() {
        Camera camera = new OrthographicCamera();
        Actor debugActor = new DebugActor();
        Planet planet = new Planet(TextureGenerator.generatePlanetTexture(Registry.octavesNum, Registry.roughness,
                Registry.scale, Registry.stepCoef, Registry.nodesNum,
                new PlanetLayer(Registry.planetRadius, Registry.maxHillHeight, System.nanoTime(), 0, 0.4f, 0.4f, 1),
                new PlanetLayer((short) (Registry.planetRadius * 7 / 8), (short) 0, System.nanoTime(), 1f, 0.75f, 0.1f, 1),
                new PlanetLayer((short) (Registry.planetRadius / 5), (short) 0, System.nanoTime(), 1f, 1f, 0, 1)));
        Background background = new Background();
        NavigationDrawer navigationDrawer = new NavigationDrawer(TextureGenerator.generateNavigationDrawerTexture());

        debugActor.setZIndex(Registry.cameraPositionZ);
        planet.setZIndex(1);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, Registry.cameraPositionZ);

        mainStage = new Stage(new ScreenViewport(camera));
        Gdx.input.setInputProcessor(mainStage);
        mainStage.addActor(debugActor);
        mainStage.addActor(background);

        planet.setWidth(2 * (Registry.planetRadius + Registry.maxHillHeight));
        planet.setHeight(2 * (Registry.planetRadius + Registry.maxHillHeight));
        planet.setPosition(Math.round((Registry.viewportWidth - planet.getWidth()) / 2),
                Math.round((Registry.viewportHeight - planet.getHeight()) / 2));

        mainStage.addActor(planet);
        mainStage.addActor(navigationDrawer);

        background.setZIndex(0);
        planet.setZIndex(1);
        navigationDrawer.setZIndex(2);
        debugActor.setZIndex(3);

        Gdx.input.setInputProcessor(mainStage);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.act();
        mainStage.draw();
    }

    @Override
    public void dispose() {
        mainStage.dispose();
    }
}
