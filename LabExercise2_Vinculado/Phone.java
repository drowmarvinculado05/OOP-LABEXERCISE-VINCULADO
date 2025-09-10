public class Cellphone {
    private String brand;
    private String model;
    private String imeiNumber;
    private String color;     
    private int storage;   // in GB  

    // Default constructor
    public Cellphone() {
        this.brand = "No Brand";
        this.model = "No Model";
        this.imeiNumber = "No IMEI Yet!";
        this.color = "No Color";
        this.storage = 0; // default storage
    }

    // Constructor with arguments
    public Cellphone(String brand, String model, String imeiNumber, String color, int storage) {
        this.brand = brand;
        this.model = model;
        this.imeiNumber = imeiNumber;
        this.color = color;
        this.storage = storage;
    }

    // Display info method
    public void displayInfo() {
        String info = "";
        info += "Brand: " + this.brand;
        info += "\nModel: " + this.model;
        info += "\nIMEI Number: " + this.imeiNumber;
        info += "\nColor: " + this.color;
        info += "\nStorage (GB): " + this.storage;
        System.out.println(info);
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        // Using default constructor
        Cellphone defaultPhone = new Cellphone();
        System.out.println("=== Default Cellphone ===");
        defaultPhone.displayInfo();

        // Using parameterized constructor (Realme 7)
        Cellphone realme7 = new Cellphone("Realme", "Realme 7", "IMEI778899112233", "Mist Blue", 128);
        System.out.println("\n=== Custom Cellphone ===");
        realme7.displayInfo();
    }
          }
