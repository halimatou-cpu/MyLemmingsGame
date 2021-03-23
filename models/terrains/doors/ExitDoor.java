package models.terrains.doors;

import config.Config;
import models.Lemming;
import models.ModelContainer;
import models.Position;
import models.terrains.Obstacle;

import java.awt.*;

public class ExitDoor extends Obstacle {

	@Override
	public void action(Lemming lemming, ModelContainer container) {

		container.setArrived(container.getArrived() + 1);
		lemming.setActive(false);

	}

	@Override
	public boolean isDestructible() {
		return false;
	}

	@Override
	public void print(Graphics graphics, Position position) {
		graphics.setColor(Color.GREEN);
		graphics.fillRect(position.getX() * Config.SCALE, position.getY() * Config.SCALE, Config.SCALE, Config.SCALE);
	}
}
