package net.gabriele.clashofcraft.client.gui.screen;

import org.jsfml.graphics.*;
import org.jsfml.system.Vector2i;

public class InfoWindow extends Window{
    Text title = new Text();
    Texture texture = new Texture();
    Sprite sprite = new Sprite();
    Text descri = new Text();
    public InfoWindow(int sizex, int sizey, String title, Texture image,String DescriptionText) {
        super(sizex, sizey);
        this.texture = image;
        this.title.setString(title);
        descri.setString(DescriptionText);
        descri.setCharacterSize(12);
        this.title.setCharacterSize(12);
        descri.setPosition(window.getPosition().x - window.getSize().x / 2,window.getPosition().y + 40);
        this.title.setOrigin(this.title.getGlobalBounds().width / 2,this.title.getGlobalBounds().height / 2);
        this.title.setPosition(window.getOrigin().x,window.getOrigin().y - window.getSize().y + this.title.getGlobalBounds().height / 2 );
        sprite.setTexture(texture);
        sprite.setPosition(window.getGlobalBounds().left,window.getGlobalBounds().height + 20);
        descri.setColor(Color.BLACK);
        this.title.setColor(Color.BLACK);
    }

    @Override
    public void render(RenderTarget target) {
        super.render(target);
        target.draw(sprite);
        target.draw(this.title);
        target.draw(this.descri);
    }

    @Override
    public void update(Vector2i mouse) {
        super.update(mouse);
    }
}
