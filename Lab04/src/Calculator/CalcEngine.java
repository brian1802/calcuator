package Calculator;

import java.util.HashMap;
import java.util.Stack;

/**
 * The main part of the calculator doing the calculations.
 * 
 * @author  M. Kolling 
 * @version 0.1 (incomplete)
 */
public class CalcEngine
{
    char operator;
    int displayValue, operand1;

    /**
     * Create a CalcEngine instance. Initialise its state so that it is ready 
     * for use.
     */
    public CalcEngine()
    {
        operator =' ';
        displayValue=0;
		operand1 = 0;
    }

    /**
     * Return the value that should currently be displayed on the calculator
     * display.
     */
    public int getDisplayValue()
    {
        return(displayValue);
    }

    /**
     * A number button was pressed. Do whatever you have to do to handle it.
     * The number value of the button is given as a parameter.
     */
    public void numberPressed(int number)
    {
        displayValue = displayValue *10 + number;
    }

    /**
     * The 'plus' button was pressed. 
     */
    public void plus()
    {
       operand1 = displayValue;
	   displayValue = 0;
       operator = '+';
    }
    
    /**
     * The 'minus' button was pressed.
     */
    public void minus()
    {
        operand1 = displayValue;
	   displayValue = 0;
       operator = '-'; 
    }

public void multiply()
    {
        operand1 = displayValue;
	   displayValue = 0;
       operator = '*'; 
    }

public void divide()
    {
        operand1 = displayValue;
	   displayValue = 0;
       operator = '/'; 
    }

    /**
     * The '=' button was pressed.
     */
    public void equals()
    {
        if (operator == '+') {
			displayValue += operand1;
			operand1 = 0;
		}
	    else if (operator == '-') {
			displayValue = operand1-displayValue;
			operand1 = 0;
		}
		else if (operator == '*') {
			displayValue = operand1*displayValue;
			operand1 = 0;
		}
		else if (operator == '/') {
			displayValue = operand1/displayValue;
			operand1 = 0;
		}

    }

    /**
     * The 'C' (clear) button was pressed.
     */
    public void clear()
    {
        displayValue = 0;
		operand1 = 0;

    }

    /**
     * Return the title of this calculation engine.
     */
    public String getTitle()
    {
        return("My Calculator");
    }

    /**
     * Return the author of this engine. This string is displayed as it is,
     * so it should say something like "Written by H. Simpson".
     */
    public String getAuthor()
    {
        return("Joe Daly");
    }

    /**
     * Return the version number of this engine. This string is displayed as 
     * it is, so it should say something like "Version 1.1".
     */
    public String getVersion()
    {
        return("Ver. 1.0");
    }
    
    /**
     * Converts from infix to postfix.This will make it easier for the 
     * calculator to read.
     * @param infix
     * @return
     */
    public String convertInfixToPostfix(String infix)
    {
    	//Creats a Stack
    	Stack<Character> s = new Stack<Character>();
    	int i = 0;
    	//Creates an empty string
    	String output = "";
    	while(i < infix.length()){
    		char c = infix.charAt(i);
    		if(Character.isDigit(c)){
    			output += c;
    		}
    		else
    		{
    			if(s.empty()){
    				s.push(c);
    			}
    			else
    			while(cBP(s.peek(),c)){
    				output += s.pop();
    			}
    			s.push(c);
    		}
    		i++;
    	}
    	while(!s.empty()){
    		output += s.pop();
    	}
    	return output;
    }
    
    /**
     * This method will assign each operator a value to determin a higher 
     * precedence.
     * @param op1
     * @param op2
     * @return
     */
    public boolean cBP(char op1, char op2){
    	//Creates a hash map
    	HashMap<Character, Integer> p = new HashMap<Character, Integer>();
    	//Assignes all of the operators a value.
    	p.put('*', 4);			
    	p.put('/', 3);
    	p.put('+', 2);
    	p.put('-', 1);
    	
    	//Gets the operation and its value
    	int p1 = p.get(op1);
    	int p2 = p.get(op2);
    	
    	//Checks which operation has a higher precedence
    	if(p1 > p2){
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}