import config.Config;
import controllers.GameController;
import views.Window;

public class App {
	public static void main(String[] args) {
		Window window = new Window();

		GameController controller = new GameController(window);

		while (controller.alive()) {
			try {
				Thread.sleep(Config.GAME_REFRESH);
			} catch (Exception ignore) {
			}

			controller.step();
		}

		System.exit(0);
	}
}
