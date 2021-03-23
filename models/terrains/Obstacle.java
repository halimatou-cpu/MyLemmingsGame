package models.terrains;

import config.Config;
import models.Lemming;
import models.ModelContainer;
import models.Position;
import views.Printable;

import java.awt.*;

public abstract class Obstacle implements Printable {

    public abstract void action(Lemming lemming, ModelContainer container);

    public abstract boolean isDestructible();

    @Override
    public void print(Graphics graphics, Position position) {
        graphics.setColor(Color.RED);
        graphics.fillRect(position.getX() * Config.SCALE, position.getY() * Config.SCALE, Config.SCALE, Config.SCALE);
    }
}
