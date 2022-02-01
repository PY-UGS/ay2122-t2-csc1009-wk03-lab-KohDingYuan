import java.io.*;
import java.util.*;

public class Week03 {
    public void tutQuestion01(){
        double inputAnnualInterestRate, inputTotalPayment;
        int inputNumberOfYears;

        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter annual interest rate, for example, 8.25: ");
            inputAnnualInterestRate = input.nextDouble();

            System.out.print("Enter number of years as an integer: ");
            inputNumberOfYears = input.nextInt();

            System.out.print("Enter loan amount, for example, 120000.95: ");
            inputTotalPayment = input.nextDouble();
            input.close();
        }
        catch(Exception e){
            //Too lazy to implement error handling
            System.out.print("Error: Invalid input...");
            return;
        }

        Loan loanA = new Loan(inputAnnualInterestRate, inputNumberOfYears, inputTotalPayment);

        System.out.println("The loan was created on " + loanA.getLoanDate());
        System.out.format("The monthly payment is %.2f\n", loanA.getMonthlyPayment());
        System.out.format("The total payment is %.2f\n", loanA.getTotalPayment());
    }
}