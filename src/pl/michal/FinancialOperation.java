package pl.michal;

public class FinancialOperation {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private double value;
    private Category category;
    private String date;
    private String note;
    private operationType type;

    public FinancialOperation(double value, Category category, String date, String description, operationType type) {
        this.value = value;
        this.category = category;
        this.date = date;
        this.note = description;
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public Category getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    public operationType getType() {
        return type;
    }

    public void showInformation() {
        if (type.equals(operationType.Income)) {
            System.out.printf("%s+%.2fzł * %s * %s * %s%s\n", ANSI_GREEN, value, category.getName(), date, note, ANSI_RESET);
        } else if (type.equals(operationType.Expense)){
            System.out.printf("%s%.2fzł * %s * %s * %s%s\n", ANSI_RED, value, category.getName(), date, note, ANSI_RESET);
        }
    }

}
