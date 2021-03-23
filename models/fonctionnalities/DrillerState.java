package models.fonctionnalities;

import models.Lemming;
import models.ModelContainer;
import models.terrains.Case;

public class DrillerState implements State {

    @Override
    public void action(Lemming lemming, ModelContainer container) {

        int direction = lemming.hasDirectionLeft() ? -1 : 1;

        Case aCase = container.getPlan().getCase(
                lemming.getPosition().getX() + direction,
                lemming.getPosition().getY()
        );

        if (aCase != null) {
            if (aCase.isNotEmpty() && aCase.getObstacle().isDestructible()) {
                aCase.getObstacle().action(lemming, container);
                aCase.setObstacle(null);
            }

            lemming.getPosition().setX(lemming.getPosition().getY() + direction);

            if (aCase.isEmpty()) {
                lemming.setState(new WalkerState());
            }
        }
    }
}
