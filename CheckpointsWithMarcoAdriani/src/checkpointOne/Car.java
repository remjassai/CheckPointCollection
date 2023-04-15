package checkpointOne;

public class Car {
    private static int counterId = 0;
    private int id;
    private String targa;
    private String model;
    private String brand;
    private double price;
    private int kmPerLiter;
    private boolean isElectric;

    public Car(String targa, String model, String brand, double price, int kmPerLiter, boolean isElectric) {
        this.id = ++counterId;
        this.model = model;
        this.targa = targa;
        this.brand = brand;
        this.price = price;
        this.kmPerLiter = kmPerLiter;
        this.isElectric = isElectric;
    }

    public Car(String targa, String model, String brand) {
        this.targa = targa;
        this.model = model;
        this.brand = brand;
    }

    //Getters


    public int getId() {
        return id;
    }

    public String getTarga() {
        return targa;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getKmPerLiter() {
        return kmPerLiter;
    }

    public boolean getIsElectric() {
        return isElectric;
    }

    //Setters


    public void setPrice(double price) {
        this.price = price;
    }

    //Methods

    public boolean isGreen() {
        if (this.isElectric || this.kmPerLiter > 20) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", targa='" + targa + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", kmPerLiter=" + kmPerLiter +
                ", isElectric=" + isElectric +
                '}';
    }
}
