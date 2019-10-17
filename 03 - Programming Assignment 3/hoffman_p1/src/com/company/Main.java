package com.company;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static boolean question(Random rand, Scanner scnr, int diff, int question) {
        int x = 0, y = 0;
        int questionType;
        double answer=0.00;
        switch (diff) {
            case 1:
                x = rand.nextInt(10);
                y = rand.nextInt(9) + 1;
                break;
            case 2:
                x = rand.nextInt(100);
                y = rand.nextInt(99) + 1;
                break;
            case 3:
                x = rand.nextInt(1000);
                y = rand.nextInt(999) + 1;
                break;
            case 4:
                x = rand.nextInt(10000);
                y = rand.nextInt(9999) + 1;
                break;
        }
        if (question == 5)
            questionType = rand.nextInt(4) + 1;
        else
            questionType = question;

        switch (questionType) {
            case 1:
                System.out.println("How much is " + x + " plus " + y + "?");
                answer = scnr.nextDouble();
                return answer == (double) x + (double) (y);
            case 2:
                System.out.println("How much is " + x + " minus " + y + "?");
                answer = scnr.nextDouble();
                return answer == (double) x - (double) (y);
            case 3:
                System.out.println("How much is " + x + " times " + y + "?");
                answer = scnr.nextDouble();
                return answer == (double) x * (double) (y);
            case 4:
                System.out.println("How much is " + x + " divided by " + y + "?(Don't round up)");
                answer = scnr.nextDouble();
                if(Math.abs(((double) x / (double) y) - answer) < 0.01)
                    return true;
        }
        return false;
    }

    private static void response( Random rand, int correct){
        if (correct == 1) {
            int yes = rand.nextInt(4) + 1;
            switch (yes) {
                case 1:
                    System.out.println("Very good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }
        else {
            int no = rand.nextInt(4) + 1;
            switch (no) {
                case 1:
                    System.out.println("No. Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don't give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }
    }

    private static void gradeCheck(int score) {
        System.out.println("Correct Answers: " + score + "\n" + "Wrong Answers: " + (10 - score));
        if (((double)score / 10.0) * 100.0 >= 75.0)
            System.out.println("Congratulations, you are ready to go to the next level!");
        else
            System.out.println("Please ask your teacher for extra help");
    }

    private static int whatDifficulty(Scanner scnr){
        System.out.println("What difficulty? (1-4)");
        return scnr.nextInt();
    }

    private static int whatQuestion(Scanner scnr){
        System.out.print("Choose an option:\n1)Addition\n2)Subtraction\n3)Multiplication\n4)Division\n5)All\n");
        return scnr.nextInt();
    }

    private static boolean resume(Scanner scnr){
        System.out.println("Quit (q) or Resume(r)?");
        char quit = scnr.next().charAt(0);
        return quit == 'r';
    }

    public static void main(String[] args) {
        Random rand = new SecureRandom();
        Scanner scnr = new Scanner(System.in);
        int score = 0, diff, question;
        int correct;
        while (resume(scnr)) {
            diff = whatDifficulty(scnr);
            question = whatQuestion(scnr);
            for (int i = 0; i < 10; i++) {
                System.out.print(i + 1 + ")");
                if (question(rand, scnr, diff, question)) {
                    score++;
                    correct = 1;
                    response(rand, correct);
                }
                else {
                    correct = 0;
                    response(rand, correct);
                }
            }
            gradeCheck(score);
        }
    }
}
