
import java.util.Stack;

public class InfixToPostFix {
	
//method for PostFix
	static String postFix(String str) {
		
		Stack<Character> stack = new Stack<Character>();
		String result = new String("");
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			//System.out.println(stack + ", char: " + ch + ", at loop: " + i);
			
			
			//if it is an operand: a,b,c,d....
			if(Character.isLetterOrDigit(ch)) {
				result += ch;
			}
			
			else if(ch == '(') stack.push(ch);
			
			//a^(f*h)-i
			else if(ch == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();		//not looking at order
					
					
					/*
					 * if(!stack.isEmpty() && stack.peek() != '(') { return "Invalid Expression"; }
					 * else stack.pop();
					 */										
				}
				if(stack.peek() == '(') stack.pop();
					
			}
			
			//a^(f*h)-i
			else {	//if it is an operator
				
				
				
				// ^ 
				while (!stack.isEmpty() && (checkPrecedence(ch) <= checkPrecedence( stack.peek() )) ) {
					
					/*
					 * if( stack.peek() == '(') stack.pop(); else result += stack.pop();
					 */
					result += stack.pop();
				}
				stack.push(ch);
			}
			
			/*
			 * System.out.print("ch: " + ch); System.out.print(", stack: " + stack);
			 * System.out.println(", result: " + result);
			 */
			 
		}
		
		while(!stack.isEmpty()) {					//pop all operators from stack
			if( stack.peek() == '(') stack.pop();
			else result += stack.pop();
		}
		return result;
	}

	//method for checking higher or lower precedence
	private static int checkPrecedence(char ch) {
		
		switch(ch) {
		case '+': 
		case '-': 
			return 1; 
		 
		case '*': 
		case '/': 
			return 2; 
		 
		case '^':
			return 3;
		/*
		 * case '(': case ')': return 4;
		 */
		}
		return -1; 
		 
	} 

	

}