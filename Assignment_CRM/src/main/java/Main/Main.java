package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Address;

import Service.CustomerService;
import Service.LeadService;
import Service.OrderService;
import Service.ProductService;
import Service.ReportService;
import Service.TicketService;

public class Main {

    public static void main(String[] args) {

        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        
        EntityManager em = emf.createEntityManager();

        
        Scanner sc = new Scanner(System.in);

       
        CustomerService customerService = new CustomerService(em);
        LeadService leadService = new LeadService(em);
        ProductService productService = new ProductService(em);
        OrderService orderService = new OrderService(em);
        TicketService ticketService = new TicketService(em);
        ReportService reportService = new ReportService(em);

        boolean running = true;

        
        while (running) {

            System.out.println("\n===== CRM SALES MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address to Customer");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead to Employee");
            System.out.println("5. Convert Lead to Customer");
            System.out.println("6. Add Product");
            System.out.println("7. Place Order");
            System.out.println("8. Raise Support Ticket");
            System.out.println("9. View Employee Performance");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    customerService.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    Long custId = sc.nextLong();
                    sc.nextLine();

                    Address address = new Address();

                    System.out.print("Street: ");
                    address.setStreet(sc.nextLine());

                    System.out.print("City: ");
                    address.setCity(sc.nextLine());

                    System.out.print("State: ");
                    address.setState(sc.nextLine());

                    System.out.print("Zip Code: ");
                    address.setZipCode(sc.nextLine());

                    customerService.addAddressToCustomer(custId, address);
                    break;

                case 3:
                    System.out.print("Lead Name: ");
                    String leadName = sc.nextLine();

                    System.out.print("Source: ");
                    String source = sc.nextLine();

                    System.out.print("Contact Info: ");
                    String contact = sc.nextLine();

                    leadService.createLead(leadName, source, contact);
                    break;

                case 4:
                    System.out.print("Lead ID: ");
                    Long leadId = sc.nextLong();

                    System.out.print("Employee ID: ");
                    Long empId = sc.nextLong();
                    sc.nextLine();

                    leadService.assignLeadToEmployee(leadId, empId);
                    break;

                case 5:
                    System.out.print("Lead ID to Convert: ");
                    Long convertId = sc.nextLong();
                    sc.nextLine();

                    leadService.convertLeadToCustomer(convertId);
                    break;

                case 6:
                    System.out.print("Product Name: ");
                    String productName = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    productService.addProduct(productName, price);
                    break;

                case 7:
                    System.out.print("Customer ID: ");
                    Long orderCustId = sc.nextLong();

                    System.out.print("How many products? ");
                    int count = sc.nextInt();

                    List<Long> productIds = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter Product ID: ");
                        productIds.add(sc.nextLong());
                    }
                    sc.nextLine();

                    orderService.placeOrder(orderCustId, productIds);
                    break;

                case 8:
                    System.out.print("Order ID: ");
                    Long orderId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Issue Description: ");
                    String issue = sc.nextLine();

                    ticketService.raiseTicket(orderId, issue);
                    break;

                case 9:
                    System.out.print("Employee ID: ");
                    Long employeeId = sc.nextLong();
                    sc.nextLine();

                    reportService.getEmployeePerformance(employeeId);
                    break;

                case 10:
                    running = false;
                    System.out.println("Exiting CRM Application...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        
        sc.close();
        em.close();
        emf.close();
    }
}
