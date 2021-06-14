package com.calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {

	public void Calc() throws java.io.IOException
	{
		boolean next;

		do
		{
			Double iFirstNumber=new Double(0);
			Double iSecondNumber=new Double(0);
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

			// Gets User Input
			System.out.println("Please enter First Number: ");
			System.out.flush();

			try
			{
				iFirstNumber=Double.parseDouble(buffer.readLine());				
			}
			catch(NumberFormatException e)
			{
				System.out.println("Please provide numeric values.");
				System.exit(0);
			}

			System.out.println("Please enter the Operation (Add : +, Minus : -, Product : *, Divide : /,Power :z):");
			System.out.flush();
			String option=buffer.readLine();
			
			if(!(option.equalsIgnoreCase("+") || option.equalsIgnoreCase("-") || option.equalsIgnoreCase("*") || option.equalsIgnoreCase("/") ||option.equalsIgnoreCase("z")) )
			{
				try{
					// I'm throwing the custom exception using throw
						throw new MyException("Enter valid options");
			}
				catch(MyException exp){
					System.out.println(exp);
					System.exit(0);
				}
			}
			System.out.println("Please enter Second Number: ");
			System.out.flush();

			try
			{
				iSecondNumber=Double.parseDouble(buffer.readLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Please provide numeric values.");
				System.exit(0);
			}
			
			if(option.length()==1)
			{
				// Creates Calculate Class Instance
				Calculate c= new Calculate(iFirstNumber,option.charAt(0),iSecondNumber);

				// Calls the class methods
				c.doCalculation();
				c.getResult();
			}
			else
			{	
				try{
					// I'm throwing the custom exception using throw
						throw new MyException("Enter valid options");
			}
				catch(MyException exp){
					System.out.println(exp) ;
				}
		}

			// Checks if the user would like to compute again
			System.out.println("Would you like to calculate again (y/n)?");
			System.out.flush();
			String response=buffer.readLine();
			if (response.equalsIgnoreCase("y"))
			{
				next=true;
			}
			else
			{
				next=false;
			}
			
		}while (next);

	}

}
