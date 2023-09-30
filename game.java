import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsAllowed = 5;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Guessing Game!");

        while (true) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nNew round! Guess a number between " + minRange + " and " + maxRange + ".");

            while (attempts < attemptsAllowed) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += attempts;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == attemptsAllowed) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was: " + numberToGuess);
                }
            }

            rounds++;

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thank you for playing! Rounds played: " + rounds + ", Total score: " + score);
                break;
            }
        }

        scanner.close();
    }
}
