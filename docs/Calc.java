import java.io.*;
import java.util.*;

public class Calc {
	public static void main(String[] args) throws Exception {
		File file = new File("output.csv");
		File calc = new File("calc.csv");
		PrintWriter pw = new PrintWriter(calc);
		Scanner s = new Scanner(file);
		double[][] totals = new double[21][1];
		int i = 0;
		while(s.hasNext()) {
			String[] o = s.nextLine().split(",");
			double[] a = {Double.parseDouble(o[1]),
			  Double.parseDouble(o[1]),Double.parseDouble(o[1]),
			  Double.parseDouble(o[1]),Double.parseDouble(o[1]),
			  Double.parseDouble(o[1]),Double.parseDouble(o[1]),
			  Double.parseDouble(o[1])};

			if((a[1] + a[2] + a[3] + a[4] + a[5]) > 40) {
				totals[i][0] += (a[1] + a[2] + a[3] + a[4] + a[5])*15.0 + (a[6] + a[7])*20.0;
			} else {
				totals[i][0] += (a[1] + a[2] + a[3] + a[4] + a[5])*10.0 + (a[6] + a[7])*20.0;
			}
			boolean bonus = (a[1] != 0) && (a[2] != 0) && (a[3] != 0) && (a[4] != 0) && (a[5] != 0);     
			if(bonus) {
				totals[i][0] += 50;
			}
			i += 1;
		}
		s.close();
		String res = "";
		for(i = 0; i < totals.length; i++) {
			res += String.format("$%.2f\n", totals[i][0]);
		}
		pw.write(res);
		pw.close();
	}
}
