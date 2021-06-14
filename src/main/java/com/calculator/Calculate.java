package com.calculator;

public class Calculate implements iCalc{
	     char Operator;
         Double  iFNum =new Double(0);
         Double iSNum =new Double(0);;
         Double dblNumber=new Double(0);
		 Double dblResult=new Double(0);
		
		public Calculate()
		{
			
		}
		// Defines a constructor for scientific calculations
		public Calculate(Double dblNum, char cOperator)
		{
			dblNumber=dblNum;
			Operator=cOperator;
		}
		
		public Calculate(char cOperator)
		{
			Operator=cOperator;
		}

		// Defines a constructor for basic calculations
		public Calculate(Double iFirstNum, char cOperator, Double iSecondNum)
		{
			iFNum=iFirstNum;
			iSNum=iSecondNum;
			Operator=cOperator;
		}

		// Calculates the Result based on the operator selected by the user
		public void doCalculation()
		{
			dblResult=0.0;
			
			switch (Operator)
			{
				case '+':
					dblResult = iFNum + iSNum;
					break;

				case '-':
					dblResult = iFNum - iSNum;
					break;

				case '*':	
					dblResult = iFNum * iSNum;
					break;

				case '/':
					if(!checkSecondNum())
					{	
						dblResult = iFNum / iSNum;
						break;
					}
					
					
				case 'Z':
				case 'z':
					dblResult = Math.pow(iFNum,iSNum);
					break;
					
					
				case 'S':
				case 's':
					dblResult = Math.sin(dblNumber);
					break;

				case 'C':
				case 'c':
					dblResult = Math.cos(dblNumber);
					break;

				case 'T':
				case 't':
					dblResult = Math.tan(dblNumber);
					break;

				case 'L':
				case 'l':
					dblResult = Math.log(dblNumber);
					break;
					
				case 'K':
				case 'k':
					dblResult = Math.log10(dblNumber);
					break;
					
				case 'P':
				case 'p':
					dblResult = Math.PI;
					break;
					
				case 'E':
				case 'e':
					dblResult = Math.E;
					break;
					
				case '!':
					dblResult = fact(dblNumber);
					break;
					
					
				case 'Q':
				case 'q':
					dblResult = Math.sqrt(dblNumber);
					break;	
					
				default :
					dblResult=0.0;
					System.out.println("Operation Not Available. Please select any of the available options."); 
					break;
			}
		}

		// Displays the result of calculation to the user
		public void getResult()
		{
		
			System.out.println("The result is: " + dblResult);	
			
		}
		
		// Checks for zero
		public boolean checkSecondNum()
		{
			if(iSNum==0) 
			{
				System.out.println("Zero Not allowed");
				System.exit(0);
				return true;
			}
			else
			{
				return false;
			}
		}
		double fact(double n)
		{
		if(n==1)
		return 1;
		double x=n*fact(n-1);
		return x;
		}

}
