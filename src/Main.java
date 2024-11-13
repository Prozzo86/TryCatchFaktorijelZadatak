/*

Napiši Java program koji omogućuje korisniku unos broja, a zatim računa faktorijel tog broja.
Program treba obraditi iznimke koje se mogu pojaviti tijekom unosa i računanja faktorijela.

1. Ispiši poruku korisniku da unese broj.
2. Koristi Scanner za unos broja od korisnika.
3. Obradi iznimke koje se mogu pojaviti tijekom unosa. Ako korisnik unese nešto što nije broj, ispiši odgovarajuću poruku i zatraži ponovni unos.
4. Računaj faktorijel unesenog broja.
5. Obradi iznimke koje se mogu pojaviti tijekom računanja faktorijela. Na primjer, obradi situaciju kada korisnik unese negativan broj jer faktorijel nije definiran za negativne brojeve.
6. Ispiši rezultat ili poruku o greški, ovisno o tome je li računanje faktorijela uspješno ili ne.

*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int broj;

        while (true) {
            System.out.print("Unesite cijeli broj za računanje faktorijela: ");
            try {
                broj = Integer.parseInt(scanner.nextLine());

                if (broj < 0) {
                    System.out.println("Faktorijel nije definiran za negativne brojeve. Pokušajte ponovo.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Neispravan unos. Molimo unesite cijeli broj.");
            }
        }

        try {
            long faktorijel = izracunajFaktorijel(broj);
            System.out.println("Faktorijel broja " + broj + " je: " + faktorijel);
        } catch (ArithmeticException e) {
            System.out.println("Računanje faktorijela je prekoračilo granice podržane vrijednosti.");
        }
    }

    public static long izracunajFaktorijel(int broj) {
        long faktorijel = 1;
        for (int i = 1; i <= broj; i++) {
            faktorijel *= i;
        }
        return faktorijel;
    }

}
