package calculatrice.model;

public class CalculatorModel {
	private double operand1;
	private double operand2;
	private double result;
	private Operation currentOperation;

	public CalculatorModel() {
		operand1 = 0;
		operand2 = 0;
		result = 0;
		currentOperation = null;
	}

	public void setOperand1(double operand1) {
		this.operand1 = operand1;
	}

	public void setOperand2(double operand2) {
		this.operand2 = operand2;
	}

	public void setCurrentOperation(Operation operation) {
		currentOperation = operation;
	}

	public void performOperation() {
		if (currentOperation != null) {
			switch (currentOperation) {
			case ADDITION:
				result = operand1 + operand2;
				break;
			case SUBTRACTION:
				result = operand1 - operand2;
				break;
			case MULTIPLICATION:
				result = operand1 * operand2;
				break;
			case DIVISION:
				if (operand2 != 0) {
					result = operand1 / operand2;
				} else {
					// Gérer la division par zéro si nécessaire
					result = Double.NaN;
				}
				break;
			}
		}
	}

	public double getResult() {
		return result;
	}

	public void clear() {
		operand1 = 0;
		operand2 = 0;
		result = 0;
		currentOperation = null;
	}
}
