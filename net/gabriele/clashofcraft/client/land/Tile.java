package net.gabriele.clashofcraft.client.land;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

public class Tile {
    private Texture texture = new Texture();
    Sprite sprite = new Sprite();
    public Tile(Texture texture,float x, float y)
    {
        this.texture = texture;
        sprite.setTexture(this.texture);
        sprite.setPosition(new Vector2f(x,y));
    }
    public void render(RenderTarget target)
    {
        target.draw(sprite);
    }
    public void update()
    {

    }
}
