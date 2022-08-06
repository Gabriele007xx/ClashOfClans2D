package net.gabriele.clashofcraft.client.item;

import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class Item {
    private Texture texture = new Texture();
    private Sprite sprite = new Sprite();
    private int id;
    private int maxStackSize;
    public Item(Texture texture, int id, int maxStackSize)
    {
        this.id = id;
        this.texture = texture;
        this.maxStackSize = maxStackSize;
        this.sprite.setTexture(this.texture);
    }
    public Sprite getSprite() {
        return sprite;
    }
    public int getId() {
        return id;
    }
    public Item asItem()
    {
        return this;
    }
    public int getMaxStackSize() {
        return maxStackSize;
    }

}
