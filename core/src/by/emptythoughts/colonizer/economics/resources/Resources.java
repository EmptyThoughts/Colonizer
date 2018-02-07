package by.emptythoughts.colonizer.economics.resources;

import java.util.ArrayList;

public class Resources<T> implements Cloneable {
    private ArrayList<T> resources;

    public Resources() {
        resources = new ArrayList<T>();
    }

    public Resources(ArrayList<T> resources) {
        this.resources = new ArrayList<T>(resources);
    }

    public Resources(Resources resources) {
        this.resources = (ArrayList<T>) resources.resources.clone();
    }

    public Resources<T> clone() {
        return ((Resources<T>) resources.clone());
    }

    public ArrayList<T> getResources() {
        return resources;
    }

    public T getResource(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= resources.size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return resources.get(index);
        }
    }

    public void setResource(int index, T resourcePlayer) throws IndexOutOfBoundsException {
        if (index < 0 || index >= resources.size()) {
            throw new IndexOutOfBoundsException();
        } else {
            resources.set(index, resourcePlayer);
        }
    }

    public void setResources(ArrayList<T> resources) {
        this.resources = (ArrayList<T>) resources.clone();
    }
}
