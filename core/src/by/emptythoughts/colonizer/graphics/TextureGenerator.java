package by.emptythoughts.colonizer.graphics;

import by.emptythoughts.colonizer.Registry;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import by.emptythoughts.colonizer.space.PlanetLayer;
import by.emptythoughts.utils.perlinnoise.PerlinNoiseClosed;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import java.util.Arrays;
import java.util.Comparator;

public class TextureGenerator {
    private static Pixmap pixmap;

    public static Texture generatePlanetTexture(byte octavesNum, float roughness, float scale, float stepCoef,
                                                short maxNodeNum, PlanetLayer... layers) {
        PerlinNoiseClosed noise;
        Texture result;
        int[] vertices;
        short planetRadius;
        short currentNodeNum;
        float currentRadius;
        float currentRadians;
        int offset;

        Arrays.sort(layers, new Comparator<PlanetLayer>() {
            @Override
            public int compare(PlanetLayer layerLeft, PlanetLayer layerRight) {
                return layerRight.getRadius() - layerLeft.getRadius();
            }
        });

        planetRadius = layers[0].getRadius();
        offset = planetRadius + layers[0].getMaxHillHeight();
        pixmap = new Pixmap(2 * (planetRadius + layers[0].getMaxHillHeight()),
                2 * (planetRadius + layers[0].getMaxHillHeight()), Pixmap.Format.RGBA8888);

        for (PlanetLayer layer : layers) {
            noise = new PerlinNoiseClosed(octavesNum, roughness, scale, stepCoef, layer.getGeneratorSeed());
            currentNodeNum = (short) Math.round(maxNodeNum * layer.getRadius() / planetRadius);
            vertices = new int[2 * currentNodeNum];

            for (int j = 0; j < vertices.length; j += 2) {
                currentRadius = layer.getRadius() + layer.getMaxHillHeight() * noise.generateOctavedClosed(j / 2, currentNodeNum);
                currentRadians = (float) (j * Math.PI / currentNodeNum);
                vertices[j] = offset + (int) Math.round(currentRadius * Math.cos(currentRadians));
                vertices[j + 1] = offset + (int) Math.round(currentRadius * Math.sin(currentRadians));
            }

            pixmap.setColor(layer.getColor());
            for (int j = 0; j < vertices.length - 2; j += 2) {
                pixmap.fillTriangle(vertices[j], vertices[j + 1], vertices[j + 2], vertices[j + 3], offset, offset);
            }
            pixmap.fillTriangle(vertices[0], vertices[1], vertices[vertices.length - 2], vertices[vertices.length - 1], offset, offset);
        }

        result = new Texture(pixmap);
        pixmap.dispose();

        return result;
    }

    public static Texture generateNavigationDrawerTexture() {
        Texture result;
        pixmap = new Pixmap(Registry.viewportWidth, Registry.viewportHeight, Pixmap.Format.RGBA8888);

        pixmap.setColor(Color.GRAY);
        pixmap.fillRectangle(0, 0, pixmap.getWidth(), pixmap.getHeight());

        result = new Texture(pixmap);
        pixmap.dispose();

        return result;
    }
}
