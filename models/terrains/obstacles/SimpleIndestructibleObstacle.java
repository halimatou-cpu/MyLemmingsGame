package models.terrains.obstacles;

import config.Config;
import models.Lemming;
import models.ModelContainer;
import models.Position;
import models.terrains.Obstacle;

import java.awt.*;

public class SimpleIndestructibleObstacle extends Obstacle {

	@Override
	public void action(Lemming lemming, ModelContainer container) {

	}

	@Override
	public boolean isDestructible() {
		return false;
	}

	@Override
	public void print(Graphics graphics, Position position) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(position.getX() * Config.SCALE, position.getY() * Config.SCALE, Config.SCALE, Config.SCALE);
	}
}
