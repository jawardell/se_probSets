import java.util.*;
import java.io.*;

public class Rand {
	public static void main(String[] args) throws Exception {
	  	File file = new File("output.csv");
		PrintWriter pw = new PrintWriter(file);
		String res = "";
		for(int i = 0; i < 21; i++) {
			for(int j = 0; j < 7; j++) {
				if(j == 6) {
			  		res += String.format("%f,\n", (int)(Math.random() * 4 + 4) + q());
				} else {
			  		res += String.format("%f,", (int)(Math.random() * 4 + 4) + q());
				}
			}
		}
		pw.write(res);
		pw.close();
	}

	public static double q() {
	  	double[] qu = {.25, .5, .75};
		return qu[(int)(Math.random()*3)];
	}
}
