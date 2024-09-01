package se.lernia.java;


import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Elprices {
    private final List<Integer> prices;
    private final Scanner sc;

    public Elprices(List<Integer> prices, Scanner sc) {
        this.prices = prices;
        this.sc = sc;
    }

    public void manualInput() {
        System.out.println("Inmatning av elpriser");
        System.out.println("=====================");

        prices.clear();

        for (int i = 0; i < 24; i++) {
            while (true) {
                System.out.printf("Ange pris för timme %02d-%02d: ", i, (i + 1) % 24);
                String input = sc.nextLine();

                try {
                    int price = Integer.parseInt(input);
                    if (price < 0) {
                        System.out.println("Priset kan inte vara negativt. Försök igen.");
                    } else {
                        prices.add(price);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ogiltigt inmatning. Ange ett heltal i ören.");
                }
            }
        }
        System.out.println("Inmatning av elpriser klar, priser är registrerad.");

        System.out.println("Tryck enter för att fortsätta.");
        sc.nextLine();
    }

    public void findMinMaxAverage() {
        if (prices.isEmpty()) {
            System.out.println("Inga priser har registrerats ännu.");
            return;
        }

        int minPrice = prices.getFirst();
        int maxPrice = prices.getFirst();
        int minHour = 0;
        int maxHour = 0;
        long sum = 0;

        for (int i = 0; i < prices.size(); i++) {
            int price = prices.get(i);
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

        double averagePrice = (double) sum / prices.size();

        System.out.println("Pris Analys");
        System.out.println("=====================");
        System.out.printf("Lowest price: %d öre/kWh (Hour %02d-%02d)%n", minPrice, minHour, (minHour + 1) % 24);
        System.out.printf("Highest price: %d öre/kWh (Hour %02d-%02d)%n", maxPrice, maxHour, (maxHour + 1) % 24);
        System.out.printf("Average price: %.2f öre/kWh%n", averagePrice);

        System.out.println("Tryck enter för att fortsätta.");
        sc.nextLine();
    }

    public void sortPrices() {
        if (prices.isEmpty()) {
            System.out.println("Inga priser har registrerats ännu.");
            return;
        }

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            indices.add(i);
        }
        // Sort the indices based on the prices
        indices.sort((a, b) -> Integer.compare(prices.get(a), prices.get(b)));
        System.out.println("Sorterade priser: ");
        for (int index : indices) {
            System.out.printf("Timme %02d-%02d: %d öre/kWh%n", index, (index + 1) % 24, prices.get(index));
        }

        System.out.println("Tryck enter för att fortsätta.");
        sc.nextLine();
    }

    public void bestChargingTime() {
        if (prices.isEmpty()) {
            System.out.println("Inga priser har registrerats ännu.");
            return;
        }

        int windowSize = 4;
        int minSum = Integer.MAX_VALUE;
        int minStartHour = 0;

        for (int i = 0; i < prices.size(); i++) {
            int sum = 0;
            for (int j = 0; j < windowSize; j++) {
                sum += prices.get((i + j) % prices.size());
            }
            if (sum < minSum) {
                minSum = sum;
                minStartHour = i;
            }
        }

        double averagePrice = (double) minSum / windowSize;
        System.out.println("Bästa laddningstid (4 timmar):");
        System.out.printf("Starta laddning vid timme: %02d till %02d%n", minStartHour, (minStartHour + windowSize) % 24);
        System.out.printf("Totalpris för 4 timmar: %d öre%n", minSum);
        System.out.printf("Medelpris för 4 timmar: %.2f öre/kWh%n", averagePrice);

        System.out.println("Tryck enter för att fortsätta.");
        sc.nextLine();
    }
}
