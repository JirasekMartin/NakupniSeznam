import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean pokracovat = true;

        String[] kategorie = { "ovoce a zelenina", "luštěniny", "pečivo", "mléčné výrobky", "maso", "sladkosti",
                "nápoje", "ostatní" };
        LinkedList<Polozka> polozky = new LinkedList<Polozka>(); // Vytvoření kolekce linkedList

        Scanner sc = new Scanner(System.in); // Vytvoření vstupu uživatele

        for (int i = 0; i < kategorie.length; i++) {
            System.out.println("[" + i + "]: " + kategorie[i]);
        }
        System.out.println("-------------------------------------");

        while (pokracovat) // Zacyklování programu
        {
            String nazev;
            int kategorieIndex;

            System.out.print("Položka: ");
            nazev = sc.nextLine();
            System.out.print("Kategorie: ");

            boolean jeSpravne = false; // Kontrolní boolean, který slouží k potvrzení zadání správného vstupu
            // uživatele, pokud uživatel zadal správný input vrátí se hodnota true
            /*
             * Následující cyklus while se stará o kontrolu zadáné hodnoty uživatelem, pokud
             * zadáná hodnota není číslo nebo celé číslo (např.: 1 nebo 10),
             * tak se celý cyklus bude opakovat do doby dokud uživatel nezadá správnou
             * hodnotu, při zadání špatné hodnoty se uživateli do konzole
             * vytiskne varovná zpráva
             */
            while (!jeSpravne) {
                try {
                    kategorieIndex = Integer.parseInt(sc.nextLine());

                    polozky.add(new Polozka(nazev, kategorie[kategorieIndex]));

                    if (!(kategorieIndex < kategorie.length && kategorieIndex >= 0)) {
                        throw new Exception();
                    }

                    jeSpravne = true; // Nastavení booleanu jeSpravne na true, které ukončení zacyklení cyklu while

                } catch (Exception e) {
                    /*
                     * Exception error, se spustí při jakékoliv chybě, nebo při uživatelem zvolené
                     * chybě,
                     */
                    System.out.println("Zadej znovu: ");
                }
            }

            System.out.print("Přidat další položku [ano/ne]: ");
            String in = sc.nextLine();

            if (!in.equals("ano")) {
                pokracovat = false;
            }

        }

        sc.close();
        System.out.println("-------------------------------------\n");

        for (String nazev : kategorie) {
            System.out.print(nazev.toUpperCase() + ": ");

            List<Polozka> listSpolozkami = new ArrayList<>();

            for (Polozka polozka : polozky) {

                if (polozka.getKategorie() == nazev) {
                    listSpolozkami.add(polozka);
                }
            }

            if (listSpolozkami.size() == 0) {
                System.out.println("- \n");
            } else {
                for (Polozka polozka : listSpolozkami) {
                    System.out.print(polozka.getNazev());

                    if (listSpolozkami.size() != 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("\n");
            }
        }

    }
}