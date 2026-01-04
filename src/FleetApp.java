import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new FleetApp().run();
    }

    public void run() {
        int choice;

        do {
            System.out.println("\nFleet Management System");
            System.out.println("1. Print all vehicles");
            System.out.println("2. Add new car");
            System.out.println("3. Add new bus");
            System.out.println("4. Show total yearly insurance fees");
            System.out.println("5. Show vehicles older than N years");
            System.out.println("6. Perform service for all vehicles");
            System.out.println("7. Quit");

            System.out.print("Choose option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printAllVehicles();
                    break;
                case 2:
                    addNewCar();
                    break;
                case 3:
                    addNewBus();
                    break;
                case 4:
                    showTotalInsuranceFees();
                    break;
                case 5:
                    showVehiclesOlderThan();
                    break;
                case 6:
                    performServiceForAll();
                    break;
                case 7:
                    System.out.println("Application closed.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles");
            return;
        }

        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void addNewCar() {
        System.out.print("Model: ");
        String model = scanner.next();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Number of doors: ");
        int doors = scanner.nextInt();

        Car car = new Car(model, year, price, doors);
        vehicles.add(car);

        System.out.println("Car added successfully.");
    }

    private void addNewBus() {
        System.out.print("Model: ");
        String model = scanner.next();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("Base price: ");
        double price = scanner.nextDouble();

        System.out.print("Passenger capacity: ");
        int capacity = scanner.nextInt();

        Bus bus = new Bus(model, year, price, capacity);
        vehicles.add(bus);

        System.out.println("Bus added successfully.");
    }

    private void showTotalInsuranceFees() {
        double total = 0;

        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }

        System.out.println("Total yearly insurance fees: " + total);
    }

    private void showVehiclesOlderThan() {
        System.out.print("Enter current year: ");
        int currentYear = scanner.nextInt();

        System.out.print("Enter N (years): ");
        int n = scanner.nextInt();

        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
            }
        }
    }

    private void performServiceForAll() {
        for (Vehicle v : vehicles) {
            if (v instanceof Servicable s) {
                s.performService();
            }
        }
    }
}
