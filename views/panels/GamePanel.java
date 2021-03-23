package views.panels;

import config.Config;
import models.Lemming;
import models.ModelContainer;
import models.Position;
import models.fonctionnalities.BlockerState;
import models.fonctionnalities.BomberState;
import models.fonctionnalities.CarpenterState;
import models.fonctionnalities.ClimberState;
import models.fonctionnalities.DiggerState;
import models.fonctionnalities.DrillerState;
import models.fonctionnalities.ParachutistState;
import models.fonctionnalities.State;
import models.fonctionnalities.WalkerState;
import models.terrains.Case;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GamePanel extends AbstractPanel {
	private State state;
	private final ModelContainer container;

	String marcheur = "MARCHEUR";
	String bloqueur = "BLOQUEUR";
	String tunnelier = "TUNNELIER";
	String foreur = "FOREUR";
	String bombeur = "BOMBEUR";
	String charpentier = "CHARPENTIER";
	String grimpeur = "GRIMPEUR";
	String parachutiste = "PARACHUTISTE";

	public GamePanel() {
		super();
		this.container = ModelContainer.getInstance();
		this.createButtons();
		this.addMouseListener(new GameMouseListener(this));
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(0, 0, Config.MAIN_COMPONENT_WIDTH, Config.MAIN_COMPONENT_HEIGHT);

		this.printCases(graphics);
		this.printLemmings(graphics);
	}

	private void printCases(Graphics graphics) {
		Case[][] cases = this.container.getPlan().getCases();
		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[x].length; y++) {
				cases[x][y].print(graphics, new Position(y, x));
			}
		}
	}

	private void printLemmings(Graphics graphics) {
		this.container.getLemmings().stream().filter(Lemming::isActive)
				.forEach(lemming -> lemming.print(graphics, lemming.getPosition()));
	}

	private void createButtons() {

		this.add(this.createButton(marcheur, 1));
		this.add(this.createButton(bloqueur, 2));
		this.add(this.createButton(tunnelier, 3));
		this.add(this.createButton(foreur, 4));
		this.add(this.createButton(bombeur, 5));
		this.add(this.createButton(charpentier, 6));
		this.add(this.createButton(grimpeur, 7));
		this.add(this.createButton(parachutiste, 8));
		this.add(this.createButton(("Score: "+container.getArrived()+""), 9));
	}

	private JButton createButton(String text, final int index) {
		JButton button = new JButton(text);
		final int height = 50;

		button.setLocation(Config.MAIN_COMPONENT_WIDTH, height * (index - 1));
		button.setSize(Config.MENU_WIDTH, height);
		button.setFont(new Font(Font.DIALOG, Font.PLAIN | Font.BOLD, 10));
		button.setFocusPainted(false);

		button.addActionListener(actionEvent -> {
			if (index == 1)
				state = new WalkerState();
			if (index == 2)
				state = new BlockerState();
			if (index == 3)
				state = new DiggerState();
			if (index == 4)
				state = new DrillerState();
			if (index == 5)
				state = new BomberState();
			if (index == 6)
				state = new CarpenterState();
			if (index == 7)
				state = new ClimberState();
			if (index == 8)
				state = new ParachutistState();
		});

		return button;
	}

	public void setCurrentLemming(Lemming lemming) {
		if (this.state != null) {
			lemming.setState(this.state);
			this.state = null;
		}
	}
	
}
