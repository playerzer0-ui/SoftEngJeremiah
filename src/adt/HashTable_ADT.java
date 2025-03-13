package adt;

import business.OrderBook;

public class HashTable_ADT {
    private static final int SIZE = 30;
    private GameEntry[] table;

    private static class GameEntry {
        String gameName;
        OrderBook orderBook;
        GameEntry next;

        GameEntry(String gameName) {
            this.gameName = gameName;
            this.orderBook = new OrderBook();
            this.next = null;
        }
    }

    public HashTable_ADT() {
        table = new GameEntry[SIZE];
    }

    private int hash(String key) {
        int hash = key.hashCode();
        hash = Math.abs(hash);
        hash = hash % SIZE;
        return Math.abs(hash);
    }


    public void addGame(String gameName) {
        int index = hash(gameName);
        GameEntry newEntry = new GameEntry(gameName);

        if (table[index] == null) {
            table[index] = newEntry;
            return;
        }

        GameEntry current = table[index];
        if (current.gameName.equalsIgnoreCase(gameName)) return;

        while (current.next != null) {
            if (current.next.gameName.equalsIgnoreCase(gameName)) return;
            current = current.next;
        }

        current.next = newEntry;
    }


    public OrderBook getGame(String gameName) {
        int index = hash(gameName);
        GameEntry current = table[index];

        while (current != null) {
            if (current.gameName.equalsIgnoreCase(gameName)) {
                return current.orderBook;
            }
            current = current.next;
        }
        return null;
    }

    public void removeGame(String gameName) {
        int index = hash(gameName);
        GameEntry current = table[index];
        GameEntry prev = null;

        while (current != null) {
            if (current.gameName.equalsIgnoreCase(gameName)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void listGames() {
        int num = 1;
        System.out.println("Available Games:");
        for (int i = 0; i < SIZE; i++) {
            GameEntry current = table[i];
            while (current != null) {
                System.out.println((num++) + ". " + current.gameName);
                current = current.next;
            }
        }
    }
}

