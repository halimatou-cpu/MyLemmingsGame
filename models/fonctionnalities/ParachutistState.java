package models.fonctionnalities;

import models.Lemming;
import models.ModelContainer;
import models.terrains.Case;

public class ParachutistState implements State {
    private int counter = 0;

    @Override
    public void action(Lemming lemming, ModelContainer container) {
        if (counter++ % 2 == 0) return;

        Case aCase = container.getPlan().getCase(
                lemming.getPosition().getX(),
                lemming.getPosition().getY() + 1
        );

        if (aCase != null) {
            if (aCase.isNotEmpty()) lemming.setState(new WalkerState());
            else lemming.getPosition().setY(lemming.getPosition().getY() + 1);
        }
    }
}
