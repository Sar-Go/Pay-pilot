import java.util.Scanner;

public class simpleCalcApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter payment amount:");
        double paymentAmount = scanner.nextDouble();

        // Get user input for payment category
        System.out.print("Enter payment category (A, B, or C): ");
        char paymentCategory = scanner.next().toUpperCase().charAt(0);

        // Close the scanner to avoid resource leak
        scanner.close();

        // Calculate rewards for each payment option based on the payment category
        double rewardP1 = calculateReward(paymentAmount, paymentCategory, 'A');
        double rewardP2 = calculateReward(paymentAmount, paymentCategory, 'B');
        double rewardP3 = calculateReward(paymentAmount, paymentCategory, 'C');

        // Display rewards for each payment option
        System.out.println("Rewards for Payment Option P1: $" + rewardP1);
        System.out.println("Rewards for Payment Option P2: $" + rewardP2);
        System.out.println("Rewards for Payment Option P3: $" + rewardP3);

        // Determine the best payment option
        char bestOption = determineBestOption(rewardP1, rewardP2, rewardP3);
        System.out.println("The best payment option is: P" + bestOption);
    }

    // Helper method to calculate rewards based on payment category
    private static double calculateReward(double amount, char paymentCategory, char targetCategory) {
        double reward = 0;
        if (paymentCategory == targetCategory) {
            switch (targetCategory) {
                case 'A':
                    reward = 0.2 * amount;
                    break;
                case 'B':
                    reward = amount;
                    break;
                case 'C':
                    reward = amount;
                    break;
            }
        }
        return reward;
    }

    // Helper method to determine the best payment option
    private static char determineBestOption(double rewardP1, double rewardP2, double rewardP3) {
        if (rewardP1 >= rewardP2 && rewardP1 >= rewardP3) {
            return '1';
        } else if (rewardP2 >= rewardP1 && rewardP2 >= rewardP3) {
            return '2';
        } else {
            return '3';
        }
    }
}
