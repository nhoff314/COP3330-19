package com.company;

public class Main {

    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        saver1.setBalance(2000);
        saver2.setBalance(3000);

        new SavingsAccount().modifyInterestRate(0.04);

        System.out.printf("Saver1's Monthly Interest: %.2f\n", saver1.calculateMonthlyInterest());
        System.out.printf("Saver1's ");
        saver1.printBalance();
        System.out.printf("Saver2's Monthly Interest: %.2f\n", saver2.calculateMonthlyInterest());
        System.out.printf("Saver2's ");
        saver2.printBalance();

        System.out.println("");

        new SavingsAccount().modifyInterestRate(0.05);
        System.out.printf("Saver1's Monthly Interest: %.2f\n", saver1.calculateMonthlyInterest());
        System.out.printf("Saver1's ");
        saver1.printBalance();
        System.out.printf("Saver2's Monthly Interest: %.2f\n", saver2.calculateMonthlyInterest());
        System.out.printf("Saver2's ");
        saver2.printBalance();


    }
}
