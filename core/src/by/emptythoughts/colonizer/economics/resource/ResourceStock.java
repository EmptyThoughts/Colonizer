package by.emptythoughts.colonizer.economics.resource;

public class ResourceStock extends Resource{
    private int cost;

    public ResourceStock(){
        super();
        cost = 0;
    }

    public ResourceStock(String name, int cost){
        super(name);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
