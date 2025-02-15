package net.gabriele.clashofcraft.client.gui;

import net.gabriele.clashofcraft.client.buildings.Mine;
import net.gabriele.clashofcraft.client.gamestate.LandMain;
import net.gabriele.clashofcraft.client.gui.screen.InfoWindow;
import net.gabriele.clashofcraft.client.gui.screen.MineScreen;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Hotbar {
    ArrayList<ImageButton> buttons = new ArrayList<>();
    ArrayList<ProgressBarElement> progress = new ArrayList<>();
    HashMap<String, Texture> textures = new HashMap<>();
    public Hotbar()
    {
        initTextures();
        buttons.add(new ImageButton(0,640,80,80,textures.get("info")
        ){
            @Override
            public void update(Vector2i moupos) {
                if(sprite.getGlobalBounds().contains(new Vector2f(moupos)))
                {
                    if(Mouse.isButtonPressed(Mouse.Button.LEFT))
                    {
                        if(LandMain.CURRENT_BUILDING_SELECTION != -1)
                        {
                            InfoWindow window = new InfoWindow(600,300,getATitle(LandMain.CURRENT_BUILDING_SELECTION),getTex(LandMain.CURRENT_BUILDING_SELECTION),getDesc(LandMain.CURRENT_BUILDING_SELECTION));
                            LandMain.windows.add(window);
                        }
                    }
                }
            }
            private Texture getTex(int ID)
            {
                switch(ID)
                {
                    case 0:
                        return LandMain.buildings.get(0).getTexture();
                    case 1:
                        return LandMain.buildings.get(1).getTexture();
                    case 2:
                        return LandMain.buildings.get(2).getTexture();
                }
                return null;
            }
            private String getATitle(int ID)
            {
                switch(ID)
                {
                    case 0:
                        return "Town Hall";
                    case 1:
                    case 2:
                        return "House";
                }
                return null;
            }
            private String getDesc(int ID)
            {
                switch(ID)
                {
                    case 0:
                        return "TOWN_HALL_DESC";
                    case 1:
                    case 2:
                        return "HOUSE_DESC";
                }
                return null;
            }
        });
        buttons.add(new ImageButton(80,640,80,80,textures.get("mine")){
            @Override
            public void update(Vector2i mousepos) {
                if(sprite.getGlobalBounds().contains(new Vector2f(mousepos)))
                {
                    if(Mouse.isButtonPressed(Mouse.Button.LEFT))
                    {
                        if(LandMain.buildings.get(3) instanceof Mine _mine)
                        {
                            _mine.showInventory();
                        }
                    }
                }
            }
        });
        buttons.add(new ImageButton(1200,640,80,80,textures.get("map")));
        progress.add(new ProgressBarElement(120, Color.WHITE, Color.BLACK,20,1150,10));
        progress.add(new ProgressBarElement(120, Color.WHITE, Color.YELLOW,20,1150,40));
        progress.add(new ProgressBarElement(120, Color.WHITE, Color.BLUE,20,1150,70));
    }
    public void update(Vector2i mousepos)
    {
            progress.get(0).setPercent(LandMain.STONE,20);
            progress.get(1).setPercent(LandMain.WOOD,20);
            progress.get(2).setPercent(LandMain.IRON,20);
            for(ProgressBarElement p : progress)
            {
                p.update();
            }
            for(ImageButton imgbutton : buttons)
            {
                imgbutton.update(mousepos);
            }
    }
    public void render(RenderTarget target)
    {
        for(ImageButton button : buttons)
        {
            button.render(target);
        }
        for(ProgressBarElement progress_bar : progress)
        {
            progress_bar.render(target);
        }
    }
    private void initTextures()
    {
        Texture temp_info = new Texture();
        try {
            temp_info.loadFromFile(Paths.get("Assets/graphics/ui/button_info.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        textures.put("info", temp_info);
        Texture temp_map = new Texture();
        try {
            temp_map.loadFromFile(Paths.get("Assets/graphics/ui/map.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        textures.put("map",temp_map);
        Texture mine_button = new Texture();
        try {
            mine_button.loadFromFile(Paths.get("Assets/graphics/ui/button_mine.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        textures.put("mine",mine_button);
    }
}
