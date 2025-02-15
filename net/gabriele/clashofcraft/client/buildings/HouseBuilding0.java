package net.gabriele.clashofcraft.client.buildings;

import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2i;

public class HouseBuilding0 extends Building{
    public HouseBuilding0(Texture texture, int x, int y) {
        super(texture, x, y);
    }

    /**
     * Ritorna l'ID dell'edificio. Piu' edifici possono avere lo stesso ID.
     *
     * @return l'ID
     */
    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void update(Vector2i m) {
        super.update(m);
    }

    /**
     * Cambia l'apparenza dell'edifico in base al livello.
     */
    @Override
    public void changeApparance() {

    }

    @Override
    public void initTextures() {

    }
}
