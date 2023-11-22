import java.util.Stack;


public class prefixtoInfix {

    public static void main(String[] args)
    {
        String prefixExpression = "/+*3422";
        String infixExpression = prefixToInfix(prefixExpression);
        System.out.println("Infix Expression: " + infixExpression);
    }

    public static String prefixToInfix(String formula)
    {

        Stack<String> stack = new Stack<>();
        String operators = "+-*/^";
        String[] tokens = formula.split("");

        for (int i = tokens.length - 1; i >= 0; i--)
        {
            String token = tokens[i];

            if (isOperand(token))
            {
                stack.push(token);
            }

            else if (operators.contains(token))
            {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
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
