package se.lernia.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> prices = new ArrayList<>(24);
        Elprices elprices = new Elprices(prices, sc);

        while (true) {
            System.out.println("Elpriser");
            System.out.println("========");
            System.out.println("1. Inmatning");
            System.out.println("2. Min, Max och Medel");
            System.out.println("3. Sortera");
            System.out.println("4. Bästa Laddningstid (4h)");
            System.out.println("e. Avsluta");
            System.out.println("Välj ett av alternativen: ");

            String input = sc.nextLine().toLowerCase();

            if (input.equals("e")) {
                System.out.println("Avsluta");
                break;
            }

            try {
                int val = Integer.parseInt(input);

                switch (val) {
                    case 1:
                        elprices.manualInput();
                        break;
                    case 2:
                        elprices.findMinMaxAverage();
                        break;
                    case 3:
                        elprices.sortPrices();
                        break;
                    case 4:
                        elprices.bestChargingTime();
                        break;
                    default:
                        System.out.println("Ogiltigt alternativ");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning, försök igen.");
            }
        }

        sc.close();
    }
}
