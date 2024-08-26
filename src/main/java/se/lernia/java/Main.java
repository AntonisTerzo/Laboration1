package se.lernia.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create the scanner outside the loop

        while (true) {
            System.out.println("Elpriser");
            System.out.println("========");
            System.out.println("Välj ett av följande alternativ:");
            System.out.println("1. Inmatning");
            System.out.println("2. Min, Max och Medel");
            System.out.println("3. Sortera");
            System.out.println("4. Bästa Laddningstid (4h)");
            System.out.println("e. Avsluta");

            String input = scanner.nextLine().toLowerCase();

            if (input.equals( "e")) {
                System.out.println("Avsluta");
                break;
            }

            try {
                int val = Integer.parseInt(input);

                switch (val) {
                    case 1:
                        System.out.println("Inmatning");
                        break;
                    case 2:
                        System.out.println("Min, Max och Medel");
                        break;
                    case 3:
                        System.out.println("Sortera");
                        break;
                    case 4:
                        System.out.println("Bästa Laddningstid (4h)");
                        break;
                    default:
                        System.out.println("Ogiltigt alternativ");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning, försök igen.");
            }
        }

        scanner.close();
    }
}
