package views;

import models.Position;

import java.awt.*;

public interface Printable {
    void print(Graphics graphics, Position position);
}
