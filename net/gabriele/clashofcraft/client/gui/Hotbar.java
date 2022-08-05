package net.gabriele.clashofcraft.client.gui;

import net.gabriele.clashofcraft.client.gamestate.LandMain;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;

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
        buttons.add(new ImageButton(0,640,80,80,textures.get("info")));
        buttons.add(new ImageButton(1200,640,80,80,textures.get("map")));
        progress.add(new ProgressBarElement(120, Color.WHITE, Color.BLACK,20,1150,10));
        progress.add(new ProgressBarElement(120, Color.WHITE, Color.YELLOW,20,1150,40));
        progress.add(new ProgressBarElement(120, Color.WHITE, Color.BLUE,20,1150,70));
    }
    public void update()
    {
            progress.get(0).setPercent(LandMain.STONE,20);
            progress.get(1).setPercent(LandMain.WOOD,20);
            progress.get(2).setPercent(LandMain.IRON,20);
            for(ProgressBarElement p : progress)
            {
                p.update();
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
    }
}
