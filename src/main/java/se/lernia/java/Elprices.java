package se.lernia.java;

import java.util.Scanner;

public class Elprices {
    private final int[] prices;
    private final Scanner sc;
//Creating a constructor
    public Elprices(int initialPrice, Scanner sc) {
        this.prices = new int[24];
        for (int i = 0; i < 24; i++) {
            this.prices[i] = initialPrice;
        }
        this.sc = sc;
    }

    public void manualInput() {
        System.out.println("Inmatning av elpriser");
        System.out.println("=====================");

        for (int i = 0; i < 24; i++) {
            while (true) {
                System.out.printf("Ange pris för timme %02d-%02d: ", i, (i + 1) % 24);
                String input = sc.nextLine();

                try {
                    int price = Integer.parseInt(input);
                    if (price < 0) {
                        System.out.println("Priset kan inte vara negativt. Försök igen.");
                    } else {
                        prices[i] = price;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ogiltigt inmatning. Ange ett heltal i ören.");
                }
            }
        }
        System.out.println("Inmatning av elpriser klar, priser är registrerad.");
    }

    public void findMinMaxAverage() {
        if (prices.length != 24) {
            System.out.println("Inga prisuppgifter tillgängliga. Ange priser först.");
            return;
        }

        int minPrice = prices[0];
        int maxPrice = prices[0];
        int minHour = 0;
        int maxHour = 0;
        long sum = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            sum += price;
            if (price < minPrice) {
                minPrice = price;
                minHour = i;
            }
            if (price > maxPrice) {
                maxPrice = price;
                maxHour = i;
            }
        }
        double averagePrice = (double) sum / prices.length;
        System.out.println("Pris Analys");
        System.out.println("=====================");
        System.out.printf("Lowest price: %d öre/kWh (Hour %02d-%02d)%n", minPrice, minHour, (minHour + 1) % 24);
        System.out.printf("Highest price: %d öre/kWh (Hour %02d-%02d)%n", maxPrice, maxHour, (maxHour + 1) % 24);
        System.out.printf("Average price: %.2f öre/kWh%n", averagePrice);
    }
    public int[] getPrices() {

        return prices;
    }
}
