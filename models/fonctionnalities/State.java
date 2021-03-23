package models.fonctionnalities;

import models.Lemming;
import models.ModelContainer;

public interface State {
	
	void action(Lemming lemming, ModelContainer container);
}
