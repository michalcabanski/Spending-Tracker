package pl.michal;

public class FinancialOperation {
    private double value;
    private String category;
    private String date;
    private String note;
    private operationType type;

    public FinancialOperation(double value, String category, String date, String description, operationType type) {
        this.value = value;
        this.category = category;
        this.date = date;
        this.note = description;
        this.type = type;
    }

    public void displayInformations() {
        if (type == operationType.Income) {
            System.out.printf("+ %.2fzł * %s * %s * %s\n", value, category, date, note);
        } else if (type == operationType.Expense) {
            System.out.printf("- %.2fzł * %s * %s * %s\n", value, category, date, note);
        }
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public operationType getType() {
        return type;
    }
}
