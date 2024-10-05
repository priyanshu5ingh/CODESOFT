import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String   
 userName;
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int wins = 0;

        System.out.print("Enter your name: ");
        userName = scanner.nextLine();

        System.out.println("Welcome, " + userName + "! Let's play a number guessing game.");

        while (true) {
            rounds++;
            int randomNumber = (int) (Math.random() * (maxRange - minRange + 1) + minRange);
            int attempts = 0;

            System.out.println("Round " + rounds);
            System.out.println("Guess a number between " + minRange + " and " + maxRange + ": ");

            while (attempts < maxAttempts) {
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");   

                    wins++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");   

                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was: " + randomNumber);
            }

            System.out.println("Would   
 you like to play another round? (yes/no)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Game over!");
        System.out.println("You   
 won " + wins + " out of " + rounds + " rounds.");
    }
}