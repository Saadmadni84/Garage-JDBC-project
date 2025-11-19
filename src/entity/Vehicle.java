package entity;

public class Vehicle {
    private int id;
    private int customerId;
    private String numberPlate;

    public Vehicle() {
    }

    public Vehicle(int customerId, String numberPlate) {
        this.customerId = customerId;
        this.numberPlate = numberPlate;
    }

    public Vehicle(int id, int customerId, String numberPlate) {
        this.id = id;
        this.customerId = customerId;
        this.numberPlate = numberPlate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return "Vehicle [ id=" + id + ", customerId=" + customerId + 
               ", numberPlate=" + numberPlate + " ]";
    }
}
