package models;

import config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

public class ModelContainer {
    private static ModelContainer instance;

    private final Plan plan;
    private final List<Lemming> lemmings;
//    private int alive = Config.LEMMINGS_NUMBER;
    private int dead = 0;
    private int arrived = 0;

    private ModelContainer() {
        this.plan = new Plan();
        this.lemmings = new ArrayList<>();
        Position position;
        for (int count = 0; count < Config.LEMMINGS_NUMBER; count++) {
            position = new Position(count + 3, 3);
            lemmings.add(new Lemming(position, count % 2 == 0 ? Direction.RIGHT : Direction.LEFT));
        }
    }

    public Plan getPlan() {
        return plan;
    }

    public List<Lemming> getLemmings() {
        return lemmings;
    }


    public static ModelContainer getInstance() {
        if (instance == null) {
            instance = new ModelContainer();
        }
        return instance;
    }

    public Lemming findLemmingAt(int x, int y) {

        BiPredicate<Integer, Integer> predicate = (value, pos) -> value >= pos - 2 && value <= pos + 2;

        Optional<Lemming> result = getLemmings().stream()
                .filter(Lemming::isActive)
                .filter(lemming -> {
                    Position position = lemming.getPosition();
                    return predicate.test(x, position.getX()) && predicate.test(y, position.getY());
                }).findFirst();

        return result.orElse(null);
    }

	public void setArrived(int arrived) {
		this.arrived = arrived;
	}

	public int getDead() {
		return dead;
	}

	public void setDead(int dead) {
		this.dead = dead;
	}

	public int getArrived() {
		return arrived;
	}
}
