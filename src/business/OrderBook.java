package business;

import adt.List_ADT;

public class OrderBook {
    private List_ADT buy;
    private List_ADT sell;

    public OrderBook(){
        buy = new List_ADT();
        sell = new List_ADT();
    }

    public void add(User user, String mode, int qty, int price){
        if(mode.equalsIgnoreCase("B")){
            buy.add(new Order(user, price, qty));
        } else {
            sell.add(new Order(user, price, qty));
        }
    }

    public void add(String mode, Order o){
        if(mode.equalsIgnoreCase("B")){
            buy.add(o);
        } else {
            sell.add(o);
        }
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

    public Order match(String mode, int price){
        if(mode.equalsIgnoreCase("B")){
            for(int i = 0; i < sell.size(); i++){
                if (price > sell.get(i).getPrice()){
                    return sell.get(i);
                }
            }
        } else {
            for(int i = 0; i < buy.size(); i++){
                if (price < buy.get(i).getPrice()){
                    return buy.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        System.out.println("-----------------------------------------------");
        System.out.println("Buy -- Sell");

        // Find the maximum length between the two arrays
        int maxLength;
        if (buy.size() > sell.size()) {
            maxLength = buy.size();
        } else {
            maxLength = sell.size();
        }

        for (int i = 0; i < maxLength; i++) {
            String buyValue = "";
            String sellValue = "";

            // If 'i' is within the buy array length, get the value
            if (i < buy.size()) {
                buyValue = String.valueOf(buy.get(i));
            }

            // If 'i' is within the sell array length, get the value
            if (i < sell.size()) {
                sellValue = String.valueOf(sell.get(i));
            }

            System.out.println(buyValue + " -- " + sellValue);
        }

        return "-----------------------------------------------";
    }
    public List_ADT getBuy() {
        return buy;
    }

    public List_ADT getSell() {
        return sell;
    }
}
