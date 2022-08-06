package net.gabriele.clashofcraft.client.gui.screen;

import net.gabriele.clashofcraft.client.gui.ImageButton;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Classe di base per tutte le finestre che compaiono nel gioco
 */
public abstract class Window {
    protected RectangleShape window = new RectangleShape();
    protected ImageButton CLOSE;
    protected HashMap<String, Texture> button_t = new HashMap<>();
    protected boolean isClosed = false;
    public Window(int sizex,int sizey)
    {
        initImageT();
        window.setSize(new Vector2f(sizex,sizey));
        window.setOrigin(window.getSize().x / 2,window.getSize().y / 2);
        window.setFillColor(Color.WHITE);
        window.setPosition(640,360);
        CLOSE = new ImageButton(window.getGlobalBounds().left + window.getGlobalBounds().width - 40,window.getGlobalBounds().top,40,40,button_t.get("close")) {
            @Override
            public void update(Vector2i mouse) {
                if(sprite.getGlobalBounds().contains(new Vector2f(mouse)))
                {
                    if(Mouse.isButtonPressed(Mouse.Button.LEFT))
                    {
                        Window.this.setClosed();
                    }
                }
            }
        };
    }
    protected void initImageT()
    {
        Texture closet = new Texture();
        try {
            closet.loadFromFile(Paths.get("Assets/graphics/ui/close.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        button_t.put("close", closet);
    }

    public void setClosed() {
        this.isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }
    public void render(RenderTarget target)
    {
        target.draw(window);
        CLOSE.render(target);
    }
    public void update(Vector2i mouse)
    {
        CLOSE.update(mouse);
    }
}
