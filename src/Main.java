import adt.HashTable_ADT;
import adt.UserList_ADT;
import business.Order;
import business.OrderBook;
import business.User;

import java.util.Scanner;

public class Main {
    private static HashTable_ADT market = new HashTable_ADT();
    private static UserList_ADT users = new UserList_ADT();
    private static final User alice = new User("Alice");
    private static final User bob = new User("Bob");
    private static final User charlie = new User("Charlie");

    private static String gameName = "";
    private static OrderBook book = null;
    private static User user = null;

    private static boolean isLogged = false;
    private static boolean session = true;
    private static String choice = "";

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Initialize();

        while(session){
            if(!isLogged){
                displaySession();
            }

            while (isLogged){
                displayGames();
            }
        }
    }

    public static void displaySession(){
        System.out.println("1. login");
        System.out.println("2. GOODBYE");
        System.out.println("type in a number to proceed");
        choice = sc.nextLine();

        switch (choice){
            case "1":
                System.out.println("insert username: ");
                choice = sc.nextLine();
                user = new User(choice);
                if(users.contains(user)){
                    System.out.println("logged in, welcome: " + choice);
                    isLogged = true;
                }
                else{
                    System.out.println("invalid username");
                }
                break;

            case "2":
                System.out.println("see you next time");
                session = false;
                break;

            default:
                System.out.println("invalid command");
                break;
        }
    }

    public static void displayGames(){
        market.listGames();
        System.out.println("select a game to view and make orders (type in game name)");
        System.out.println("type in 99 to logout");

        choice = sc.nextLine();

        book = market.getGame(choice);
        if(book != null){
            gameName = choice;
            gameOrderMenu();
        }
        else if(choice.equalsIgnoreCase("99")){
            System.out.println("Logged out");
            isLogged = false;
        }
        else{
            System.out.println("invalid command");
        }

        choice = null;
    }

    public static void gameOrderMenu(){
        Order o;

        System.out.println(gameName);
        System.out.println(book);
        System.out.println("1. create buy order");
        System.out.println("2. create sell order");
        choice = sc.nextLine();

        switch (choice){
            case "1":
                o = createOrder();
                matchOrder("B", o);
                break;

            case "2":
                o = createOrder();
                matchOrder("S", o);
                break;

            default:
                System.out.println("invalid command");
                break;
        }
    }

    public static Order createOrder(){
        int qty;
        int price;

        System.out.println("insert qty: ");
        qty = sc.nextInt();
        sc.nextLine();
        System.out.println("insert price");
        price = sc.nextInt();
        sc.nextLine();

        return new Order(user, price, qty);
    }

    public static void matchOrder(String mode, Order order) {
        Order found = book.match(mode, order.getPrice());

        if (found != null) {
            System.out.println("Found order:");
            System.out.println(found.viewOrder());
            System.out.println(order.getUser().getUsername() + " has matched an order with " + found.getUser().getUsername());

            boolean reduced = book.reduce(mode, order); // Reduce the new order (not the found one)

            if (reduced) {
                System.out.println(order.getUser().getUsername() + "'s order processed successfully.");
            }
        } else {
            System.out.println("No matching order found. Adding to book.");
            book.add(mode, order);
        }
        book.getBuy().sort();
        book.getSell().sort();
    }

    public static void Initialize(){
        market.addGame("fifa");
        market.addGame("elden ring");
        market.addGame("dark");

        OrderBook book = market.getGame("fifa");
        book.add(alice,"B", 10, 100);
        book.add(bob, "B", 11, 200);
        book.add(charlie, "B", 12, 300);
        book.add(charlie, "B", 13, 400);

        users.add(alice);
        users.add(bob);
        users.add(charlie);
    }
}