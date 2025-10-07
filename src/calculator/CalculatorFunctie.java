package calculator;

public class CalculatorFunctie {
	
	public double adunare(double a, double b) {
		return a + b;
	}
	
	public double scadere(double a, double b) {
		return a - b;
	}
	
	public double inmultire(double a, double b) {
		return a * b;
	}
	
	public double impartire(double a, double b) {
		if (b == 0) throw new ArithmeticException("Impartire la zero");
		return a / b;
	}
	
}
