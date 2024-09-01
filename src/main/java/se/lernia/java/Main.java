package se.lernia.java;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Elprices elprices;

    public static void main(String[] args) {
        elprices = new Elprices(sc);
        menu();
    }

    public static void menu() {
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

        sc.close();
    }
}
