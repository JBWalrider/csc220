package lab07;

import java.util.Stack;

public class Postfixer {
	public static double InfixEvaluator(String line) {
		StringSplitter data = new StringSplitter(line);
		Stack<String> operators = new Stack<String>();
		Stack<Double> operands = new Stack<Double>();    //double: decimal point doesn't count as a special character
		while (data.hasNext()) {
			String s = data.next();
			if (s.equals("(")) {operators.push(s);}
			else if (s.equals(")")) {
				while (!operators.peek().equals("(")) {
					double d1 = operands.pop();
					double d2 = operands.pop();
					String s1 = operators.pop();
					switch (s1) {
						case "+": {operands.push(d2+d1); break;}
						case "-": {operands.push(d2-d1); break;}
						case "*": {operands.push(d2*d1); break;}
						case "/": {operands.push(d2/d1); break;}
						case "^": {operands.push(Math.pow(d2, d1)); break;}
						default: {System.err.println("operator is not valid 1");System.exit(1);}
					}
				}
				operators.pop();
			}
			else if (data.SPECIAL_CHARACTER.contains(s)) {
				while (!operators.empty() && data.SPECIAL_CHARACTER.indexOf(operators.peek()) >= data.SPECIAL_CHARACTER.indexOf(s)) {
					double d1 = operands.pop();
					double d2 = operands.pop();
					String s1 = operators.pop();
					switch (s1) {
						case "+": {operands.push(d2+d1); break;}
						case "-": {operands.push(d2-d1); break;}
						case "*": {operands.push(d2*d1); break;}
						case "/": {operands.push(d2/d1); break;}
						case "^": {operands.push(Math.pow(d2, d1)); break;}
						default: {System.err.println("operator is not valid 2");System.exit(1);}
					}
				}
				operators.push(s);
			}
			else {operands.push(Double.parseDouble(s));}
		}
		while (!operators.empty()) {
			double d1 = operands.pop();
			double d2 = operands.pop();
			String s1 = operators.pop();
			switch (s1) {
				case "+": {operands.push(d2+d1); break;}
				case "-": {operands.push(d2-d1); break;}
				case "*": {operands.push(d2*d1); break;}
				case "/": {operands.push(d2/d1); break;}
				case "^": {operands.push(Math.pow(d2, d1)); break;}
				default: {System.err.println("operator is not valid 3");System.exit(1);}
			}
		}
		if (!operators.empty()) {System.err.println("operators is not empty at end");System.exit(1);}
		return operands.pop();
	}
	public static String PostfixConvertor(String line) {
		StringSplitter data = new StringSplitter(line);
		Stack<String> operators = new Stack<String>();
		String r = "";
		while (data.hasNext()) {
			String s = data.next();
			if (s.equals("(")) {operators.push(s);}
			else if (s.equals(")")) {
				while (!operators.peek().equals("(")) {
					r += operators.pop();
				}
				operators.pop();
			}
			else if (data.SPECIAL_CHARACTER.contains(s)) {
				while (!operators.peek().equals("(") && data.SPECIAL_CHARACTER.indexOf(operators.peek()) > data.SPECIAL_CHARACTER.indexOf(s)) {
					r += operators.pop();
				}
				operators.push(s);
			}
			else {r += s;}
		}
		return r;
	}
	public static void main(String[]a) {
		/*
        if (InfixEvaluator("10 + 2") != 12)
            System.err.println("test1 failed --> your answer should have been 12");
        
        if (InfixEvaluator("10 - 2") != 8)
            System.err.println("test1 failed --> your answer should have been 12");
        
        if (InfixEvaluator("100 * 2 + 12") != 212)
            System.err.println("test2 failed --> your answer should have been 212");
        
        if (InfixEvaluator("100 * ( 2 + 12 )") != 1400)
            System.err.println("test3 failed --> your answer should have been 1400");
        
        if (InfixEvaluator("100 * ( 2 + 12 ) / 14") != 100)
            System.err.println("test4 failed --> your answer should have been 100");
        
        System.out.println("Testing Done!!!");
		*/
        
        if (!PostfixConvertor(new String("(4+5)")).equals("45+"))
            System.err.println("test1 failed --> should have been 45+");
        
        if (!PostfixConvertor(new String("((4+5)*6)")).equals("45+6*"))
            System.err.println("test2 failed --> should have been 45+6*");
        
        if (!PostfixConvertor(new String("((4+((5*6)/7))-8)")).equals("456*7/+8-"))
            System.err.println("test3 failed --> should have been 456*7/+8-");
        
        if (!PostfixConvertor(new String("((4+5*(6-7))/8)")).equals("4567-*+8/"))
            System.err.println("test4 failed --> should have been 4567-*+8/");
        
        if (!PostfixConvertor(new String("(9+(8*7-(6/5^4)*3)*2)")).equals("987*654^/3*-2*+"))
            System.err.println("test5 failed --> should have been 987*654^/3*-2*+");
        
        System.out.println("Testing Done!!!");

	}
}
