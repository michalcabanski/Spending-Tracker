package pl.michal;

import java.util.*;

public class SpendingTracker {
    private double balance;
    private List<FinancialOperation> financialOperations = new ArrayList<>();
    private Map<String, Double> categories = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void addCategory(String name) {
        categories.put(name, 0.0);
    }

    public void displayCategories() {
        System.out.println("Dostępne kategorie:");
        for (String category : categories.keySet())  {
            System.out.println(category);
        }
    }

    public void menageCategories() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            displayCategories();
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Dodaj kategorię");
            System.out.println("2. Zmień nazwę kategorii");
            System.out.println("3. Wróć");

            try {
                int userChoice = scanner.nextInt();
                scanner.nextLine();
                switch (userChoice) {
                    case 1 -> {
                        System.out.print("Podaj nazwę: ");
                        String name = scanner.nextLine();
                        addCategory(name);
                    }
                    case 2 -> {
                        System.out.print("Wybierz kategorię: ");
                        String name = scanner.nextLine();
                        double value = categories.get(name);
                        categories.remove(name);
                        System.out.print("Podaj nową nazwę: ");
                        String newName = scanner.nextLine();
                        categories.put(newName, value);

                        for (FinancialOperation financialOperation : financialOperations) {
                            if (financialOperation.getCategory().equals(name)) {
                                financialOperation.setCategory(newName);
                            }
                        }
                    }
                    case 3 -> shouldContinue = false;
                }
            } catch(InputMismatchException e) {
                System.out.println("Podaj liczbę");
                scanner.nextLine();
            }
        }
    }

    public void setAccountBalance() {
        System.out.print("Podaj stan konta w zł: ");
        this.balance = Double.parseDouble(scanner.nextLine());
    }

    public void displayAccountBalance() {
        System.out.printf("Stan konta: %dzł\n", (int)balance);
    }

    public void addFinancialOperation(operationType type) {
        System.out.print("Podaj kwotę w zł: ");
        double value = Double.parseDouble(scanner.nextLine());
        displayCategories();
        String category = scanner.nextLine();
        System.out.print("Podaj datę: ");
        String date = scanner.nextLine();
        System.out.print("Dodaj opis (opcjonalnie): ");
        String description = scanner.nextLine();
        FinancialOperation financialOperation = new FinancialOperation(value, category, date, description, type);
        financialOperations.add(financialOperation);
        switch (type) {
            case Income -> balance += value;
            case Expense -> balance -= value;
        }
        double n = categories.get(category);
        value += n;
        categories.put(category, value);
    }

    public void displayFinancialOperations() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Wszystkie operacje");
            System.out.println("2. Wydatki");
            System.out.println("3. Przychody");
            System.out.println("4. Operacje dla wybranej kategorii");
            System.out.println("5. Wróć");

            try {
                int userChoice = scanner.nextInt();
                scanner.nextLine();
                switch (userChoice) {
                    case 1 -> {
                        for (FinancialOperation financialOperation : financialOperations) financialOperation.displayInformations();
                    }
                    case 2 -> {
                        for (FinancialOperation financialOperation : financialOperations) {
                            if (financialOperation.getType().equals(operationType.Expense)) financialOperation.displayInformations();
                        }
                    }
                    case 3 -> {
                        for (FinancialOperation financialOperation : financialOperations) {
                            if (financialOperation.getType().equals(operationType.Income)) financialOperation.displayInformations();
                        }
                    }
                    case 4 -> {
                        displayCategories();
                        System.out.print("Wybierz kategorię: ");
                        String name = scanner.nextLine();
                        for (FinancialOperation financialOperation : financialOperations) {
                            if (financialOperation.getCategory().equals(name)) financialOperation.displayInformations();
                        }
                    }
                    case 5 -> shouldContinue = false;
                }
            } catch(InputMismatchException e) {
                System.out.println("Podaj liczbę");
                scanner.nextLine();
            }
        }
    }
}
