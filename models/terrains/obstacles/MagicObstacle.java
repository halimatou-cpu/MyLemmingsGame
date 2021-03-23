package models.terrains.obstacles;

import config.Config;
import models.Lemming;
import models.ModelContainer;
import models.Position;
import models.fonctionnalities.BomberState;
import models.terrains.Obstacle;

import java.awt.*;
import java.util.Random;

public class MagicObstacle extends Obstacle {

	@Override
	public void action(Lemming lemming, ModelContainer container) {
		Position position = obstaclePositionGenerator(lemming, container);
		container.getPlan().getCase(position.getX(), position.getY()).setObstacle(new SimpleDestructibleObstacle());
		lemming.setActive(false);
	}
	
	

	private Position obstaclePositionGenerator(Lemming lemming, ModelContainer container) {
		Random random = new Random();

		int x = -1;
		int y = -1;
		while (!container.getPlan().validCase(x, y) || container.getPlan().getCase(x, y).isNotEmpty()) {
			x = 0 + random.nextInt(Config.CASE_WIDTH);
			y = 0 + random.nextInt(Config.CASE_HEIGHT);
		}
		return new Position(x,y);
		
	}



	@Override
	public boolean isDestructible() {
		return true;
	}

	@Override
	public void print(Graphics graphics, Position position) {
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(position.getX() * Config.SCALE, position.getY() * Config.SCALE, Config.SCALE, Config.SCALE);
	}
}
