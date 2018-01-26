package by.emptythoughts.colonizer.economics.resources;

import by.emptythoughts.colonizer.economics.resource.ResourcePlayer;

import java.util.ArrayList;

public class ResourcesPlayer implements Cloneable {
    private ArrayList<ResourcePlayer> resources;

    public ResourcesPlayer() {
        resources = new ArrayList<ResourcePlayer>();
    }

    public ResourcesPlayer(ArrayList<ResourcePlayer> resources) {
        this.resources = new ArrayList<ResourcePlayer>(resources);
    }

    public ResourcesPlayer(ResourcesPlayer resourcesPlayer) {
        resources = (ArrayList<ResourcePlayer>) resourcesPlayer.resources.clone();
    }

    public ResourcesPlayer clone() {
        return ((ResourcesPlayer) resources.clone());
    }

    public ArrayList<ResourcePlayer> getResources() {
        return resources;
    }

    public ResourcePlayer getResource(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= resources.size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return resources.get(index);
        }
    }

    public void setResource(int index, ResourcePlayer resourcePlayer) throws IndexOutOfBoundsException {
        if (index < 0 || index >= resources.size()) {
            throw new IndexOutOfBoundsException();
        } else {
            resources.set(index, resourcePlayer);
        }
    }

    public void setResources(ArrayList<ResourcesPlayer> resources) {
        this.resources = (ArrayList<ResourcePlayer>) resources.clone();
    }
}
