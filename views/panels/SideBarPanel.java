package views.panels;

import config.Config;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class SideBarPanel extends AbstractPanel {
    List<JButton> buttons;


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.RED);
        graphics.fillRect(Config.MAIN_COMPONENT_WIDTH + 1, 0, Config.MENU_WIDTH, Config.MENU_HEIGHT);
    }
}
