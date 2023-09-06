package calculatrice.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculatrice.model.CalculatorModel;
import calculatrice.model.Operation;
import calculatrice.view.CalculatorView;

public class CalculatorController {
	private CalculatorModel model;
	private CalculatorView view;

	public CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;

		// Ajoutez des écouteurs aux boutons de la vue
		this.view.addCalculateListener(new CalculateListener());
		this.view.addClearListener(new ClearListener());
	}

	class CalculateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				double operand1 = view.getOperand1();
				double operand2 = view.getOperand2();
				Operation operator = view.getSelectedOperator();

				model.setOperand1(operand1);
				model.setOperand2(operand2);
				model.setCurrentOperation(operator);
				model.performOperation();

				double result = model.getResult();
				view.setResult(result);
			} catch (NumberFormatException ex) {
				// Gérer les erreurs de conversion ou d'autres erreurs ici
				view.displayErrorMessage("Entrée non valide");
			}
		}
	}

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.clear();
			view.clearInputs();
		}
	}
}
