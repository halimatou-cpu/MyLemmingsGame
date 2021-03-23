package models.fonctionnalities;

import config.Config;
import models.Lemming;
import models.ModelContainer;

public class BlockerState implements State {

	@Override
	public void action(Lemming lemming, ModelContainer container) {
		Lemming lem;
		for (int count = 0; count < Config.LEMMINGS_NUMBER; count++) {
			lem = container.getLemmings().get(count);
			if (lem.isActive() && count != container.getLemmings().indexOf(lemming)
					&& lem.getPosition().getY() == lemming.getPosition().getY()) {

				if (lemming.getPosition().getX() == lem.getPosition().getX() + Config.SCALE
						|| lemming.getPosition().getX() == lem.getPosition().getX() - Config.SCALE)
					lem.switchDirection();
			}
		}
	}

	public boolean isBlocker() {
		return true;
	}

}
