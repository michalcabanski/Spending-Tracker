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

    public String toString() {
        return String.format("%s%.2fzł * %s * %s * %s%s", value >= 0 ? ANSI_GREEN + "+" : ANSI_RED + "" ,value, category.getName(), date, note, ANSI_RESET);
    }

}
