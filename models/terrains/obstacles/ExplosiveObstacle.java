package models.terrains.obstacles;

import config.Config;
import models.Lemming;
import models.ModelContainer;
import models.Position;
import models.terrains.Obstacle;

import java.awt.*;

public class ExplosiveObstacle extends Obstacle {

	@Override
	public void action(Lemming lemming, ModelContainer container) {
		Position position = lemming.getPosition();
		lemming.setActive(false);
		container.getPlan().putObstacle(null, position);
	}

	@Override
	public boolean isDestructible() {
		return true;
	}

	@Override
	public void print(Graphics graphics, Position position) {
		graphics.setColor(Color.PINK);
		graphics.fillRect(position.getX() * Config.SCALE, position.getY() * Config.SCALE, Config.SCALE, Config.SCALE);
	}
}
