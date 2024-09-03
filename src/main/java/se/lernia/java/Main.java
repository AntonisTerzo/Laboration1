package se.lernia.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> prices = new ArrayList<>();
        Elprices elprices = new Elprices(prices, sc);

        while (true) {
            System.out.println("Välkomen till Elpriser, priserna anges i hela ören (1.50kr anges således som 150).");
            System.out.println("========");
            System.out.println("1. Manual Inmatning av priser");
            System.out.println("2. Min, Max och Medel priser");
            System.out.println("3. Sortera priser efter billigast till dyrast");
            System.out.println("4. Bästa Laddningstid (4h)");
            System.out.println("5. Läs in priser från CSV fil");
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
                    case 5: 
                        elprices.readPricesFromCsv();
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
