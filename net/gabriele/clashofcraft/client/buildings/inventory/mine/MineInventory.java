package net.gabriele.clashofcraft.client.buildings.inventory.mine;

import net.gabriele.clashofcraft.client.buildings.inventory.Inventory;
import net.gabriele.clashofcraft.client.item.Item;
import net.gabriele.clashofcraft.client.item.Items;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;

public class MineInventory extends Inventory {
    public MineInventory(int capacity, float x) {
        super(capacity);
        for (int i =0;i<2;i++)
        {
            if(i == 0)
            {
                slots[i].setPosition((int) x + 20,360 - slots[i].getSIZE());
            }
            else if(i == 1){
                slots[i].setPosition((int) x + 70, 360 - slots[i].getSIZE());
            }
            add(Items.COBBLESTONE,0);

        }
    }

    @Override
    public void update(Vector2f mouseP) {

    }

    @Override
    public void render(RenderTarget target) {
        for(int i =0;i<2;i++)
        {
           target.draw(slots[i].getSprite());
           if(items[i].getItem().asItem() != Items.NO_ITEM)
           {
               target.draw(items[i].getItem().asItem().getSprite());
           }

        }
    }
}
