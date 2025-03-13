package business;

public class Order {
    int price;
    int quantity;
    User user;

    public Order(User user, int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return price + " (" + quantity + ")";
    }
}

