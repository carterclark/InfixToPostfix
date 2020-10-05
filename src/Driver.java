import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) throws Exception {
		
		//Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Enter infix expression: ");
        String str = input.next();
        input.close();	
        
        //System.out.print(postFix(str));
		
        
        System.out.println("Input in Infix:    " + str);
		System.out.println("Output in Postfix: " + InfixToPostFix.postFix(str));
		//System.out.println("Correct: abcd^e-fgh*+^*+i-");
		
		
	}

}
