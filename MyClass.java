package lab2OOP;
import CarPackage.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();

        // Створення об'єктів автомобілів
        cars = createCar(scanner);

        // Виведення всіх автомобілів
        printAllCars(cars);

        // a) Список автомобілів заданої моделі
        searchByModel(scanner, cars);

        // b) Список автомобілів, які експлуатуються більше n років
        searchByYearsInUse(scanner, cars);

        // c) Список автомобілів заданого року випуску, ціна яких більше вказаної
        searchByReleaseAndPrice(scanner, cars);
    }

    // Створення масиву об'єктів автомобілів
    public static List<Car> createCar(Scanner scanner) {
        List<Car> cars = new ArrayList<>();

        System.out.println("Enter the number of cars to add: ");
        int numCar = scanner.nextInt();
        if (numCar > 0) {
            scanner.nextLine(); // щоб правильно зчитати рядки після введення числа
        } else {
            System.out.println("Number of cars must be greater than 0.");
            return cars;
        }

        for (int i = 0; i < numCar; i++) {
            System.out.println("Enter information for car " + (i + 1) + ": ");

            System.out.println("Enter the ID of the car: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the model of the car: ");
            String model = scanner.nextLine();

            System.out.println("Enter the release year of the car: ");
            int release = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the price of the car: ");
            int price = scanner.nextInt();
            scanner.nextLine();

            // Автоматично встановлюємо номер автомобіля на основі його порядку
            int number = i + 1;

            Car car = new Car(id, model, release, price, number);
            cars.add(car);
        }

        return cars;
    }


    // Виведення всіх автомобілів
    public static void printAllCars(List<Car> cars) {
        System.out.println("\nAll cars:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    // a) Список автомобілів заданої моделі
    public static void searchByModel(Scanner scanner, List<Car> cars) {
        System.out.println("\nEnter the model to search for:");
        String searchModel = scanner.nextLine();
        boolean found = false;

        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(searchModel)) {
                found = true;
                System.out.println("Cars with model '" + searchModel + "': " + car);
            }
        }

        if (!found) {
            System.out.println("There are no cars with model " + searchModel + ".");
        }
    }

    // b) Список автомобілів, які експлуатуються більше n років
    public static void searchByYearsInUse(Scanner scanner, List<Car> cars) {
        System.out.println("\nEnter the number of years the car has been in use:");
        int yearsInUse = scanner.nextInt();
        boolean found = false;

        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        for (Car car : cars) {
            int carAge = currentYear - car.getRelease();
            if (carAge > yearsInUse) {
                found = true;
                System.out.println("Cars in use for more than " + yearsInUse + " years: " + car);
            }
        }

        if (!found) {
            System.out.println("No cars in use for more than " + yearsInUse + " years.");
        }
    }

    // c) Список автомобілів заданого року випуску, ціна яких більше вказаної
    public static void searchByReleaseAndPrice(Scanner scanner, List<Car> cars) {
        System.out.println("\nEnter the release year to search for:");
        int releaseYear = scanner.nextInt();
        System.out.println("Enter the minimum price to search for:");
        int minPrice = scanner.nextInt();
        boolean found = false;

        for (Car car : cars) {
            if (car.getRelease() == releaseYear && car.getPrice() > minPrice) {
                found = true;
                System.out.println("Cars from year " + releaseYear + " with price over " + minPrice + ": " + car);
            }
        }

        if (!found) {
            System.out.println("No cars found for the given year and price.");
        }
    }
    
    public static double calculateAveragePriceFor20YearsAgo(List<Car> cars) {
    	int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    	int targetYear = currentYear - 20;
    	
    	int totalPrice = 0;
    	int count = 0;
    	
    	
    	
    	for (Car car : cars) {
    		if (car.getRelease() == targetYear) {
    			totalPrice += car.getPrice();
    			count++;
    		}
    	}
    	
    	
    	return (count > 0) ? (double) totalPrice / count : 0.0;
    	
    }
     
    
    
    
    
}






