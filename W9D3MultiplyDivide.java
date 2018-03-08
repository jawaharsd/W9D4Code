import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class W9D3MultiplyDivide {
	
	public static void main(String args []) {
		System.out.println("Program designed by Jawahar");
		System.out.println("");
		System.out.println("");
		Scanner keyboard = new Scanner(System.in);        // Initialized scanner class
		System.out.println("Enter the 1 st measured value");
		double Measured1 = keyboard.nextDouble();           // reading first measured value from input.
		System.out.println("Enter the 1 st Error value");
		double Error1 = keyboard.nextDouble();              // reading first Error value from input.
		System.out.println("Enter the 2 nd measured value");
		double Measured2 = keyboard.nextDouble();           // reading second measured value.
		System.out.println("Enter the 2 nd Error value");
		double Error2 = keyboard.nextDouble();              // reading second error value.
		System.out.println("");
		System.out.println("");
		keyboard.close(); 
		
		System.out.println("");
		System.out.println("");
		
		// code  for product
		System.out.println("product");
		System.out.println("");
		double Value1ErrorFraction = Error1/Math.abs(Measured1);
		double Value2ErrorFraction = Error2/Math.abs(Measured2);
		double product = Math.abs(Measured1*Measured2);
		double MpyErrorTerm = (Value1ErrorFraction+Value2ErrorFraction)*(Math.abs(product));
		System.out.print("Before rounding off the term:      ");
		System.out.println(product +" ± " + MpyErrorTerm );
		System.out.print("After rounding off the term:      ");
		System.out.println(getSignificant(product,8)+" ± " + getSignificant(MpyErrorTerm,1));
		System.out.println("");
		System.out.println("");
		// code for division
		
		System.out.println("Quotient");
		System.out.println("");
		double Quotient = Measured1/Measured2;
		double DivErrorTerm = (Value1ErrorFraction+Value2ErrorFraction)*(Math.abs(Quotient));
		System.out.print("Before rounding off the term:      ");
		System.out.println(Math.abs(Quotient)+" ± " + DivErrorTerm );
		System.out.print("After rounding off the term:      ");
		System.out.println(getSignificant(Quotient,8)+" ± " + getSignificant( DivErrorTerm,1));
		
		
	}
    // significant method
	public static String getSignificant(double value, int sigFigs) {
		MathContext mc = new MathContext(sigFigs, RoundingMode.DOWN);
		BigDecimal bigDecimal = new BigDecimal(value, mc);
		return bigDecimal.toPlainString();
	}

}
