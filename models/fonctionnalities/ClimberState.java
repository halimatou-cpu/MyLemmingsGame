package models.fonctionnalities;

import models.Lemming;
import models.ModelContainer;
import models.Position;
import models.terrains.Case;

public class ClimberState implements State {
    private boolean started;
    private int direction;


    @Override
    public void action(Lemming lemming, ModelContainer container) {
        if (!this.started) {
            this.started = true;
            this.direction = lemming.getDirection().isLeft() ? -1 : 1;
        }

        Position position = new Position(
                lemming.getPosition().getX() + direction,
                lemming.getPosition().getY()
        );

        Case aCase = container.getPlan().getCase(position.getX(), position.getY());

        if (aCase.isNotEmpty()) position.setY(position.getX() + 1);
        else lemming.getPosition().update(position.getX(), position.getY());
    }

}
