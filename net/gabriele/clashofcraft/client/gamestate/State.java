package net.gabriele.clashofcraft.client.gamestate;

import org.jsfml.graphics.RenderTarget;

public abstract class State {
    protected boolean quit = false;
    public void update()
    {

    }
    public void render(RenderTarget target)
    {

    }
    public boolean isQuit()
    {
        return quit;
    }
}
