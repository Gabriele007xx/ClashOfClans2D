package net.gabriele.clashofcraft.client.gui;

import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;

public class Button {
    private RectangleShape shape = new RectangleShape();
    private Font font = new Font();
    private Text text = new Text();
    private Color text_idl_color;
    private Color text_act_color;
    private Color text_hov_color;
    private Color idl_c;
    private Color hov_c;
    private Color acti_c;
    protected ButtonState state;
    public Button()
    {

    }
    public Button(float x, float y,float width, float height, String text,Font font,Color idlec, Color hovc, Color actc,Color textac, Color texthc, Color textidc, int charS)
    {
        this.shape.setPosition(new Vector2f(x,y));
        this.shape.setSize(new Vector2f(width,height));
        this.font = font;
        this.text.setFont(font);
        this.text.setString(text);
        this.text.setColor(textidc);
        this.text.setCharacterSize(charS);
        this.text.setPosition(this.shape.getPosition().x + (this.shape.getGlobalBounds().width / 2.0f) -this.text.getGlobalBounds().width/2.0f,this.shape.getPosition().y + (this.shape.getGlobalBounds().height / 2.0f) -this.text.getGlobalBounds().height/2.0f);
        this.idl_c = idlec;
        this.hov_c = hovc;
        this.acti_c = actc;
        this.text_act_color = textac;
        this.text_hov_color = texthc;
        this.text_idl_color = textidc;
        this.shape.setFillColor(this.idl_c);
        this.state = ButtonState.IDLE;
    }
    public void render(RenderTarget target)
    {
        target.draw(shape);
        target.draw(text);
    }
    public void update(Vector2f mousepos)
    {
        this.state = ButtonState.IDLE;
        if(this.shape.getGlobalBounds().contains(mousepos))
        {
            this.state = ButtonState.HOVER;
            if(Mouse.isButtonPressed(Mouse.Button.LEFT))
            {
                this.state = ButtonState.PRESSED;
            }
        }
        switch(state)
        {
            case IDLE:
                this.shape.setFillColor(idl_c);
                this.text.setColor(text_idl_color);
                break;
            case HOVER:
                this.shape.setFillColor(hov_c);
                this.text.setColor(text_hov_color);
                break;
            case PRESSED:
                this.shape.setFillColor(acti_c);
                this.text.setColor(text_act_color);
                break;
            default:
                this.shape.setFillColor(Color.RED);
                this.text.setColor(Color.WHITE);
                break;
        }
    }
    public boolean isPressed()
    {
        return state == ButtonState.PRESSED;
    }
}

