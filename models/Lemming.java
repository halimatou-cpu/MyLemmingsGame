package models;

import config.Config;
import models.fonctionnalities.State;
import models.fonctionnalities.WalkerState;
import views.Printable;

import java.awt.*;

public class Lemming implements Printable {
    private Position position;
    private Direction direction;
    private boolean isActive;
    private State state;

    public Lemming(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
        this.isActive = true;
        this.state = new WalkerState();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean hasDirectionLeft() {
        return this.direction.isLeft();
    }

    public boolean hasDirectionRight() {
        return this.direction.isRight();
    }

    public void switchDirection() {
        if (hasDirectionRight()) setDirection(Direction.LEFT);
        else setDirection(Direction.RIGHT);
    }


    @Override
    public void print(Graphics graphics, Position position) {

        graphics.setColor(Color.ORANGE);
        graphics.fillOval(position.getX() * Config.SCALE, position.getY() * Config.SCALE, Config.SCALE, Config.SCALE);

        graphics.setColor(Color.DARK_GRAY);

        if (this.getDirection() == Direction.RIGHT) {
            graphics.drawLine(
                    (position.getX() * Config.SCALE + Config.SCALE / 2),
                    (position.getY() * Config.SCALE + Config.SCALE / 2),
                    (position.getX() * Config.SCALE + Config.SCALE - 2),
                    (position.getY() * Config.SCALE + Config.SCALE / 2)
            );
        } else {
            graphics.drawLine(
                    position.getX() * Config.SCALE,
                    (position.getY() * Config.SCALE + Config.SCALE / 2),
                    (position.getX() * Config.SCALE + Config.SCALE / 2),
                    (position.getY() * Config.SCALE + Config.SCALE / 2)
            );
        }
    }

    @Override
    public String toString() {
        return "Lemming{" +
                "position= (" + position.getX() +", " + position.getY() +
                ") , direction=" + direction +
                ", isActive=" + isActive +
                ", state=" + state +
                '}';
    }
}
