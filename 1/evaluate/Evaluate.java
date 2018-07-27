import edu.princeton.cs.algs4.StdOut;
import java.util.*;

public class Evaluate
{
	public static double evaluate(String s)
	{
		double result = 0;
		Stack<Character> operators = new Stack<Character>();
		Stack<Double> numbers = new Stack<Double>();
		
		double temp1 = 0;
		char temp;
		char temp_operator;
		for (int i = 0; i < s.length(); i++)
		{
			temp = s.charAt(i);
			if (temp == ' ' || temp == '(')
				continue;
			else
			{
				if (temp == '+' || temp == '-' || temp == '*' || temp == '/' || temp == '&') // & represents sqrt, &3 : sqrt(3), must have ()!!
					operators.push(temp);
				else if (temp == ')')
				{
					temp1 = numbers.pop();
					temp_operator = operators.pop();
					switch(temp_operator)
					{
						case '+':
							numbers.push(temp1 + numbers.pop());
							break;
						case '-':
							numbers.push(temp1 - numbers.pop());
							break;
						case '*':
							numbers.push(temp1 * numbers.pop());
							break;
						case '/':
							numbers.push(temp1 / numbers.pop());
							break;
						case '&':
							numbers.push(Math.sqrt(temp1));
					}

				}
				else
				{
					numbers.push((double)(temp - '0'));
				}
				
			}
		}
		return numbers.pop();

	}

	public static void main(String[] args)
	{
		String target_expression = "(1 + ((2 + &(3)) * (4 * 5)))";
		double result = evaluate(target_expression);
		StdOut.println(result);
	}
}