package models;

import config.Config;
import models.terrains.Case;
import models.terrains.Obstacle;
import models.terrains.doors.EntryDoor;
import models.terrains.doors.ExitDoor;
import models.terrains.obstacles.*;

public class Plan {
	private Case[][] cases;

	public Plan() {

		int[][] map = Config.MAP;

		int height = map.length;
		int width = map[0].length;

		this.cases = new Case[height][width];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				cases[y][x] = new Case();

				if (map[y][x] == 1)
					cases[y][x].setObstacle(new EntryDoor());

				if (map[y][x] == 2)
					cases[y][x].setObstacle(new ExitDoor());

				if (map[y][x] == 3)
					cases[y][x].setObstacle(new SimpleDestructibleObstacle());
				if (map[y][x] == 4)
					cases[y][x].setObstacle(new SimpleIndestructibleObstacle());

				if (map[y][x] == 5)
					cases[y][x].setObstacle(new FireObstacle());
				if (map[y][x] == 6)
					cases[y][x].setObstacle(new MagicObstacle());
				if (map[y][x] == 7)
					cases[y][x].setObstacle(new TeleporterObstacle());
				if (map[y][x] == 8)
					cases[y][x].setObstacle(new ExplosiveObstacle());

			}
		}
	}

	public Case[][] getCases() {
		return cases;
	}

	public Case getCase(int x, int y) {
		if (x >= 0 && x < cases.length && y >= 0 && y < cases[0].length) {
			return cases[x][y];
		}
		return null;
	}

	public void moveLeft(Position position) {
		int value = Math.max(0, position.getX() - 1);
		position.setX(value);
	}

	public void moveRight(Position position) {
		int value = Math.min(cases.length, position.getX() + 1);
		position.setX(value);
	}

	public void moveUp(Position position) {
		int value = Math.max(0, position.getY() - 1);
		position.setY(value);
	}

	public void moveDown(Position position) {
		int value = Math.min(cases[0].length, position.getY() + 1);
		position.setX(value);
	}

	public void putObstacle(Obstacle obstacle, Position position) {
		Case aCase = this.getCase(position.getX(), position.getY());
		if (aCase != null && aCase.isEmpty()) {
			aCase.setObstacle(obstacle);
		}
	}

	public boolean isOnSupport(Lemming lemming) {

		Case aCase = this.getCase(lemming.getPosition().getY() + 1, lemming.getPosition().getX());
		return aCase != null && aCase.isNotEmpty();
	}

	public boolean canMove(Lemming lemming) {
		return true;
	}

	public void moveLemming(Lemming lemming) {
		if (lemming.isActive() && isOnSupport(lemming)) {
			if (lemming.hasDirectionLeft() && canMove(lemming))
				moveLeft(lemming.getPosition());
			else
				moveRight(lemming.getPosition());
		}
	}

	public Case nextCaseOf(Position position) {
		if (validCase(position.getY(), position.getX() + 1))
			return this.cases[position.getY()][position.getX() + 1];
		else
			return null;

	}

	public boolean isWall(Position position) {
		if (!validCase(position.getX(), position.getY()))
			return true;
		return (getCase(position.getX(), position.getY()).isNotEmpty()
				&& getCase(position.getX(), position.getY() - 1).isNotEmpty());

	}

	public boolean validCase(int x, int y) {
		return x >= 0 && x < cases.length && y >= 0 && y < cases[0].length;
	}
}
