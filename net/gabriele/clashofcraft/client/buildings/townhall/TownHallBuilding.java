package net.gabriele.clashofcraft.client.buildings.townhall;

import net.gabriele.clashofcraft.client.buildings.Building;
import net.gabriele.clashofcraft.client.buildings.BuildingTypeEnum;
import org.jsfml.graphics.Texture;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

public class TownHallBuilding extends Building {
    HashMap<String,Texture> level_texture = new HashMap<>();
    public TownHallBuilding(Texture texture, int x, int y) {
        super(texture, x, y);
        this.MAX_LEVEL = 5;
    }

    @Override
    public BuildingTypeEnum getType() {
        return BuildingTypeEnum.TOWN_HALL;
    }

    /**
     * Ritorna l'ID dell'edificio. Piu' edifici possono avere lo stesso ID.
     * @return l'ID
     */
    @Override
    public int getID() {
        return 0;
    }

    /**
     * Cambia l'apparenza dell'edifico in base al livello.
     */
    @Override
    public void changeApparance() {
        switch (CURRENT_LEVEL)
        {
            case 1:
                sprite.setTexture(level_texture.get("0"));
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    @Override
    public void initTextures() {
        Texture lvl1 = new Texture();
        try {
            lvl1.loadFromFile(Paths.get("Assets/graphics/buildings/distict_hall.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        level_texture.put("0",lvl1);
    }
}
