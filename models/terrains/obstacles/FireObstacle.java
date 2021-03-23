package models.terrains.obstacles;

import config.Config;
import models.Lemming;
import models.ModelContainer;
import models.Position;
import models.terrains.Obstacle;

import java.awt.*;

public class FireObstacle extends Obstacle {

    @Override
    public void action(Lemming lemming, ModelContainer container) {
        lemming.setActive(false);
    }

    @Override
    public boolean isDestructible() {
        
        return false;
    }


    @Override
    public void print(Graphics graphics, Position position) {
        graphics.setColor(Color.RED);
        graphics.fillRect(position.getX() * Config.SCALE, position.getY() * Config.SCALE, Config.SCALE, Config.SCALE);
    }
}
