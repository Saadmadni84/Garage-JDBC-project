package entity;

public class Invoice {
    private int id;
    private int cutomerId;
    private int vehicleId;
    private int serviceId;

    public Invoice(int id, int cutomerId, int vehicleId, int serviceId) {
        this.id = id;
        this.cutomerId = cutomerId;
        this.vehicleId = vehicleId;
        this.serviceId = serviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCutomerId() {
        return cutomerId;
    }

    public void setCutomerId(int cutomerId) {
        this.cutomerId = cutomerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "Invoice [ " +
                "id =" + id +
                ", cutomerId =" + cutomerId +
                ", vehicleId =" + vehicleId +
                ", serviceId =" + serviceId + " ]";
    }
}
