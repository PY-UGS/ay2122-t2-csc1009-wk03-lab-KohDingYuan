import java.util.*;

public class Loan {

    private double annualInterestRate = 2.5;
    private int numberOfYears = 1;
    private double loanAmount = 1000;
    private Date loanDate;

    public Loan() {
        this.loanDate = new Date();
    }
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public int getNumberOfYears() {
        return numberOfYears;
    }
    public double getLoanAmount() {
        return loanAmount;
    }
    public Date getLoanDate() {
        return loanDate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    
    public double getMonthlyPayment() {
        // Lazy handling of unset property value
        if (Objects.isNull(this.annualInterestRate) ||
                Objects.isNull(this.numberOfYears) ||
                Objects.isNull(this.loanAmount))
            return -1;

        double monthlyInterestRate = (this.annualInterestRate / 100) / 12;
        return ((this.loanAmount * monthlyInterestRate)
                / (1 - (1 / (Math.pow((1 + monthlyInterestRate), (this.numberOfYears * 12))))));
    }
    public double getTotalPayment() {
        // Lazy handling of unset property value
        if (Objects.isNull(this.annualInterestRate) ||
                Objects.isNull(this.numberOfYears) ||
                Objects.isNull(this.loanAmount))
            return -1;

        return this.getMonthlyPayment() * this.numberOfYears * 12;
    }
}