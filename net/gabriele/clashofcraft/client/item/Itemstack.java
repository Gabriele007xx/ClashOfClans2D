package net.gabriele.clashofcraft.client.item;

public class Itemstack {
    private int count;
    public static Itemstack EMPTY = new Itemstack(Items.NO_ITEM,0);
    private Item item;
    public Itemstack(Item item,int count)
    {
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
