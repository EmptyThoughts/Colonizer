package by.emptythoughts.colonizer.space;

import com.badlogic.gdx.graphics.Color;

public class PlanetLayer {
    private short radius;
    private short maxHillHeight;
    private long generatorSeed;
    private Color color;

    public PlanetLayer(short radius, short maxHillHeight, long generatorSeed, float r, float g, float b, float a) {
        this.radius = radius;
        this.maxHillHeight = maxHillHeight;
        this.generatorSeed = generatorSeed;
        color = new Color(r, g, b, a);
    }

    public short getRadius() {
        return radius;
    }

    public short getMaxHillHeight() {
        return maxHillHeight;
    }

    public long getGeneratorSeed() {
        return generatorSeed;
    }

    public Color getColor() {
        return color;
    }
}
