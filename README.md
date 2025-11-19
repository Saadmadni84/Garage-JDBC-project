# Garage Billing System

A Java-based console application for managing garage operations including customer management, vehicle registration, and invoice generation using JDBC and MySQL.

## Features

- **Customer Management**: Add and view customer information
- **Vehicle Management**: Register vehicles linked to customers
- **Invoice Generation**: Create invoices for services provided to vehicles
- **Data Persistence**: All data stored in MySQL database

## Technologies Used

- **Java**: Core programming language
- **JDBC**: Database connectivity
- **MySQL**: Relational database
- **MySQL Connector/J 9.1.0**: JDBC driver

## Project Structure

```
GarageBillingSystem/
├── src/
│   ├── App.java                    # Main application entry point
│   ├── Main.java                   # Placeholder class
│   ├── config/
│   │   └── DbConfig.java          # Database configuration
│   ├── entity/
│   │   ├── Customer.java          # Customer entity
│   │   ├── Vehicle.java           # Vehicle entity
│   │   └── Invoice.java           # Invoice entity
│   └── service/
│       ├── BillingService.java    # Business logic for billing
│       ├── CustomerService.java   # Customer CRUD operations
│       ├── VehicleService.java    # Vehicle CRUD operations
│       └── InvoiceService.java    # Invoice CRUD operations
├── lib/
│   └── mysql-connector-j-9.1.0.jar
└── out/                           # Compiled classes
```

## Database Schema

The application uses a MySQL database named `grage` with the following tables:

### customers
- `id` (INT, Primary Key, Auto Increment)
- `name` (VARCHAR)
- `phone` (VARCHAR)

### vehicle
- `id` (INT, Primary Key, Auto Increment)
- `customer_id` (INT, Foreign Key)
- `number_plate` (VARCHAR)

### invoices
- `id` (INT, Primary Key, Auto Increment)
- `customer_id` (INT, Foreign Key)
- `vehicle_id` (INT, Foreign Key)
- `service_id` (INT, Foreign Key)

### services
- `id` (INT, Primary Key)
- Service details (varies based on schema)

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server 5.7 or higher
- MySQL database named `grage` with appropriate schema

## Setup Instructions

### 1. Database Setup

```sql
CREATE DATABASE grage;
USE grage;

CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE vehicle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    number_plate VARCHAR(15),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE services (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    price DECIMAL(10,2)
);

CREATE TABLE invoices (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    vehicle_id INT,
    service_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(id),
    FOREIGN KEY (service_id) REFERENCES services(id)
);
```

### 2. Configure Database Connection

Update `src/config/DbConfig.java` with your MySQL credentials:

```java
private static final String URL="jdbc:mysql://localhost:3306/grage";
private static final String USER="your_username";
private static final String PASS="your_password";
```

### 3. Compile the Project

```bash
cd "/path/to/GarageBillingSystem"
javac -cp "lib/*" -d out src/**/*.java src/*.java
```

### 4. Run the Application

```bash
java -cp "out:lib/*" App
```

**Note for Windows users**: Replace `:` with `;` in the classpath:
```bash
java -cp "out;lib/*" App
```

## Usage

### Main Menu

```
=== Garage Billing System ===
1. Add Customer with Vehicle
2. Show All Customers
3. Show All Vehicles
4. Generate Invoice
5. Show Invoices
6. Exit
```

### Workflow

1. **Add Customer with Vehicle**: 
   - Enter customer name and phone number
   - Enter vehicle number plate
   - Customer and vehicle are automatically linked

2. **View Customers/Vehicles**:
   - Use options 2 and 3 to view existing records
   - Note the IDs for invoice generation

3. **Generate Invoice**:
   - Select option 4
   - Enter customer ID (from option 2)
   - Enter vehicle ID (from option 3)
   - Enter number of services
   - Enter each service ID

4. **View Invoices**:
   - Select option 5 to see all generated invoices

## Sample Data

Insert sample services:

```sql
INSERT INTO services (id, name, price) VALUES
(1, 'Oil Change', 50.00),
(2, 'Tire Rotation', 30.00),
(3, 'Brake Inspection', 40.00),
(4, 'Engine Tune-up', 150.00),
(5, 'Car Wash', 20.00);
```

## Common Issues

### "No suitable driver found" Error
- Ensure `mysql-connector-j-9.1.0.jar` is in the `lib/` directory
- Include the library in the classpath when running

### Foreign Key Constraint Violations
- Always add a customer before adding a vehicle
- Use options 2 and 3 to verify IDs before generating invoices

### Scanner Input Issues
- The application handles newline consumption automatically
- Press Enter after each input

## Future Enhancements

- Service pricing and total calculation
- Invoice date tracking
- Update and delete operations
- Search functionality
- GUI interface
- Report generation (PDF/Excel)
- Authentication and authorization

## Author

Saad Madni

## License

This project is for educational purposes.
