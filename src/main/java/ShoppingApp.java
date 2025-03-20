import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingApp {

    public double totalCost = 0;
    private ResourceBundle rb;
    private Locale locale;

    public void start() {

        Locale locale;
        System.out.println("Press 1 for English, 2 for Finnish, 3 for Swedish, 4 for Japanese");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        ResourceBundle rb;
        switch (choice) {
            case 1:
                locale = new Locale("en", "US");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
            case 4:
                locale = new Locale("ja", "JP");
                break;
            default:
                locale = new Locale("en", "US");
        }
        try {
            rb = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        }

        System.out.println(rb.getString("numberOfItems"));
        int numberOfItems = scanner.nextInt();
        for (int i = 0; i < numberOfItems; i++) {
            System.out.println(rb.getString("item") + " " + (i + 1));
            System.out.println(rb.getString("price"));
            double price = scanner.nextDouble();
            System.out.println(rb.getString("quantity"));
            int quantity = scanner.nextInt();
            addToTotalCost(price * quantity);
        }
        System.out.println(rb.getString("total") + " " + totalCost);
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void addToTotalCost(double amount) {
        totalCost += amount;
    }
}
