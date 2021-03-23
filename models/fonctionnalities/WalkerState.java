package models.fonctionnalities;

import models.Lemming;
import models.ModelContainer;
import models.Position;

public class WalkerState implements State {
	private int counter = 0;

	@Override
	public void action(Lemming lemming, ModelContainer container) {
		Position position = lemming.getPosition();

		if (!container.getPlan().isOnSupport(lemming)) {
			position.setY(position.getY() + 1);

			if (counter++ > 3)
				lemming.setActive(false);

			return;
		}

		this.walk(lemming, container);
	}

	public void walk(Lemming lemming, ModelContainer container) {
		Position position = lemming.getPosition();
		Position casePosition = new Position(position.getX(), position.getY());

		if (position.getX() <= 0 || position.getY() >= container.getPlan().getCases()[0].length
				|| container.getPlan().nextCaseOf(casePosition) == null)
			lemming.switchDirection();

		int seed = (lemming.hasDirectionLeft() ? -1 : 1);

		if (container.getPlan().nextCaseOf(casePosition) == null)
			;

		else if (container.getPlan().nextCaseOf(casePosition).isEmpty()) {
			position.setX(lemming.getPosition().getX() + seed);

			this.counter = 0;
		} else {
			container.getPlan().moveUp(position);
			position.setX(lemming.getPosition().getX() + seed);
			this.counter = 0;
		}
	}
}
