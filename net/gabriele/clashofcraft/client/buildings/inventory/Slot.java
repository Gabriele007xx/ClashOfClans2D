package net.gabriele.clashofcraft.client.buildings.inventory;

import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

import java.io.IOException;
import java.nio.file.Paths;

public class Slot {
    private Texture slot = new Texture();
    private int SIZE = 16;
    private Sprite sprite = new Sprite();

    public Slot(int offset)
    {
        try {
            slot.loadFromFile(Paths.get("Assets/graphics/ui/slot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sprite.setTexture(slot);
        sprite.setPosition(new Vector2f(offset*SIZE + 250, 460));
    }
    public Slot(int x,int y)
    {
        try {
            slot.loadFromFile(Paths.get("Assets/graphics/ui/slot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sprite.setTexture(slot);
        sprite.setPosition(new Vector2f(x, y));
    }
    public Slot()
    {
        try {
            slot.loadFromFile(Paths.get("Assets/graphics/ui/slot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sprite.setTexture(slot);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getSIZE() {
        return SIZE;
    }

    public void setPosition(int x,int y)
    {
        sprite.setPosition(new Vector2f(x,y));
    }
}
