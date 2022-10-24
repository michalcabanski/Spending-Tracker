package pl.michal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        SpendingTracker spendingTracker = new SpendingTracker();
        spendingTracker.addCategory("Wyp³ata");
        spendingTracker.addCategory("Zakupy");
        spendingTracker.addCategory("Mieszkanie");
        spendingTracker.addCategory("Ubrania");

        while (shouldContinue) {
            System.out.println("Wybierz opcjê:");
            System.out.println("1. Dodaj wydatek");
            System.out.println("2. Dodaj przychód");
            System.out.println("3. Poka¿ stan konta");
            System.out.println("4. Ustaw stan konta");
            System.out.println("5. Poka¿ operacje");
            System.out.println("6. Zarz¹dzaj kategoriami");
            System.out.println("7. Wyjœcie");

            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1 -> spendingTracker.addFinancialOperation(1);
                case 2 -> spendingTracker.addFinancialOperation(2);
                case 3 -> spendingTracker.displayAccountBalance();
                case 4 -> spendingTracker.setAccountBalance();
                case 5 -> spendingTracker.displayFinancialOperations();
                case 6 -> spendingTracker.menageCategories();
                case 7 -> shouldContinue = false;
            }
        }
    }
}