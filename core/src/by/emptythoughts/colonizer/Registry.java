package by.emptythoughts.colonizer;

public class Registry {
    public static final short VIEWPORT_WIDTH = 405;
    public static final short VIEWPORT_HEIGHT = 720;

    public static final byte BACKGROUND_OBJECTS_NUM = 5;
    public static final byte BACKGROUND_OBJECTS_GAP_CONST = 10;
    public static final byte BACKGROUND_MAX_DISTANCE = 3;

    public static final byte OCTAVES_NUM = 7;
    public static final float ROUGHNESS = 0.25f;
    public static final float SCALE = 0.03f;
    public static final float STEP_COEF = 0.025f;

    public static final short PLANET_RADIUS = 150;
    public static final short NODES_NUM = 360;
    public static final byte MAX_HILL_HEIGHT = 12;

    public static final byte CAMERA_POSITION_Z = 127;

    public static final int BACKGROUND_Z_INDEX = 0;
    public static final int PLANET_Z_INDEX = 1;
    public static final int GUI_Z_INDEX = 2;
    public static final int DEBUG_Z_INDEX = 3;

    public static final float NAVIGATION_DRAWER_ALWAYS_SHOW_PART_WIDTH = 100f;
    public static final float NAVIGATION_DRAWER_MARGIN_END = 100f;
    public static final float NAVIGATION_DRAWER_TWEEN_DURATION = 0.1f;
}
