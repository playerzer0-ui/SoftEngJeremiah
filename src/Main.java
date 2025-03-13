import adt.HashTable_ADT;
import adt.List_ADT;
import business.OrderBook;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashTable_ADT x = new HashTable_ADT();
        x.addGame("fifa");
        x.addGame("elden ring");
        x.addGame("dark");

        x.listGames();
        x.addGame("fifa");
    }
}