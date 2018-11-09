package hw1a;

import java.util.ArrayList;
import java.util.List;

public class Test {
	int testNum;
	String description;
	double pointsMax;
	double pointsEarned;
	int numCorrect;
	int numTotal;
	List<Integer> incorrectParts = new ArrayList<>();
	List<String> expectedOutput = new ArrayList<>();
	List<String> actualOutput = new ArrayList<>();
	List<Boolean> isCorrect = new ArrayList<>();
	boolean hasRunTimeError = false;

	public Test(int testNum) {
		this.testNum = testNum;
	}

	public Test() {
		// Initialize instance variables.
		isCorrect = new ArrayList<>();
		numCorrect = 0;
		numTotal = 0;

		testNum = 0;

	}

	public void addActualOutput(ArrayList<String> results) {
		this.description = results.remove(0);
		this.pointsMax = Double.parseDouble(results.remove(0));
		this.actualOutput.addAll(results);
	}

	/*
	 * This method is explained in the homework assignment.
	 */
	public void assess() {

		detectListInitializationErrors();

		assessStudentOutput();

		assignPoints();

	}

	private void assessStudentOutput() {
		for (String exp : expectedOutput) {

			boolean outputIsNumerical = analyzeOutput(exp);

			boolean outputIsString = !outputIsNumerical;

			if (outputIsNumerical)
				doNumericalAssesment(exp);

			if (outputIsString)
				doStringAssesment(exp);

		}
	}

	private boolean analyzeOutput(String exp) {
		return exp.substring(0, 2).equals("%d");
	}

	private void assignPoints() {
		// Calculate the points earned over all results.
		pointsEarned = (double) numCorrect / numTotal * pointsMax;
	}

	private void doNumericalAssesment(String exp) {

		double maxiumumError = parseMaxiumumError(exp);

		double actualError = parseActualError(exp, maxiumumError);

		determineIfCorrect(maxiumumError, actualError);

	}

	private void determineIfCorrect(double maxiumumError, double actualError) {
		if (actualError <= maxiumumError) {
			giveFullCredit();
		} else {
			giveNoCredit();
		}
	}

	private double parseActualError(String exp, double maximumError) {
		double actualError;

		// Split the corresponding actual output and break into tokens
		String[] tokensAct = actualOutput.get(numTotal++).split(" ");

		// Get the actual double result.
		double valAct = Double.parseDouble(tokensAct[1]);

		// Calculate actual error, the difference between expected and actual results
		actualError = Math.abs(maximumError - valAct);

		return actualError;
	}

	private double parseMaxiumumError(String exp) {
		double maxiumumError;
		// Split the expected output into tokens
		String[] tokensExp = exp.split(" ");
		// Get the double to be evaluated.
		double valExp = Double.parseDouble(tokensExp[1]);
		// Get the tolerance type ("%tp"=percent tolerance method,
		// "%ta"= absolute tolerance method"
		String tolType = tokensExp[2];
		// Get the tolerance value
		double tol = Double.parseDouble(tokensExp[3]);
		maxiumumError = 0.0;
		// Set the maximum error
		if (tolType.equals("%tp")) {
			maxiumumError = valExp * tol / 100.0;
		} else if (tolType.equals("%ta")) {
			maxiumumError = tol;
		}
		return maxiumumError;
	}

	private void doStringAssesment(String exp) {
		// Get the actual output and compare to expected.
		boolean actualMatchesExpected = exp.equals(actualOutput.get(numTotal++));

		boolean actualDoesntMatchExpected = !actualMatchesExpected;

		if (actualMatchesExpected) {
			giveFullCredit();
		}

		if (actualDoesntMatchExpected) {
			giveNoCredit();
		}
	}

	private void giveNoCredit() {
		// Problem is incorrect
		isCorrect.add(false);
	}

	private void giveFullCredit() {
		// Problem is correct
		numCorrect++;
		isCorrect.add(true);
	}

	private void detectListInitializationErrors() {
		// If size of expected and actual output are not the same then throw exception
		if (expectedOutput.size() != actualOutput.size()) {
			throw new RuntimeException("expectedOutput and actualOutput not the same size");
		}
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("%s\n", this.description));

		for (int i = 0; i < expectedOutput.size(); i++) {
			String correct = "Correct";
			if (!isCorrect.get(i))
				correct = "Incorrect";
			String exp = expectedOutput.get(i);
			String act = actualOutput.get(i);
			if (analyzeOutput(exp)) {
				// Find 4th space

				String[] tokensExp = exp.split(" ");
				double valueExp;
				try {
					valueExp = Double.parseDouble(tokensExp[1]);
				} catch (Exception e) {
					// Not the best choice. Could fail in the (remote) case where the
					// expected value is within the max error of Double.MAX_VALUE.
					// Not sure how to fix right now.
					valueExp = Double.MAX_VALUE;
				}
				// double valueExp = getDouble(exp);

				tokensExp = act.split(" ");
				double valueAct;
				try {
					valueAct = Double.parseDouble(tokensExp[1]);
				} catch (Exception e) {
					// Not the best choice. Could fail in the (remote) case where the
					// expected value is within the max error of Double.MAX_VALUE.
					// Not sure how to fix right now.
					valueAct = Double.MAX_VALUE;
				}
				// double valueAct = getDouble(act);
				double errorAct = Math.abs(valueExp - valueAct);

				// double errorAct = getActError(exp,act);

				tokensExp = exp.split(" ");
				double value = Double.parseDouble(tokensExp[1]);
				String tolType = tokensExp[2];
				double tol = Double.parseDouble(tokensExp[3]);
				double errorMax = 0.0;
				if (tolType.equals("%tp")) {
					errorMax = value * tol / 100.0;
				} else if (tolType.equals("%ta")) {
					errorMax = tol;
				}
				// return errorMax;
				//
				//
				// double errorMax = getMaxError(exp);

				// Get location of spaces surrounding double.
				int pos1 = exp.indexOf(" ");
				int pos2 = exp.indexOf(" ", pos1 + 1);
				// Get location of space after %t markup
				int pos3 = exp.indexOf(" ", pos2 + 1);
				// Get location of space after tolerance
				int pos4 = exp.indexOf(" ", pos3 + 1);
				// Return remainder of string
				exp = exp.substring(pos4 + 1);

				// Get location of spaces surrounding double.
				pos1 = act.indexOf(" ");
				pos2 = act.indexOf(" ", pos1 + 1);
				// Get location of space after %t markup
				pos3 = act.indexOf(" ", pos2 + 1);
				// Get location of space after tolerance
				pos4 = act.indexOf(" ", pos3 + 1);
				// Return remainder of string
				act = act.substring(pos4 + 1);

				// exp = stripDouble(exp);
				// act = stripDouble(act);
				res.append(String.format("%s - Expected: %s | Actual: %s\n", correct, exp, act));
				String strAct = "Actual Error=" + errorAct;
				String strMax = "" + errorMax + "=Max Error";
				String strError = isCorrect.get(i) ? strAct + "<" + strMax : strAct + ">" + strMax;
				res.append(strError + "\n");
			} else {
				res.append(String.format("%s - Expected: %s | Actual: %s\n", correct, exp, act));
			}
			//
			// res.append(String.format("%s - Expected: %s | Actual: %s\n", correct, exp,
			// act));
		}

		res.append(String.format("Summary: %d out of %d answers correct : %.1f points out of %.1f\n", numCorrect,
				numTotal, pointsEarned, pointsMax));

		return res.toString();
	}
}
