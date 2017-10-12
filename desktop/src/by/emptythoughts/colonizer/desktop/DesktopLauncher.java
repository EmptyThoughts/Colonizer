package by.emptythoughts.colonizer.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import by.emptythoughts.colonizer.ColonizerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//asdf
		new LwjglApplication(new ColonizerGame(), config);
	}
}
