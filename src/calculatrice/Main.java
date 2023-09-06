package calculatrice;

import calculatrice.controller.CalculatorController;
import calculatrice.model.CalculatorModel;
import calculatrice.view.CalculatorView;

public class Main {
	public static void main(String[] args) {
		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView();
		new CalculatorController(model, view);
	}
}
