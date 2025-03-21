import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String name;
    double price;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    ArrayList<Stock> stocks = new ArrayList<>();
    
    public void buyStock(String name, double price) {
        stocks.add(new Stock(name, price));
        System.out.println("Bought: " + name + " at $" + price);
    }
    
    public void sellStock(String name) {
        stocks.removeIf(stock -> stock.name.equalsIgnoreCase(name));
        System.out.println("Sold: " + name);
    }
    
    public void viewPortfolio() {
        if (stocks.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }
        System.out.println("\nYour Portfolio:");
        for (Stock stock : stocks) {
            System.out.println(stock.name + " - $" + stock.price);
        }
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Portfolio portfolio = new Portfolio();
        
        while (true) {
            System.out.println("\n1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. View Portfolio");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter stock name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter stock price: ");
                    double price = scanner.nextDouble();
                    portfolio.buyStock(name, price);
                    break;
                case 2:
                    System.out.print("Enter stock name to sell: ");
                    String stockToSell = scanner.nextLine();
                    portfolio.sellStock(stockToSell);
                    break;
                case 3:
                    portfolio.viewPortfolio();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for trading!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
