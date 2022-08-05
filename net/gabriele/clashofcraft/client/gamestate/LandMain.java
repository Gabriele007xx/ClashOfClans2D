package net.gabriele.clashofcraft.client.gamestate;

import net.gabriele.clashofcraft.client.Coc;
import net.gabriele.clashofcraft.client.buildings.Building;
import net.gabriele.clashofcraft.client.buildings.townhall.TownHallBuilding;
import net.gabriele.clashofcraft.client.gui.Hotbar;
import net.gabriele.clashofcraft.client.land.World;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LandMain extends State{
    World world;
    Texture worldtextur = new Texture();
    Hotbar hotbar = new Hotbar();
    public static int STONE = 0;
    public static int WOOD = 0;
    public static int IRON = 0;
    public static int NUMBER_OF_BUILDERS = 2;
    public static int CURRENT_BUILDING_SELECTION = -1;
    public static ArrayList<Building> buildings = new ArrayList<>();
    public LandMain()
    {
        try {
            worldtextur.loadFromFile(Paths.get("Assets/graphics/world/world.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        world = new World(worldtextur);
        TownHallBuilding TOWN_HALL = new TownHallBuilding(Coc.buildingtextures.get("t_hall"),640,360);
        buildings.add(TOWN_HALL);
    }

    @Override
    public void update() {
        hotbar.update();
        for(Building b : buildings)
        {
            b.update();
        }
        world.update();
    }

    @Override
    public void render(RenderTarget target) {
        world.render(target);
        for(Building b : buildings)
        {
            b.render(target);
        }
        hotbar.render(target);
    }
}
