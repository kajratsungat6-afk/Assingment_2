public abstract class Vehicle {
    protected int id;
    protected static int idGen = 1;

    protected String model;
    protected int year;
    protected double basePrice;

    public Vehicle(String model, int year, double basePrice) {
        this.id = idGen++;
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    // getters
    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // setters with validation
    public void setModel(String model) {
        if (model != null && !model.isEmpty()) {
            this.model = model;
        } else {
            this.model = "Unknown";
        }
    }

    public void setYear(int year) {
        if (year > 1950 && year <= 2026) {
            this.year = year;
        } else {
            this.year = 2000;
        }
    }

    public void setBasePrice(double basePrice) {
        if (basePrice > 0) {
            this.basePrice = basePrice;
        } else {
            this.basePrice = 1000;
        }
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return "ID: " + id +
                ", Model: " + model +
                ", Year: " + year +
                ", Base price: " + basePrice;
    }
}
