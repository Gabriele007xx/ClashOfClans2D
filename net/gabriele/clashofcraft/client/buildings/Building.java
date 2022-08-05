package net.gabriele.clashofcraft.client.buildings;

import net.gabriele.clashofcraft.client.gamestate.LandMain;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;

public abstract class Building {
    protected int MAX_LEVEL;
    protected int CURRENT_LEVEL = 1;
    protected Texture texture = new Texture();
    protected Sprite sprite = new Sprite();
    protected BuildingTypeEnum type;
    public Building(Texture texture,int x,int y)
    {
        this.texture = texture;
        sprite.setTexture(texture);
        sprite.setOrigin(this.texture.getSize().x / 2,this.texture.getSize().y / 2 );
        sprite.setPosition(x,y);
    }
    public BuildingTypeEnum getType() {
        return type;
    }

    public int getCURRENT_LEVEL() {
        return CURRENT_LEVEL;
    }

    public void setCURRENT_LEVEL(int CURRENT_LEVEL) {
        this.CURRENT_LEVEL = CURRENT_LEVEL;
    }

    /**
     * Ritorna l'ID dell'edificio. Piu' edifici possono avere lo stesso ID.
     * @return l'ID
     */
    public abstract int getID();

    /**
     * Cambia l'apparenza dell'edifico in base al livello.
     */
    public abstract void changeApparance();
    public abstract void initTextures();
    public void render(RenderTarget target)
    {
        target.draw(this.sprite);
    }
    public void update(Vector2i mouse)
    {
       if(sprite.getGlobalBounds().contains(new Vector2f(mouse)))
       {
           if(Mouse.isButtonPressed(Mouse.Button.LEFT))
           {
               LandMain.CURRENT_BUILDING_SELECTION = this.getID();
               System.out.println("Impostato l'ID slezione a " + this.getID());
           }

       }
    }

    public Texture getTexture() {
        return texture;
    }
}
