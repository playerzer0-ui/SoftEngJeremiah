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
        } else if (mode.equalsIgnoreCase("S")) {
            sell.add(new Order(user, price, qty));
        }
    }

    public Order match(String mode, int price){
        if(mode.equalsIgnoreCase("B")){
            for(int i = 0; i < sell.size(); i++){
                if (price > sell.get(i).getPrice()){
                    return sell.get(i);
                }
            }
        } else if (mode.equalsIgnoreCase("S")) {
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
}
