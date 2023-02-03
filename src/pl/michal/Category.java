package pl.michal;

public class Category {
    private String name;
    private double value;

    public Category(String name) {
        this.name = name;
        this.value = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void increaseValue(double value) {
        this.value += value;
    }
}
