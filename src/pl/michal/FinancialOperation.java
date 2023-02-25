package pl.michal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FinancialOperation {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private double value;
    private Category category;
    private LocalDate date;
    private String note;
    private OperationType type;

    public FinancialOperation(double value, Category category, LocalDate date, String description, OperationType type) {
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

    public LocalDate getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    public OperationType getType() {
        return type;
    }

    public String toString() {
        return String.format("%s%.2fzł * %s * %s * %s%s", value >= 0 ? ANSI_GREEN + "+" : ANSI_RED + "" ,value, category.getName(), date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), note, ANSI_RESET);
    }

}
