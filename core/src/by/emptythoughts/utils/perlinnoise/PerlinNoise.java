package by.emptythoughts.utils.perlinnoise;

import by.emptythoughts.utils.MathUtility;

import java.util.Random;

public class PerlinNoise {
    private byte[] gradients;

    protected final byte octaves;
    protected final float roughness;
    protected final float scale;

    public PerlinNoise(byte octaves, float roughness, float scale, long seed) {
        Random rand = new Random(seed);
        this.octaves = octaves;
        this.roughness = roughness;
        this.scale = scale;
        gradients = new byte[512];
        for (int i = 0; i < 512; i++) {
            gradients[i] = (byte) (rand.nextInt(3) - 1);
        }
    }

    private float mix(float a, float b, float t) {
        return (1 - t) * a + t * b;
    }

    private float fade(float t) {
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    public float generatePerlinNoise(float x) {
        int leftBorder = MathUtility.floor(x);
        float unitCoord = x - leftBorder;

        int leftGradientIndex = (leftBorder + gradients[leftBorder & 255]) & 255;
        int rightGradientIndex = (leftBorder + 1 + gradients[leftBorder & 255]) & 255;

        float leftContribution = gradients[leftGradientIndex] * unitCoord;
        float rightContribution = gradients[rightGradientIndex] * (unitCoord - 1);

        float fadeX = fade(unitCoord);

        return mix(leftContribution, rightContribution, fadeX);
    }

    public float generateOctaved(float x) {
        float noiseSum = 0;
        float octaveFrequency = scale;
        float octaveWeight = 1;
        float weightSum = 0;

        for (int octave = 0; octave < octaves; octave++) {
            noiseSum += generatePerlinNoise(x * octaveFrequency) * octaveWeight;
            octaveFrequency *= 2;
            weightSum += octaveWeight;
            octaveWeight *= roughness;
        }

        return noiseSum / weightSum;
    }
}
