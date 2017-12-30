package by.emptythoughts.colonizer.desktop;

import by.emptythoughts.colonizer.Registry;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import by.emptythoughts.colonizer.ColonizerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Colonizer";
		config.width = Registry.VIEWPORT_WIDTH;
		config.height = Registry.VIEWPORT_HEIGHT;
		config.vSyncEnabled = false;
		config.foregroundFPS = 0;
		config.backgroundFPS = 0;

		new LwjglApplication(new ColonizerGame(), config);
	}
}
