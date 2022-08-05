package net.gabriele.clashofcraft.client.gui;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;

public class ProgressBarElement {
    private int MAX_LEGHT_PIXEL;
    private int current_pixel;
    private RectangleShape bg = new RectangleShape();
    private RectangleShape shape = new RectangleShape();
    public ProgressBarElement(int max_leght, Color background_color, Color color, int height, float x, float y)
    {
        MAX_LEGHT_PIXEL = max_leght;
        current_pixel = max_leght;
        bg.setFillColor(background_color);
        shape.setFillColor(color);
        bg.setSize(new Vector2f(max_leght,height));
        shape.setSize(new Vector2f(current_pixel, height));
        bg.setPosition(x,y);
        shape.setPosition(x,y);

    }
    public void update()
    {
        shape.setSize(new Vector2f(current_pixel, shape.getSize().y));
    }
    public void render(RenderTarget target)
    {
            target.draw(bg);
            target.draw(shape);
    }

    /**
     * Imposta la percentuale della barra.
     * @param number il numero attuale delle risorse
     * @param number_max il numero amssimo delle risorse
     */
    public void setPercent(int number, int number_max)
    {
        this.current_pixel = MAX_LEGHT_PIXEL*number/number_max;
    }
}
