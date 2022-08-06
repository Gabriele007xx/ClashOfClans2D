package net.gabriele.clashofcraft.client.buildings;

import net.gabriele.clashofcraft.client.buildings.inventory.IHaveInventory;
import net.gabriele.clashofcraft.client.gamestate.LandMain;
import net.gabriele.clashofcraft.client.gui.screen.MineScreen;
import net.gabriele.clashofcraft.client.item.Items;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2i;

public class Mine extends Building implements IHaveInventory {
    private MineScreen screen = new MineScreen(450,300);
    public Mine(Texture texture, int x, int y) {
        super(texture, x, y);
    }

    /**
     * Ritorna l'ID dell'edificio. Piu' edifici possono avere lo stesso ID.
     *
     * @return l'ID
     */
    @Override
    public int getID() {
        return 2;
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

    @Override
    public void update(Vector2i mouse) {
        super.update(mouse);
        if(screen.getMineInventory().getItembySlot(0).asItem() == Items.COBBLESTONE)
        {
            System.out.println("COBBLESTONINA");
        }
    }

    @Override
    public void showInventory() {
        LandMain.windows.add(screen);
    }
}
