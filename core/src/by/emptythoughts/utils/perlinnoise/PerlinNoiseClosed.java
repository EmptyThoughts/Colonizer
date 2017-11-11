package by.emptythoughts.utils.perlinnoise;

public class PerlinNoiseClosed extends PerlinNoise {
    private final float stepCoef;

    public PerlinNoiseClosed(byte octaves, float roughness, float scale, float stepCoef, long seed) {
        super(octaves, roughness, scale, seed);
        this.stepCoef = stepCoef;
    }

    public float generateOctavedClosed(float x, short length) {
        float noiseSum = 0;
        float iterSum;
        float scaledX = x * scale;
        float scaledLength = length * scale;
        float octaveFrequency = scale;
        float octaveWeight = roughness;
        float weightSum = 0;
        float coordLeft;
        float coordRight;

        for (int octave = 0; octave < octaves; octave++) {
            iterSum = 0;
            coordLeft = scaledX - scaledLength * octaveFrequency * stepCoef;
            coordRight = scaledX + scaledLength * octaveFrequency * stepCoef;

            while (coordLeft < 0) {
                coordLeft += scaledLength;
            }
            while (coordRight < 0) {
                coordRight += scaledLength;
            }
            while (coordLeft >= scaledLength) {
                coordLeft -= scaledLength;
            }
            while (coordRight >= scaledLength) {
                coordRight -= scaledLength;
            }

            iterSum += generatePerlinNoise(coordLeft);
            iterSum += generatePerlinNoise(coordRight);
            noiseSum += iterSum * octaveWeight / 2;
            octaveFrequency *= 2;
            weightSum += octaveWeight;
            octaveWeight *= roughness;
        }

        return noiseSum / weightSum;
    }
}
