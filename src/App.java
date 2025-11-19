import entity.Customer;
import entity.Vehicle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import service.BillingService;

public class App {
    public static void main(String[] args) throws SQLException {
        Scanner sc =new Scanner(System.in);
        BillingService service=new BillingService();

        while (true)
        {
            System.out.println("\n=== Garage Billing System ===");
            System.out.println("1. Add Customer with Vehicle");
            System.out.println("2. Show All Customers");
            System.out.println("3. Show All Vehicles");
            System.out.println("4. Generate Invoice");
            System.out.println("5. Show Invoices");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            String choiceLine = sc.nextLine();
            if(choiceLine==null || choiceLine.trim().isEmpty()) {
                continue;
            }
            int ch;
            try{
                ch = Integer.parseInt(choiceLine.trim());
            } catch(NumberFormatException e){
                System.out.println("Not a valid choice");
                continue;
            }
            switch (ch)
            {
                case 1:
                    System.out.print("Customer name: ");
                    String name = sc.next();
                    System.out.print("phone:");
                    String phone =sc.next();
                    service.customerService.addCustomer(new Customer(name,phone));
                    System.out.print("Enter Vehicle number plate: ");
                    String numberPlate=sc.next();
                    Customer customer = service.customerService.getCustomersBasesOnNum(phone);
                    service.vehicleService.addVehicle(new Vehicle(customer.getId(), numberPlate));
                    System.out.println("Customer and vehicle added successfully!");
                    sc.nextLine(); // consume leftover newline
                    break;

                case 2:
                    List<Customer> customers = service.customerService.getAllCustomers();
                    System.out.println("\n=== All Customers ===");
                    for(Customer c : customers) {
                        System.out.println(c);
                    }
                    break;
                    
                case 3:
                    List<Vehicle> vehicles = service.vehicleService.getAllVehicles();
                    System.out.println("\n=== All Vehicles ===");
                    for(Vehicle v : vehicles) {
                        System.out.println(v);
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter customer ID:");
                    int cid=sc.nextInt();
                    System.out.print("Enter vehicle Id:");
                    int vid = sc.nextInt();
                    System.out.println("Enter number of services:");
                    int n = sc.nextInt();
                    List<Integer> sids=new ArrayList<>();
                    for(int i=0;i<n;i++)
                    {
                        System.out.println("enter the service id:");
                        sids.add(sc.nextInt());
                    }
                    service.createInvoice(cid,vid,sids);
                    sc.nextLine(); // consume leftover newline
                    break;
                case 5:
                    service.showAllInvoices();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        }
    }
}