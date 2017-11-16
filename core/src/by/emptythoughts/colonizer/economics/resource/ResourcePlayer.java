package by.emptythoughts.colonizer.economics.resource;

public class ResourcePlayer extends Resource {
    private int amount;

    public ResourcePlayer() {
        super();
        amount = 0;
    }

    public ResourcePlayer(String name, int amount) {
        super(name);
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmout(int amount) {
        this.amount = amount;
    }
}
