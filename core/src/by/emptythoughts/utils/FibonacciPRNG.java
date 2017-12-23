package by.emptythoughts.utils;

import java.util.ArrayList;
import java.util.Random;

public class FibonacciPRNG {
    private ArrayList<Double> prevNums;
    private int a;
    private int b;
    private int offset;

    public FibonacciPRNG(int a, int b, long seed) {
        Random rand = new Random(seed);
        this.a = Math.max(a, b);
        this.b = Math.min(a, b);
        prevNums = new ArrayList<Double>(this.a + 1);

        for (int i = 0; i < this.a + 1; i++) {
            prevNums.add(rand.nextDouble());
        }

        offset = this.a - this.b;
    }

    public int nextInt(int bound) {
        return (int)(bound * nextDouble());
    }

    public float nextFloat() {
        return (float)nextDouble();
    }

    public double nextDouble() {
        prevNums.add((prevNums.get(0) < prevNums.get(offset)) ? prevNums.get(0) - prevNums.get(offset) + 1 : prevNums.get(0) - prevNums.get(offset));
        prevNums.remove(0);
        return prevNums.get(a);
    }
}
