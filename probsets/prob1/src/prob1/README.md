# Problem 1

The purpose of the problem was to derive test cases using the Category Partion Method. 
We derived test cases for a system of OO java classes modeling the following entities:

<table>
<tr><th>Employee</th><th>Store</th></tr>
<tr><td>

|attribute   |data type   |
|---|---|
|hours              |int[]   |
|name               |String   |
|Employee           |Employee  |
|getPayRate         |double   |
|getName            |String   |
|getHours           |double   |
|setHours           |void   |
|getNumDaysWorked   |int   |
|getPay   |double   |
|getTotalHours   |double   |
|getWeekdayHours   |double   |
|mergeEmployee   |void   |
|newWeek   |void   |
|getWeekendHours   |double   |
|toString   |String   |

</td><td>

|attribute|data type|
|---|---|
|emps|Employee[]|
|numEmps|int|
|Store|Store|
|getNumEmps|int|
|getEmp|Employee|
|addEmp|void|
|removeEmployee|void|
|getTotalHours|double|
|getTotalPay|double|
|toString|String|

</td></tr> </table>



Follow along in `hw_t2.pdf` to observe our derivation process. 

After deriving the test cases, we wrote a TSL code to generate the possible 
test cases given our constraints. 

Upon generation of the TSL tesk cases, we 
implemented unit tests in JUnit to test our program. 

#### To run this program: 

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



