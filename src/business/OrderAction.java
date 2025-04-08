package business;

import adt.List_ADT;

public class OrderAction {
    private volatile static OrderAction uniqueInstance;
    private List_ADT buy;
    private List_ADT sell;
    private OrderAction(List_ADT buy, List_ADT sell) {
       this.buy = buy;
       this.sell = sell;
    }
    public static OrderAction getInstance(List_ADT buy, List_ADT sell) {
        if(uniqueInstance==null){
            synchronized (OrderAction.class){
                if(uniqueInstance==null){
                    uniqueInstance= new OrderAction(buy,sell);
                }
            }
        }
        return uniqueInstance;
    }

    public boolean reduce(String mode, Order o) {
        List_ADT bookToCheck;
        boolean isBuying = mode.equalsIgnoreCase("B");

        // If buying, check sell orders; if selling, check buy orders
        bookToCheck = isBuying ? sell : buy;

        int remainingQty = o.getQuantity();
        int price = o.getPrice();
        int completedOrders = 0; // Count fully matched orders

        for (int i = 0; i < bookToCheck.size(); i++) {
            Order match = bookToCheck.get(i);

            // Ensure the order meets the match criteria
            if ((isBuying && price >= match.getPrice()) || (!isBuying && price <= match.getPrice())) {
                if (match.getQuantity() > remainingQty) {
                    // Partial fulfillment: Reduce match's quantity
                    match.setQuantity(match.getQuantity() - remainingQty);
                    System.out.println("Partial match: " + match.getUser().getUsername() + " now has " + match.getQuantity() + " remaining.");
                    remainingQty = 0;
                    break; // Order fully processed, stop
                } else {
                    // Full fulfillment: Remove matched order
                    remainingQty -= match.getQuantity();
                    bookToCheck.remove(i);
                    i--; // Adjust index due to removal
                    completedOrders++; // Track fully completed orders

                    System.out.println("Order completed for " + match.getUser().getUsername());

                    // If order is fully processed, stop
                    if (remainingQty == 0) {
                        break;
                    }
                }
            }
        }

        // Print final count if any orders were completed
        if (completedOrders > 0) {
            System.out.println("Total orders fully completed: " + completedOrders);
        }

        // If the input order still has remaining quantity, add it back to the book
        if (remainingQty > 0) {
            System.out.println("Remaining quantity of " + remainingQty + " added back to the book.");
            o.setQuantity(remainingQty);
            if(isBuying){
              buy.add(o);
            }
            else{
                sell.add(o);
            }
        }

        return completedOrders > 0;
    }

    public List_ADT getBuy() {
        return buy;
    }

    public void setBuy(List_ADT buy) {
        this.buy = buy;
    }

    public List_ADT getSell() {
        return sell;
    }

    public void setSell(List_ADT sell) {
        this.sell = sell;
    }
}
