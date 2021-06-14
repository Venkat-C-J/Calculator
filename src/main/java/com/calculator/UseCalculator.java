package com.calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UseCalculator {
	public static void main(String[] args) throws java.io.IOException, MyException
	{
		BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));

		// Gets User Input
		System.out.println("Select the Calculator: Basic - B or Scientific - S.");
		System.out.flush();
		String option=buffer.readLine();

		if(option.length()==1)
		{
			if (option.equalsIgnoreCase("b"))
			{
				// Calls the Basic Calculator Application
				Calculator c=new Calculator();
				c.Calc();
			}
			else if(option.equalsIgnoreCase("s"))
			{
				// Calls the Scientific Calculator Application
				ScientificCalculator sc=new ScientificCalculator();                                                     
				sc.Calc();
			}
			else
			{	
				try{
					// I'm throwing the custom exception using throw
					throw new MyException("Enter valid options");
				}
				catch(MyException exp) {
					System.out.println(exp) ;
				}
				
			}
		}
		else
		{
			System.out.println("Please enter a single character value that is 'B' OR 'S'");
		}
	}


}
