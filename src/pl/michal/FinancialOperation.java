package pl.michal;

public class FinancialOperation {
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
            System.out.printf("+%.2fzł * %s * %s * %s\n", value, category.getName(), date, note);
        } else if (type.equals(operationType.Expense)){
            System.out.printf("%.2fzł * %s * %s * %s\n", value, category.getName(), date, note);
        }
    }

}
