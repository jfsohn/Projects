package edu.indiana.cs.c212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An instance of this class is the Controller for a Calculator. It manages the
 * Model, which holds the data used by the Calculator, and the View, which
 * displays the controls and the data. It also specifies how the user is to
 * interact with the View.
 * 
 * In a simple 4-function Calculator, requests to do a calculation are specified
 * to the Calculator by sequences like:
 * 
 * operand1 operator operand2 =
 * 
 * where 'operand1' and 'operand2' are positive whole numbers with no decimal
 * points or exponents, and 'operator' is one of: '+', '-', 'x', or '/'. The
 * spaces are not present in the input; the user indicates them to the
 * Calculator via changes in input. For example, switching from digits to an
 * operator implicitly tells the Calculator that an operand has ended, *and* it
 * tells the Calculator what the operator is, *and* it tells the Calculator to
 * expect a digit, which will start another operand. So the Calculator will keep
 * computing through any sequence of 'operand' followed by 'operator', as long
 * as the user keeps alternating them until the user presses '='. For instance,
 * '4 + 3 - 5 / 2 =' will produce output '1'. Only two consecutive operators is
 * an error.
 * 
 * The Calculator is managed by its Controller, which is its brain. The
 * Controller controls both the Calculator's Model (which holds the Calculator's
 * data) and the Calculator's View (which displays the Calculator controls and
 * its output to the user).
 * 
 * The Controller keeps track of its own state via two variables, the boolean
 * isExpectingTheFirstDigitOfAnOperand and the String previousOperator. (Note:
 * If the Controller is *not* expecting the first digit of an operand, then it
 * *must* be expecting an operator, which can only be one of the 4 above, or
 * '='. So there's no need for a separate boolean for that condition. Early
 * calculators were designed this way to cut down on the logic gates needed to
 * build them, so they could be designed easily and built cheaply.)
 * 
 * The Controller has two main branch cases (ignoring digit ingestion cases, its
 * clear memory and display case, and its error case):
 * 
 * 1/ If the Controller is currently expecting an operator, and the
 * previousOperator is '=', then the Controller must have just ingested the last
 * digit of the first number of a calculation request (that is, the Controller
 * just ingested all of operand1).
 * 
 * So the Controller then asks the Model to store that number in its memory for
 * later use.
 * 
 * 2/ If the Controller is currently expecting an operator, and the
 * previousOperator isn't '=', then the previousOperator must be the operator
 * that the Calculator must use to do the requested calculation. Also, the
 * number that the Controller just ingested the last digit of must be the second
 * number of that requested calculation (that is, the Controller just ingested
 * all of operand2).
 * 
 * So the Controller then asks the Model to do the requested calculation:
 * <whatever is in the Model's memory> operator operand2
 * 
 * After either case (1) or case (2), the Controller then asks the Model to
 * fetch its memory, then the Controller asks the View to display that.
 * 
 * In geek-speak, this is an example of a simple finite-state automaton (or
 * finite-state machine).
 */
public class CalculatorController {
	private CalculatorModel model;
	private CalculatorView view;

	private String previousOperator;
	private boolean isExpectingTheFirstDigitOfAnOperand;

	public CalculatorController(CalculatorModel model) {
		this.model = model;

		ActionListener clearButtonListener = new ClearButtonListener();
		ActionListener digitButtonListener = new DigitButtonListener();
		ActionListener operatorButtonListener = new OperatorButtonListener();

		view = new CalculatorView(digitButtonListener, operatorButtonListener,
				clearButtonListener);

		reset();
	}

	public CalculatorView getView() {
		return view;
	}

	private class ClearButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent actionEvent) {
			reset();
		}
	}

	private class DigitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent actionEvent) {
			String digit = actionEvent.getActionCommand();

			if (isExpectingTheFirstDigitOfAnOperand) {
				// user just entered a digit,
				// and the controller was expecting it,
				// so this is the first digit of an operand

				isExpectingTheFirstDigitOfAnOperand = false;
				view.setDisplay(digit);
			} else {
				// user just entered a digit,
				// and the controller was expecting either:
				// an operator or another digit,
				// so keep ingesting digits until an operator is seen

				view.setDisplay(view.getDisplay() + digit);
			}

			view.setHistory(view.getHistory() + digit);
		}
	}

	private class OperatorButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent actionEvent) {
			String operator = actionEvent.getActionCommand();

			String history = view.getHistory();
			if (operator.equals("="))
				history += " ";
			else
				history += operator;
			view.setHistory(history);

			if (!isExpectingTheFirstDigitOfAnOperand) {
				// user just entered an operator,
				// and the controller was expecting either:
				// an operator or another digit,
				// so do what the previousOperator specified

				isExpectingTheFirstDigitOfAnOperand = true;

				String operand = view.getDisplay();
				updateModel(operand);

				previousOperator = operator;
				view.setDisplay(model.getMemory());
			} else {
				// user just entered an operator,
				// but the controller was expecting a digit

				reset();
				view.setDisplay("Error - expected a digit");
			}
		}
		/* updateModel takes a String and checks to see what the previous 
		 * operator was.  Depending on what that operator was, updateModel calls
		 * the appropriate method on the operand.
		 * 
		 * In MVC style code the Controller class (C) will interact with other
		 * classes, namely the Model class (M) and the View class (V).  
		 */
		private void updateModel(String operand) {
			//FIXME
		}
	}

	private void reset() {
		previousOperator = "=";
		isExpectingTheFirstDigitOfAnOperand = true;
		model.setMemory("0");
		view.setDisplay("0");
		view.setHistory("");
	}
}
