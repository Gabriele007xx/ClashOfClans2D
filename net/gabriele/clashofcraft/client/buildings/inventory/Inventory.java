package net.gabriele.clashofcraft.client.buildings.inventory;

import net.gabriele.clashofcraft.client.item.Item;
import net.gabriele.clashofcraft.client.item.Items;
import net.gabriele.clashofcraft.client.item.Itemstack;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;

public abstract class Inventory {
    protected int index_selected = -1;
    protected int capacity;
    protected int nitems;
    protected Itemstack[] items;
    protected Slot[] slots;
    public Inventory(int capacity)
    {
        this.capacity = capacity;
        items = new Itemstack[this.capacity];
        this.nitems = 0;
        slots = new Slot[this.capacity];
        for(int i=0;i<this.capacity;i++)
        {
            slots[i] = new Slot();
        }
        for(int i = 0;i<this.capacity;i++)
        {
            items[i] = Itemstack.EMPTY;
        }
        //for(int i=0;i<this.capacity;i++)
        //{
        //    slots[i] = new Slot(i);
        //}
    }
    public boolean add(Item item,int index)
    {
        if(nitems < capacity)
        {
            items[index].setItem(item);
            nitems++;
            return true;
        }
        return false;
    }
    public boolean remove(int index)
    {
        if(nitems > 0 && index < capacity)
        {
            items[index].setItem(Items.NO_ITEM);
            nitems--;
            return true;
        }
        return false;
    }

    /**
     * Usato per svuotare l'inventario
     */
    public void Empty() {
        for (int i = 0; i < capacity; i++) {
            if (items[i].getItem() != Items.NO_ITEM) {

                items[i].setItem(Items.NO_ITEM);
            }
            nitems = 0;
        }
    }

    /**
     * Usato per trovare lo slot vuoto piu' vicino
     * @return l'indice dello slot vuoto
     */
    public int findFreeslot()
    {

        for(int i=0;i<capacity;i++)
        {
            if(items[i].getItem() == Items.NO_ITEM)
            {
                return i;
            }
        }
        return 1;
    }

    public int getNitems() {
        return nitems;
    }
    public boolean IsFull()
    {
        return nitems == capacity;
    }
    public abstract void update(Vector2f mouseP);

    public abstract void render(RenderTarget target);

    public int getIndex_selected() {
        return index_selected;
    }
    public int getItemIDbyIndex(int index)
    {
        if(items[index] != null) {
            return items[index].getItem().getId();
        }
        return -1;
    }

    public void setIndex_selected(int index_selected) {
        this.index_selected = index_selected;
    }
    public boolean isEmptySlot(int index)
    {
        if(items[index] == null)
        {
            return true;
        }
        return false;
    }

    /**
     * Ritorna l'oggetto contenuto in un slot dall'inidce.
     * @param index l'indice
     * @return l'oggetto
     */
    public Item getItembySlot(int index)
    {

        return items[index].getItem().asItem();
    }
}
