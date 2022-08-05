package net.gabriele.clashofcraft.client;

import net.gabriele.clashofcraft.client.gamestate.LandMain;
import net.gabriele.clashofcraft.client.gamestate.State;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Stack;

public class Coc {
    private RenderWindow window;
    private Vector2i mouseX_Y;
    private String title = "Clash";
    public Stack<State> states = new Stack<>();
    public static HashMap<String, Texture> itemtextures = new HashMap<>();
    public static HashMap<String, Texture> buildingtextures = new HashMap<>();
    public Coc()
    {
        init();
        states.add(new LandMain());
    }
    public void init()
    {
        initItemTextures();
        initBuildingTextures();
        initWindow();
    }
    private void initWindow() {
        window = new RenderWindow(new VideoMode(1280,720),title);
    }
    public boolean RunningNow()
    {
        return window.isOpen();
    }
    public void update()
    {
        mouseX_Y = Mouse.getPosition(window);
        for(Event event : window.pollEvents())
        {
            switch(event.type)
            {
                case CLOSED:
                    window.close();
                    break;
            }
        }
        states.lastElement().update(mouseX_Y);
    }
     public void updatedt()
     {

     }
    public void render()
    {
        window.clear();
        states.lastElement().render(window);
        window.display();
    }
    private void initItemTextures()
    {
        Texture cobb = new Texture();
        try {
            cobb.loadFromFile(Paths.get("Assets/graphics/items/cobblestone.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        itemtextures.put("cobblestone",cobb);
    }
    private void initBuildingTextures()
    {
        Texture thlv1 = new Texture();
        try {
            thlv1.loadFromFile(Paths.get("Assets/graphics/buildings/distict_hall.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buildingtextures.put("t_hall",thlv1);
        Texture house0 = new Texture();
        try {
            house0.loadFromFile(Paths.get("Assets/graphics/buildings/home.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buildingtextures.put("house0", house0);
        Texture house1 = new Texture();
        try {
            house1.loadFromFile(Paths.get("Assets/graphics/buildings/home2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buildingtextures.put("house1", house1);
    }
}
