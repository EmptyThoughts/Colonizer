package by.emptythoughts.utils;

public class Vector2Short {
    public short x;
    public short y;

    public Vector2Short() {
        x = 0;
        y = 0;
    }

    public Vector2Short(short x, short y) {
        this.x = x;
        this.y = y;
    }

    public Vector2Short(Vector2Short vector) {
        x = vector.x;
        y = vector.y;
    }

    public void set(Vector2Short vector) {
        x = vector.x;
        y = vector.y;
    }

    public void set(short x, short y) {
        this.x = x;
        this.y = y;
    }
}
