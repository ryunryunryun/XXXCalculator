
import java.util.*;
import java.lang.Math;

public class RPoland {
	private String[] stringArray;
	Deque<Double> que = new ArrayDeque<>();
	
	public RPoland (String equation) {
		stringArray = equation.split("\\s");
	}
	
	public String doCalculation () {
		String output = "";
		double a = 0;
		double b = 0;
		double c = 0;
		int count = 0;
		
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray.length == 1) {
				try {
					output = ((Double)(Double.parseDouble(stringArray[0]))).toString();
				}
				catch (Exception e) {
					output = "ERROR not number";
				}
				break;
			}
			
			try {				
				switch (stringArray[i]) {
				// addition
				case "+":
					a = que.pollFirst();
					b = que.pollFirst();
					que.addFirst(b + a);
					break;
					
				// subtraction
				case "-":
					a = que.pollFirst();
					b = que.pollFirst();
					que.addFirst(b - a);
					break;
					
				// multiplication	
				case "*":
					a = que.pollFirst();
					b = que.pollFirst();
					que.addFirst(b * a);
					break;
					
				// division	
				case "/":
					a = que.pollFirst();
					b = que.pollFirst();
					que.addFirst(b / a);
					break;	
				
				// modulo
				case "%":
					a = que.pollFirst();
					b = que.pollFirst();
					que.addFirst(b % a);
					break;
					
				// absolute value
				case "abs":
					a = que.pollFirst();
					que.addFirst(Math.abs(a));
					break;
				
				// arc cosine
				case "acos":
					a = que.pollFirst();
					que.addFirst(Math.acos(a));
					break;
					
				// arc sine
				case "asin":
					a = que.pollFirst();
					que.addFirst(Math.asin(a));
					break;
				
				// arc tan
				case "atan":
					a = que.pollFirst();
					que.addFirst(Math.atan(a));
					break;
				
				// power
				case "^":
					a = que.pollFirst();
					b = que.pollFirst();
					que.addFirst(Math.pow(b, a));
					break;
					
				// square root
				case "sqrt":
					a = que.pollFirst();
					que.addFirst(Math.sqrt(a));
					break;
					
				// cubic root
				case "cbrt":
					a = que.pollFirst();
					que.addFirst(Math.cbrt(a));
					break;
					
				// square
				case "sq":
					a = que.pollFirst();
					que.addFirst(Math.pow(a, 2));
					break;
					
				// cube
				case "cb":
					a = que.pollFirst();
					que.addFirst(Math.pow(a, 3));
					break;
					
				// cos
				case "cos":
					a = que.pollFirst();
					que.addFirst(Math.cos(a));
					break;
					
				// sin
				case "sin":
					a = que.pollFirst();
					que.addFirst(Math.sin(a));
					break;
					
				// tan
				case "tan":
					a = que.pollFirst();
					que.addFirst(Math.tan(a));
					break;
					
				// sec
				case "sec":
					a = que.pollFirst();
					que.addFirst(1 / Math.cos(a));
					break;
					
				// csc
				case "csc":
					a = que.pollFirst();
					que.addFirst(1 / Math.sin(a));
					break;
					
				// cot
				case "cot":
					a = que.pollFirst();
					que.addFirst(1 / Math.tan(a));
					break;
					
				// inverse
				case "inv":
					a = que.pollFirst();
					que.addFirst(1 / a);
					break;
					
				// cosh
				case "cosh":
					a = que.pollFirst();
					que.addFirst(Math.cosh(a));
					break;
					
				// sinh
				case "sinh":
					a = que.pollFirst();
					que.addFirst(Math.sinh(a));
					break;
					
				// tanh
				case "tanh":
					a = que.pollFirst();
					que.addFirst(Math.tanh(a));
					break;
				
				// sech
				case "sech":
					a = que.pollFirst();
					que.addFirst(1 / Math.cosh(a));
					break;
					
				// cosech
				case "csch":
					a = que.pollFirst();
					que.addFirst(1 / Math.sinh(a));
					break;
					
				// coth
				case "coth":
					a = que.pollFirst();
					que.addFirst(1 / Math.tanh(a));
					break;
					
				// arccosh
				// arcsinh
				// arctanh
				// ln
				case "ln":
					a = que.pollFirst();
					que.addFirst(Math.log(a));
					break;
					
				// log
				case "log":
					a = que.pollFirst();
					que.addFirst(Math.log10(a));
					break;
					
				// max
				case "max":
					a = que.pollFirst();
					b = que.pollFirst();
					que.addFirst(Math.max(a, b));
					break;
					
				// min
				case "min":
					a = que.pollFirst();
					b = que.pollFirst();
					que.addFirst(Math.min(a, b));
					break;
					
				// random
				case "rand":
					a = que.pollFirst();
					b = que.pollFirst();
					que.addFirst((Math.max(a, b) - Math.min(a, b)) * Math.random() + Math.min(a, b));
					break;
					
				// gauss
				case "gauss":
					a = que.pollFirst();
					que.addFirst(Math.floor(a));
					break;
					
				// floor
				case "floor":
					a = que.pollFirst();
					que.addFirst(Math.floor(a));
					break;
					
				// ceil
				case "ceil":
					a = que.pollFirst();
					que.addFirst(Math.ceil(a));
					break;
					
				// exp
				case "exp":
					a = que.pollFirst();
					que.addFirst(Math.exp(a));
					break;
					
				// factorial
				case "!":
					a = que.pollFirst();
					b = 1;
					count = 0;
					if (a < 0 || (a - Math.floor(a)) > 0) {
						return "ERROR not factorial";
					}
					
					for (int j = 1; j <= a; j++) {
						count ++;
						if (count > 1000) {
							return "ERROR";
						}
						b *= j;
					}
					
					que.addFirst(b);
					break;
					
				// permutation
				case "P":
					a = que.pollFirst();
					b = que.pollFirst();
					c = 1;
					count = 0;
					
					if (a < 0 || (a - Math.floor(a)) > 0 || b < 0 || (b - Math.floor(b)) > 0 || a > b) {
						return "ERROR not perm";
					} 
					
					for (int j = (int)b; j > b - a; j--) {
						count ++;
						if (count > 1000) {
							return "ERROR";
						}
						c *= j;
					}
					
					que.addFirst(c);
					break;
					
				// combination
				case "C":
					a = que.pollFirst();
					b = que.pollFirst();
					c = 1;
					count = 0;
					
					if (a < 0 || (a - Math.floor(a)) > 0 || b < 0 || (b - Math.floor(b)) > 0 || a > b) {
						return "ERROR not perm";
					} 
					
					for (int j = (int)b; j > b - a; j--) {
						count ++;
						if (count > 1000) {
							return "ERROR";
						}
						c *= j;
					}
					
					for (int j = 1; j <= a; j++) {
						count ++;
						if (count > 1000) {
							return "ERROR";
						}
						c /= j;
					}
					
					que.addFirst(c);
					break;
					
				// e
				case "e":
					que.addFirst(Math.E);
					break;
					
				// π
				case "pi":
					que.addFirst(Math.PI);
					break;
					
				// zeta
				case "zeta":
					if (stringArray.length != 2) {
						return "ERROR zeta";
					}
					else if (i != 1) {
						return "ERROR zeta";
					}
					return "zeta " + stringArray[0];
					
				// tetration
				case "tetra":
					a = que.pollFirst();
					b = que.pollFirst();
					c = b;
					count = 0;
					
					// whole number check
					if (a < 0 || a - Math.floor(a) > 0) {
						return "ERROR tetra";
					}
					
					for (int j = 0; j < a - 1; j++) {
						count ++;
						if (count > 1000) {
							return "ERROR";
						}
						c = Math.pow(c, b);
					}
					
					que.addFirst(c);
					break;
					
				// dice 6d2 = 6 * d2
				case "d":
					Random rand = new Random();
					a = que.pollFirst();
					b = que.pollFirst();
					c = 0;
					count = 0;
					
					if (a < 0 || (a - Math.floor(a)) > 0 || b < 0 || (b - Math.floor(b)) > 0) {
						return "ERROR not dice";
					}
					
					for (int j = 0; j < b; j++) {
						count ++;
						if (count > 1000) {
							return "ERROR";
						}
						c += (rand.nextInt((int)a) + 1);
					}
					
					que.addFirst(c);
					break;
				
				
				default:
					que.addFirst(Double.parseDouble(stringArray[i]));
				}
				
				if (i == stringArray.length - 1) {
					output = que.pop().toString();
				}
			}
			catch (Exception e) {
				output = "ERROR " + e;
				break;
			}
		}
		
		if (!que.isEmpty()) {
			output = "ERROR not empty";
		}
		
		
		return output;
	}
	
	/*
	public static void main (String[] args) {
		RPoland rp = new RPoland ("2 2 tetra 100 * zeta");
		
		System.out.println(rp.doCalculation());
	}
	*/
}
