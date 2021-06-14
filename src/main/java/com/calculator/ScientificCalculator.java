package com.calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ScientificCalculator extends Calculate {
	char Operator;
	Double dblNumber=new Double(0);

	ScientificCalculator(){
		
	}

	ScientificCalculator(double dblNumber,char Operator)
	{
		// Calls Super Class Constructor
		super(dblNumber,Operator);

		this.Operator=Operator;
		this.dblNumber=dblNumber;
	}
	
	

	public ScientificCalculator(char Operator) {
		super(Operator);
		this.Operator=Operator;
	}

	public void Calc() throws java.io.IOException
	{
		boolean next;

		do
		{
			Double d=new Double(0);

			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			
			// Gets User Input
			System.out.println("Please enter the Operation (Sine-s, Cosine-c, Tangent-t,PI-p euler-e,factorial-!,Log-l,Log10-k,Sqareroot-q):");
			System.out.flush();
			String option=buffer.readLine();
			
			if(!(option.equalsIgnoreCase("s") || option.equalsIgnoreCase("c") || option.equalsIgnoreCase("t") || option.equalsIgnoreCase("p") ||option.equalsIgnoreCase("e")||option.equalsIgnoreCase("!")||option.equalsIgnoreCase("l")||option.equalsIgnoreCase("k")||option.equalsIgnoreCase("q")))
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
			
			if(!(option.equalsIgnoreCase("p") || option.equalsIgnoreCase("e"))) {
			System.out.println("Please enter a Value: ");
			System.out.flush();
			try
			{
				d=Double.valueOf(buffer.readLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Please provide numeric values.");
				System.exit(0);
			}
			
			}
			if(option.length()==1)
			{
				if(!(option.equalsIgnoreCase("p") || option.equalsIgnoreCase("e"))) {
				// Creates Class Instance
				ScientificCalculator sc=new ScientificCalculator(d,option.charAt(0));

				// Calls Super Class Methods
				sc.doCalculation();
				sc.getResult();
			}
			
				else {
				// Creates Class Instance
				ScientificCalculator sc=new ScientificCalculator(option.charAt(0));

				// Calls Super Class Methods
				sc.doCalculation();
				sc.getResult();
			}
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
