package pl.michal;

import java.time.LocalDate;
import java.util.*;

import static pl.michal.operationType.Expense;
import static pl.michal.operationType.Income;

public class SpendingTracker {
    private double balance;
    private List<FinancialOperation> operations = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addCategory(String name) {
        Category category = new Category(name);
        categories.add(category);
    }

    public void showCategories() {
        System.out.println("Dostępne kategorie:");
        for (Category category : categories)  {
            System.out.println(1 + categories.indexOf(category) + ". " + category.getName());
        }
    }

    public void menageCategories() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            showCategories();
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Dodaj kategorię");
            System.out.println("2. Zmień nazwę kategorii");
            System.out.println("3. Wróć");

            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                switch (userChoice) {
                    case 1 -> {
                        System.out.print("Podaj nazwę: ");
                        String name = scanner.nextLine();
                        addCategory(name);
                    }
                    case 2 -> {
                        System.out.print("Wybierz kategorię po numerze: ");
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        System.out.print("Podaj nową nazwę: ");
                        String name = scanner.nextLine();
                        categories.get(index).setName(name);
                    }
                    case 3 -> shouldContinue = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Podaj liczbę!");
            }
        }
    }

    public void setAccountBalance() {
        System.out.print("Podaj stan konta w zł: ");
        this.balance = Double.parseDouble(scanner.nextLine());
    }

    public void showAccountBalance() {
        System.out.printf("Stan konta: %.2fzł\n", balance);
    }

    public void addFinancialOperation(operationType type) {
        System.out.print("Podaj kwotę w zł: ");
        double value = Math.abs(Double.parseDouble(scanner.nextLine()));
        value *= type.equals(Expense) ? -1 : 1;
        Category category = chooseCategory();
        LocalDate date = LocalDate.now();
        System.out.print("Dodaj opis (opcjonalnie): ");
        String description = scanner.nextLine();
        FinancialOperation financialOperation = new FinancialOperation(value, category, date, description, type);
        operations.add(financialOperation);
        balance += value;
        category.increaseValue(value);
    }

    public void showFinancialOperations() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Wszystkie operacje");
            System.out.println("2. Wydatki");
            System.out.println("3. Przychody");
            System.out.println("4. Operacje dla wybranej kategorii");
            System.out.println("5. Wróć");

            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                switch (userChoice) {
                    case 1 -> operations.forEach(System.out::println);
                    case 2 -> {
                        operations.stream()
                                .filter(operation -> operation.getType().equals(Expense))
                                .forEach(System.out::println);
                    }
                    case 3 -> {
                        operations.stream()
                                .filter(operation -> operation.getType().equals(Income))
                                .forEach(System.out::println);
                    }
                    case 4 -> {
                        Category category = chooseCategory();
                        operations.stream()
                                .filter(operation -> operation.getCategory().equals(category))
                                .forEach(System.out::println);
                    }
                    case 5 -> shouldContinue = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Podaj liczbę!");
            }
        }
    }

    private Category chooseCategory() {
        showCategories();
        System.out.print("Wybierz kategorię po numerze: ");
        Category category = null;
        boolean isMatching = false;
        while (!isMatching){
            try {
                int index = Integer.parseInt(scanner.nextLine());
                category = categories.get(index - 1);
                isMatching = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.print("Wybierz dostępny numer: ");
            } catch (NumberFormatException e) {
                System.out.print("Podaj liczbę: ");
            }
        }
        return category;
    }
}
