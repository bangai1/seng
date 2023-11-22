
import java.util.Stack;

public class postfixtoInfix {


    public static void main(String[] args)
    {
        String postfixExpression = "1234567891+-*+-*+-*";
        String infixExpression = postfixToInfix(postfixExpression);
        System.out.println("Infix Expression: " + infixExpression);
    }



    public static String postfixToInfix(String formula)
    {

        Stack<String> stack = new Stack<>();
        String operators = "+-*/^";
        String[] tokens = formula.split("");

        for (String token : tokens)
        {

            if (isOperand(token))
            {
                stack.push(token);
            }

            else if (operators.contains(token))
            {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String infix = "(" + operand1 + token + operand2 + ")";
                stack.push(infix);
            }
        }

        if (!stack.isEmpty())
        {
            return stack.pop();
        }

        else
        {
            return null;
        }
    }

    public static boolean isOperand(String token) {
        return !"+-*/^".contains(token);
    }

}
