package se.lernia.java;

import java.util.Scanner;

public class Elprices {
    private final int[] prices;
    private final Scanner sc;
//Creating a constructor
    public Elprices( Scanner sc) {
        this.prices = new int[24];
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
    public int[] getPrices() {
        return prices;
    }
}
