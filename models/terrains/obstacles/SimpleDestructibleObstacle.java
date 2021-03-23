package models.terrains.obstacles;

import config.Config;
import models.Lemming;
import models.ModelContainer;
import models.Position;
import models.terrains.Obstacle;

import java.awt.*;

public class SimpleDestructibleObstacle extends Obstacle {

	@Override
	public void action(Lemming lemming, ModelContainer container) {
		container.getPlan().getCase(lemming.getPosition().getX(), lemming.getPosition().getY()).setObstacle(null);
	}

	@Override
	public boolean isDestructible() {
		return true;
	}

	@Override
	public void print(Graphics graphics, Position position) {
		graphics.setColor(Color.CYAN);
		graphics.fillRect(position.getX() * Config.SCALE, position.getY() * Config.SCALE, Config.SCALE, Config.SCALE);
	}
}
