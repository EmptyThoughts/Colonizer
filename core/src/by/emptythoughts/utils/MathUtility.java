package by.emptythoughts.utils;

public class MathUtility {
    public static float avg(float... args) {
        float sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum / args.length;
    }

    public static double avg(double... args) {
        double sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum / args.length;
    }

    public static int floor(double x) {
        int tmp = (int) x;
        return (tmp > x) ? tmp - 1 : tmp;
    }
}
