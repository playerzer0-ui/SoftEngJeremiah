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

    public User getUser() {
        return user;
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

    public String viewOrder(){
        return user.getUsername() + ": " + this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return price == order.price && quantity == order.quantity && user.equals(order.user);
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + quantity;
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return price + " (" + quantity + ")";
    }
}

