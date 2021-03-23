package models.fonctionnalities;

import models.Lemming;
import models.ModelContainer;
import models.terrains.Case;
import models.terrains.Obstacle;

public class BomberState implements State {
    private int counter;

    public BomberState() {
        this.counter = 0;
    }

    @Override
    public void action(Lemming lemming, ModelContainer container) {
        if (counter < 2) {
            counter++;
            return;
        }

        this.lemmingsKiller(lemming, container);

        this.casesDestroyer(lemming, container);

        lemming.setActive(false);
    }

    private void casesDestroyer(Lemming lemming, ModelContainer container) {
        Case[][] cases = container.getPlan().getCases();
        int x = lemming.getPosition().getX() - 2;
        x = Math.max(x, 0);

        int y = lemming.getPosition().getY() - 2;
        y = Math.max(y, 0);

        for (int i = x; i < cases.length && i <= x + 2; i++) {
            for (int j = y; j < cases[i].length && j <= y + 2; j++) {
                Obstacle obstacle = cases[i][j].getObstacle();
                if (obstacle.isDestructible()) {
                    obstacle.action(lemming, container);
                    cases[i][j].setObstacle(null);
                }
            }
        }
    }


    public void lemmingsKiller(Lemming lemming, ModelContainer container) {
        container.getLemmings().stream()
                .filter(l -> l.isActive() &&
                        (Math.abs(l.getPosition().getX() - lemming.getPosition().getX()) <= 2 ||
                                Math.abs(l.getPosition().getY() - lemming.getPosition().getY()) <= 2)
                )
                .forEach(l -> l.setActive(false));

    }
}
