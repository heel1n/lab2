package CarPackage;

public class Car {
    private int id;
    private String model;
    private int release;
    private int price;
    private int number;

    public Car(int id, String model, int release, int price, int number) {
        this.id = id;
        this.model = model;
        this.release = release;
        this.price = price;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Model: " + model + ", Release: " + release
                + ", Price: " + price + ", Number: " + number;
    }
}
