package by.emptythoughts.colonizer;

import by.emptythoughts.colonizer.background.Background;
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

        debugActor.setZIndex(Registry.cameraPositionZ);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, Registry.cameraPositionZ);

        mainStage = new Stage(new ScreenViewport(camera));
        mainStage.addActor(debugActor);
        mainStage.addActor(new Background());
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
