package pl.michal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        SpendingTracker spendingTracker = new SpendingTracker();
        spendingTracker.addCategory("Wypłata");
        spendingTracker.addCategory("Zakupy");
        spendingTracker.addCategory("Mieszkanie");
        spendingTracker.addCategory("Ubrania");

        while (shouldContinue) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dodaj wydatek");
            System.out.println("2. Dodaj przychód");
            System.out.println("3. Pokaż stan konta");
            System.out.println("4. Ustaw stan konta");
            System.out.println("5. Pokaż operacje");
            System.out.println("6. Zarządzaj kategoriami");
            System.out.println("7. Wyjście");

            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                switch (userChoice) {
                    case 1 -> spendingTracker.addFinancialOperation(OperationType.Expense);
                    case 2 -> spendingTracker.addFinancialOperation(OperationType.Income);
                    case 3 -> spendingTracker.showAccountBalance();
                    case 4 -> spendingTracker.setAccountBalance();
                    case 5 -> spendingTracker.showFinancialOperations();
                    case 6 -> spendingTracker.menageCategories();
                    case 7 -> shouldContinue = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Podaj liczbę!");
            }
        }
    }
}