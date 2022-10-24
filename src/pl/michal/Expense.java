package pl.michal;

public class Expense implements FinancialOperation {
    private double value;
    private String category;
    private String date;
    private String note;

    public Expense(double value, String category, String date, String description) {
        this.value = value;
        this.category = category;
        this.date = date;
        this.note = description;
    }

    public void displayInformations() {
        System.out.printf("- %.2fz³\t%s\t%s\t%s\n", value, category, date, note);
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }
}
