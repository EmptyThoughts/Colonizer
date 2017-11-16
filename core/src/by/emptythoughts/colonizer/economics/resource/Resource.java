package by.emptythoughts.colonizer.economics.resource;

public class Resource {
    private String name;

    public Resource(){
        this.name = "";
    }

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
