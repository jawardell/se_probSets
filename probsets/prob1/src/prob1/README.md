# Problem 1

The purpose of the problem was to derive test cases using the Category Partion Method. 
We derived test cases for a system of OO java classes modeling the following entities:
#### Employee
	* **hours**: int[]
	* **name**: String
	* **payrate**: double
	* **getPayRate**
	* **getName**
	* **Employee**
	* **getHours**
	* **setHours**
	* **getNumDaysWorked**
	* **getPay**
	* **getTotalHours**
	* **getWeekdayHours**
	* **mergeEmployee**
	* **newWeek**
	* **getWeekendHours**
	* **toString**
#### Store
	* **emps**: Employee[]
	* **numEmps**: int
	* **Store**
	* **getNumEmps**
	* **getEmp**
	* **addEmp**
	* **removeEmployee**
	* **getTotalHours**
	* **getTotalPay**
	* **toString**

Follow along in the `hw_t2.pdf` document to observe our derivation process. 
After deriving the test cases, we wrote a TSL code to generate the possible 
test cases given our constraints. Upon generation of the TSL tesk cases, we 
implemented unit tests in JUnit to test our program. 

To run this program: 

* install and configure the <a href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">jdk</a>
 and the <a href="https://www.java.com/en/download/windows-64bit.jsp">jre</a>.</br>
* <a href="https://junit.org/junit4/faq.html/#started_1">install and configure junit</a></br>
* clone this repo and move into this project's directory: 
```shell
git clone https://github.com/jawardell/se_ProbSets/
cd se_ProbSets/probsets/prob1/src/prob1
``` 
* build and execute the `AddEmployeeTest.java` program
```shell
javac AddEmployeeTest.java
java AddEmployeeTest
```
If you are using the terminal, you will need to be sure to configure your build path 
to be compatible with JUnit. 

<a href="https://github.com/jawardell/se_ProbSets">Back to Repo Root</a>



