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
        System.out.println("Dostêpne kategorie:");
        for (String category : categories.keySet())  {
            System.out.println(category);
        }
    }

    public void menageCategories() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            displayCategories();
            System.out.println("\nWybierz opcjê:");
            System.out.println("1. Dodaj kategoriê");
            System.out.println("2. Zmieñ nazwê kategorii");
            System.out.println("3. Wróæ");

            int userChoice = Integer.parseInt(scanner.nextLine());
            switch (userChoice) {
                case 1 -> {
                    System.out.print("Podaj nazwê: ");
                    String name = scanner.nextLine();
                    addCategory(name);
                }
                case 2 -> {
                    System.out.print("Wybierz kategoriê: ");
                    String name = scanner.nextLine();
                    double value = categories.get(name);
                    categories.remove(name);
                    System.out.print("Podaj now¹ nazwê: ");
                    String newName = scanner.nextLine();
                    categories.put(newName, value);

                    for (FinancialOperation financialOperation : financialOperations) {
                        if (financialOperation.getCategory().equals(name)) {
                            financialOperation.setCategory(newName);
                        }
                    }
                }
                case 3 -> {
                    shouldContinue = false;
                }
            }
        }
    }

    public void setAccountBalance() {
        System.out.print("Podaj stan konta w z³: ");
        this.balance = Double.parseDouble(scanner.nextLine());
    }

    public void displayAccountBalance() {
        System.out.printf("Stan konta: %dz³\n", (int)balance);
    }

    public void addFinancialOperation(int i) {
        System.out.print("Podaj kwotê w z³: ");
        double value = Double.parseDouble(scanner.nextLine());
        displayCategories();
        String category = scanner.nextLine();
        System.out.print("Podaj datê: ");
        String date = scanner.nextLine();
        System.out.print("Dodaj opis (opcjonalnie): ");
        String description = scanner.nextLine();
        if (i == 1) {
            Expense expense = new Expense(value, category, date, description);
            financialOperations.add(expense);
            balance -= value;
        } else if (i == 2) {
            Income income = new Income(value, category, date, description);
            financialOperations.add(income);
            balance += value;
        }
        double n = categories.get(category);
        value += n;
        categories.put(category, value);
    }

    public void displayFinancialOperations() {
        System.out.println("Wybierz opcjê:");
        System.out.println("1. Wszystkie operacje");
        System.out.println("2. Wydatki");
        System.out.println("3. Przychody");
        System.out.println("4. Operacje dla wybranej kategorii");
//        System.out.println("5. Wróæ");

        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1 -> {
                for (FinancialOperation financialOperation : financialOperations) financialOperation.displayInformations();
            }
            case 2 -> {
                for (FinancialOperation financialOperation : financialOperations) {
                    if (financialOperation instanceof Expense) financialOperation.displayInformations();
                }
            }
            case 3 -> {
                for (FinancialOperation financialOperation : financialOperations) {
                    if (financialOperation instanceof Income) financialOperation.displayInformations();
                }
            }
            case 4 -> {
                displayCategories();
                System.out.print("Wybierz kategoriê: ");
                String name = scanner.next();
                for (FinancialOperation financialOperation : financialOperations) {
                    if (financialOperation.getCategory().equals(name)) financialOperation.displayInformations();
                }
            }
        }
        System.out.println();
    }
}
