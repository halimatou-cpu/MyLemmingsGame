package models.fonctionnalities;

import models.Lemming;
import models.ModelContainer;
import models.terrains.Case;

public class DiggerState implements State {

    @Override
    public void action(Lemming lemming, ModelContainer container) {
    	 Case aCase = container.getPlan().getCase(
                 lemming.getPosition().getX(),
                 lemming.getPosition().getY() + 1
         );

         if (aCase != null) {
             if (aCase.isNotEmpty() && aCase.getObstacle().isDestructible()) {
                 aCase.getObstacle().action(lemming, container);
                 aCase.setObstacle(null);
                 lemming.getPosition().setX(lemming.getPosition().getX() + 1);
             }
             
             
             if (aCase.isEmpty()) {

                 	lemming.setState(new WalkerState());

             }
         }
    }
}
