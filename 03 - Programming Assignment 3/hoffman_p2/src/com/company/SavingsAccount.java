package com.company;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public void setBalance(double balance){
        savingsBalance = balance;
    }

    public double calculateMonthlyInterest(){
        double monthlyInterest =  savingsBalance*annualInterestRate/12.0;
        savingsBalance = savingsBalance + monthlyInterest;
        return monthlyInterest;
    }

    public void printBalance() {
        System.out.printf("New Balance: %.2f\n", savingsBalance);
    }

    static void modifyInterestRate(double rate){
        annualInterestRate = rate;
    }
}
