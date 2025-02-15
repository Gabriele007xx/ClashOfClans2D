package net.gabriele.clashofcraft.client.gui;

import net.gabriele.clashofcraft.client.gamestate.LandMain;
import net.gabriele.clashofcraft.client.gui.screen.InfoWindow;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;

public class ImageButton extends Button{
    protected Sprite sprite = new Sprite();
    private Texture texture = new Texture();
    public ImageButton(float x, float y, float width, float height, String text, Font font, Color idlec, Color hovc, Color actc, Color textac, Color texthc, Color textidc, int charS) {
        super(x, y, width, height, text, font, idlec, hovc, actc, textac, texthc, textidc, charS);
    }
    public ImageButton(float x, float y, float width, float height, Texture image)
    {
        super();
        sprite.setPosition(x,y);
        this.texture = image;
        sprite.setTexture(this.texture);
    }

    @Override
    public void render(RenderTarget target) {
        target.draw(sprite);
    }

    @Override
    public void update(Vector2i mousepos) {

    }
}
