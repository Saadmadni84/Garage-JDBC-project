package service;

import entity.Invoice;
import java.sql.SQLException;
import java.util.List;

public class BillingService {
    public CustomerService customerService=new CustomerService();
    public InvoiceService invoiceService=new InvoiceService();
    public VehicleService vehicleService=new VehicleService();

    public void createInvoice(int customerId, int vehicleId, List<Integer> serviceIds) throws SQLException
    {
        // Create one invoice row per service id
        for (int serviceId : serviceIds) {
            invoiceService.addInvoice(new Invoice(0, customerId, vehicleId, serviceId));
        }
        System.out.println("Invoice(s) generated successfully...");
    }

    public void showAllInvoices() throws SQLException
    {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        for(Invoice invoice:invoices)
        {
            System.out.println(invoice);
        }
    }
}
