package pl.michal;

public class Income implements FinancialOperation {
    private double value;
    private String category;
    private String date;
    private String note;

    public Income(double value, String category, String date, String description) {
        this.value = value;
        this.category = category;
        this.date = date;
        this.note = description;
    }

    public void displayInformations() {
        System.out.printf("+ %dz³\t%s\t%s\t%s\n", (int)value, category, date, note);
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
