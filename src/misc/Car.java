package misc;

public class Car {
    private String brand;
    private String model;
    private String number;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Car() {
        brand = "";
        model = "";
        number = "";
    }

    public Car(String brand, String model, String number) {
        this.brand = brand;
        this.model = model;
        this.number = number;
    }

    public void start() {
        System.out.println("Машина " + brand + " " + model + " завелась");
    }

    public void stop() {
        System.out.println("Машина " + brand + " " + model + " остановилась");
    }

    @Override
    public String toString() {
        return "{" + brand + ", " + model + ", " + number + "}";
    }
}
