package views.panels;

import config.Config;
import models.Lemming;
import models.ModelContainer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMouseListener implements MouseListener {

    private final GamePanel gamePanel;

    public GameMouseListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Lemming lemming = ModelContainer.getInstance().findLemmingAt(mouseEvent.getX() / Config.SCALE, mouseEvent.getY() / Config.SCALE);
        if (lemming != null) {
            this.gamePanel.setCurrentLemming(lemming);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
