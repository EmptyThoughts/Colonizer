package by.emptythoughts.colonizer.tweeners.accessors;

import aurelienribon.tweenengine.TweenAccessor;
import by.emptythoughts.colonizer.gui.NavigationDrawer;

public class NavigationDrawerAccessor implements TweenAccessor<NavigationDrawer> {
    public static final int POSITION = 1;

    @Override
    public int getValues(NavigationDrawer target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case POSITION:
                returnValues[0] = target.getX();
                returnValues[1] = target.getY();
                return 2;
            default:
                return -1;
        }
    }

    @Override
    public void setValues(NavigationDrawer target, int tweenType, float[] newValues) {
        switch (tweenType) {
            case POSITION:
                target.setPosition(newValues[0], newValues[1]);
                break;
            default:
        }
    }
}
