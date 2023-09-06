package calculatrice.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calculatrice.model.Operation;

public class CalculatorView {
	private JFrame frame;
	private JTextField operand1Field;
	private JTextField operand2Field;
	private JComboBox<Operation> operatorComboBox;
	private JButton calculateButton;
	private JButton clearButton;
	private JLabel resultLabel;

	public CalculatorView() {
		frame = new JFrame("Calculatrice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);

		operand1Field = new JTextField(10);
		operand2Field = new JTextField(10);
		operatorComboBox = new JComboBox<>(Operation.values());
		calculateButton = new JButton("Calculer");
		clearButton = new JButton("Effacer");
		resultLabel = new JLabel("Résultat :");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		panel.add(new JLabel("Operand 1:"));
		panel.add(operand1Field);
		panel.add(new JLabel("Operand 2:"));
		panel.add(operand2Field);
		panel.add(new JLabel("Opérateur:"));
		panel.add(operatorComboBox);
		panel.add(calculateButton);
		panel.add(clearButton);

		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.add(resultLabel, BorderLayout.SOUTH);
		frame.setVisible(true);
	}

	public double getOperand1() {
		return Double.parseDouble(operand1Field.getText());
	}

	public double getOperand2() {
		return Double.parseDouble(operand2Field.getText());
	}

	public Operation getSelectedOperator() {
		return (Operation) operatorComboBox.getSelectedItem();
	}

	public void setResult(double result) {
		resultLabel.setText("Résultat : " + result);
	}

	public void addCalculateListener(ActionListener listener) {
		calculateButton.addActionListener(listener);
	}

	public void addClearListener(ActionListener listener) {
		clearButton.addActionListener(listener);
	}

	public void clearInputs() {
		operand1Field.setText("");
		operand2Field.setText("");
		operatorComboBox.setSelectedItem(null);
		resultLabel.setText("Résultat :");
	}

	public void displayErrorMessage(String message) {
		JOptionPane.showMessageDialog(frame, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
}
