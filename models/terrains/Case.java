package models.terrains;

import models.Position;
import views.Printable;

import java.awt.*;

public class Case implements Printable {
    private Obstacle obstacle;


    public boolean isEmpty() {
        return obstacle == null;
    }

    public boolean isNotEmpty() {
        return !this.isEmpty();
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    @Override
    public void print(Graphics graphics, Position position) {
        if (!this.isEmpty()) {
            this.getObstacle().print(graphics, position);
        }

    }
}
