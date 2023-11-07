import java.util.Scanner;

public class VacationPackage {
    public static void main(String[] args) {
        double dsct = 0.0;
        double durationFee = 0.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the destination of the vacation: ");
        String destination = scanner.nextLine();
        
        int travelers = 0;
        while (travelers <= 0) {
            System.out.println("Enter the number of travelers (must be a positive integer): ");
            if (scanner.hasNextInt()) {
                travelers = scanner.nextInt();
                if (travelers <= 0) {
                    System.out.println("Please enter a positive integer for the number of travelers.");
                }
            } else {
                System.out.println("Please enter a valid positive integer for the number of travelers.");
                scanner.next(); // Consumes the invalid input
            }
        }

        int duration = 0;
        while (duration <= 0) {
            System.out.println("Enter duration of vacation (in days, must be a positive integer): ");
            if (scanner.hasNextInt()) {
                duration = scanner.nextInt();
                if (duration <= 0) {
                    System.out.println("Please enter a positive integer for the duration of the vacation.");
                }
            } else {
                System.out.println("Please enter a valid positive integer for the duration of the vacation.");
                scanner.next(); // Consumes the invalid input
            }
        }

        final double BASE_COST = 1000.00;

        // Utiliza la constante en lugar del número mágico
        double baseCost = BASE_COST;
        if (destination.equalsIgnoreCase("Paris")) {
            baseCost += 500.00;
        } else if (destination.equalsIgnoreCase("New York")) {
            baseCost += 700.00;
        }

        if (travelers >= 4 && travelers < 10) {
            dsct = 0.10 * baseCost;
            baseCost -= dsct;
        }

        if (travelers >= 10) {
            dsct = 0.20 * baseCost;
            baseCost -= dsct;
        }

        if (duration < 7) {
            durationFee = 200.00;
            baseCost += durationFee;
        }

        if (duration > 30 || travelers == 2) {
            durationFee = 200.00;
            baseCost -= durationFee;
        }

        if (travelers > 80) {
            System.out.println("Too many passengers!");
            baseCost = -1.0;
        }

        if (baseCost == -1.0) {
            System.out.println("The price of the vacation package is: Not available");
        } else {
            System.out.println("The price of the vacation package is: $" + baseCost);
        }

        scanner.close();
    }
}
