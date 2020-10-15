import java.util.*;
public class ExprEvaluator{
	Scanner kb =  new Scanner(System.in);
	private static Stack<Character> A = new Stack<Character>();
	private static Stack<Double> B = new Stack<Double>(); 
	private String e;
	private int p;
	
	public ExprEvaluator(){
		System.out.println("Enter an expression. A negative number should have a minus sign followed immediately by a digit or a decimal point,\nnegative numbers should also usually be surrounded by parentheses: ");;
		e = kb.nextLine(); 
		p = 0;   
	}	 
	public ExprEvaluator(String ee){
	    e = ee;
	    p = 0;  
	}
	public String getExpression(){
		return e;
	}
	private static void eval(){
		char op = A.pop(); 
		double opnd1 = B.pop(); 
		double opnd2 = B.pop();
		double val = 0.0;
		switch (op) {
		case '+':
			val = opnd2 + opnd1;
			break;
		case '-':
			val = opnd2 - opnd1; 
			break;
		case '*':
			val = opnd2 * opnd1;
			break;
		case '/':
			val = opnd2/opnd1;
			break;
		case '^': 
			val = Math.pow(opnd2, opnd1);
			break;
		}
		B.push(val); 
	  }  
	private static void evalDown(){
		do {
			eval();
		}while((A.size()>0) && (A.peek()!= '('));
		if((A.size()>0) && (A.peek()== '(')){
			A.pop();
		}
	}
	private static boolean prec(char token, Stack<Character> StackA){
		char topOp = StackA.peek();
		if((token == '*') || (token == '/') || (token == '^')){
			return true; 
		}
		else{
			if((topOp == '*') || (topOp == '/') || (topOp == '^') || topOp == '-' || topOp == '+') {
				return false; 
			}
		}
		return true; 
	}
	private double formNum(){
		double total = 0.0;
	    int count = 0;
	    int flag = 0;
	    double mult = 1.0;
	    char c,d;
	    do{
	    	c = e.charAt(p);
	    	if(c == '.'){
	    		flag = 1; 
	    	}
	    	else{
	    		if((c >= '0') && (c<= '9')){
	    			total = total * mult;
	    			total = total + (c-'0');
	    			mult = 10.0;
	    			if(flag == 1){
	    				count++; 
	    			}
	    		}
	    		else {
	    			if(c == '-') {
	    				A.pop();
	    			}
	    		}
	    	}
	    	p++; 
	    	d = '?';
	    	if(p < e.length()) {
	    		d = e.charAt(p); 
	    	}
	    }while((p < e.length()) && ( ((d<='9')&&(d>='0')) || (d == '.') || d == ' '));
	    if(flag==1){
	    	total = total/Math.pow(10.0,count*1.0);                                       
	    }
	    return total;
	}
	public double evaluator() {
		char token; 
		do {   
			token = e.charAt(p);
			if(token == '(') {
				A.push(token);
				if(((e.charAt(p+1)) == '-')) {
					p++;
					B.push(-formNum());
					while(e.charAt(p) != ')'){
						p++;
					}
				} 
				p++;      
			}
			if(token == ')' ){
				evalDown();
				p++; 
			}
			if( token == ' ') {
				p++;
			}
			if((token=='+') || (token=='*') || (token=='/') || (token == '^') || (token == '-')){  
				if((A.size() == 0) || (prec(token, A) == true)) {
					A.push(token);
					p++;         
				}
				else{
					eval();
				}
			}
			if(((token<='9')&&(token>='0'))||(token=='.')) {   
				B.push(formNum());
			}
		}while(p < e.length());
		while(A.size()>0) {
			eval();
	    }
		
	    double x = B.pop();
	    
	    expressionOutput((double)Math.round(x*10000000)/10000000.0); 
	    return x; 
	} 
	public static void expressionOutput(double x) {
		if(x == (double)Math.round(x)) {
			int intAns = (int)x;
			System.out.println("The answer to this equation is: " + intAns + '\n');
	    }
	    else{
	    	System.out.println("The answer to this equation is: " + x + '\n');
	    }
	  }
}
