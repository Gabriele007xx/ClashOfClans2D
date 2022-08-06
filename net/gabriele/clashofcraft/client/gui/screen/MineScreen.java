package net.gabriele.clashofcraft.client.gui.screen;

import net.gabriele.clashofcraft.client.buildings.inventory.IHaveInventory;
import net.gabriele.clashofcraft.client.buildings.inventory.mine.MineInventory;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2i;

public class MineScreen extends Window {
    private MineInventory mineInventory;
    public MineScreen(int sizex, int sizey) {
        super(sizex, sizey);
        mineInventory = new MineInventory(2,window.getGlobalBounds().left);
    }

    @Override
    public void render(RenderTarget target) {
        super.render(target);
        mineInventory.render(target);
    }

    @Override
    public void update(Vector2i mouse) {
        super.update(mouse);
    }

    public MineInventory getMineInventory() {
        return mineInventory;
    }
}
