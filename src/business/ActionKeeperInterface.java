package business;

public interface ActionKeeperInterface {
    public boolean isIsLogged();
    public boolean isSession();
    public void displaySession();
    public void displayGames();
    public  void gameOrderMenu();
    public Order createOrder();
    public void matchOrder(String mode, Order order);
    public void Initialize();
}
