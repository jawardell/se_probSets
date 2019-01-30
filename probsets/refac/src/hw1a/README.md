# Refac 


<a href="https://github.com/jawardell/se_probSets">Back to Repo Root</a>


The purpose of this assignment was to refactor a method in `./Test.java`. The method exhibited the long method bad-smell. Moreover, the method is 
a bloater type of bad smell which means that the method has accumulated too much 
code over time. Bloaters can be addressed by identifying groups of code that could 
be removed from the large method and placed into a new sub-method, variable, or 
logical expression. 

See `hw_refac.pdf` for the problem statement.


Original Method:

```java
/*	 This method is explained in the homework assignment.*/
	public void assess() {
		// If size of expected and actual output are not the same then throw exception
		if(expectedOutput.size()!=actualOutput.size()) {
			throw new RuntimeException("expectedOutput and actualOutput not the same size");
		}
		// Initialize instance variables.
		isCorrect = new ArrayList<>();
		numCorrect = 0;
		numTotal = 0;
		// Loop over expected output
		for(String exp : expectedOutput) {
			// If code signifies a double is present. If a string has a double it will look like one 
			// of these, for example:
			//   "%d 8.834 %tp 1.0 The average num rebounds is=8.834"
			//   "%d 8.834 %ta 0.01 The average num rebounds is=8.834"
			if(exp.substring(0, 2).equals("%d")) {
				// Split the expected output into tokens
				String[] tokensExp = exp.split(" ");
				// Get the double to be evaluated.
				double valExp = Double.parseDouble(tokensExp[1]);
				// Get the tolerance type ("%tp"=percent tolerance method, 
				//   "%ta"= absolute tolerance method"
				String tolType = tokensExp[2];
				// Get the tolerance value
				double tol = Double.parseDouble(tokensExp[3]);
				double errorMax=0.0;
				// Set the maximum error
				if(tolType.equals("%tp")) {
					errorMax = valExp * tol/100.0;
				}
				else if(tolType.equals("%ta")) {
					errorMax = tol;
				}
				// Split the corresponding actual output and break into tokens
				String[] tokensAct = actualOutput.get(numTotal++).split(" ");
				// Get the actual double result.
				double valAct = Double.parseDouble(tokensAct[1]);
				// Calculate actual error, the difference between expected and actual results
				double errorAct = Math.abs(valExp-valAct);
				// If actual error is less than maximum error 
				if(errorAct<=errorMax) {
					// Problem is correct.
					numCorrect++;
					isCorrect.add(true);
				}
				else {
					// Problem is incorrect
					isCorrect.add(false);
				}
			}
			// If expected output is a string 
			else {
				// Get the actual output and compare to expected.
				if(exp.equals(actualOutput.get(numTotal++))) {
					// Problem is correct
					numCorrect++;
					isCorrect.add(true);
				}
				else {
					// Problem is incorrect
					isCorrect.add(false);
				}
			}
		}
		// Calculate the points earned over all results.
		pointsEarned = (double)numCorrect/numTotal * pointsMax;
	}
```

refactored method: 

```java
	public void assess() {

		detectListInitializationErrors();

		assessStudentOutput();

		assignPoints();

	}

```

<a href="https://github.com/jawardell/se_probSets">Back to Repo Root</a>
