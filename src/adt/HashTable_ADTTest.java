package adt;

import business.OrderBook;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HashTable_ADTTest {
    public HashTable_ADTTest() {
    }
    HashTable_ADT gameTable;

    /**
     * Test of addGame_NewGame , of class HashTable_ADT.
     */
    @Test
    public void testAddGame_NewGame() {
        System.out.println("addGame_NewGame");
        gameTable = new HashTable_ADT();
        gameTable.addGame("Overcooked");

        assertTrue(gameTable.contains("Overcooked"));
    }

    /**
     * Test of addGame_DuplicateGame, of class HashTable_ADT.
     */
    @Test
    public void testAddGame_DuplicateGame() {
        System.out.println("addGame_DuplicateGame");
        gameTable = new HashTable_ADT();

        gameTable.addGame("Card2024");
        gameTable.addGame("Card2024");

        assertEquals(1, gameTable.getSize());
    }

    /**
     * Test of getGame_ExistingGame, of class HashTable_ADT.
     */
    @Test
    public void testGetGame_ExistingGame() {
        System.out.println("getGame_ExistingGame");
        gameTable = new HashTable_ADT();

        gameTable.addGame("Overcooked");
        OrderBook result = gameTable.getGame("Overcooked");

        assertNotNull(result);
    }

    /**
     * Test of getGame_NotExistentGame, of class HashTable_ADT.
     */
    @Test
    public void testGetGame_NotExistentGame() {
        System.out.println("getGame_NotExistentGame");
        gameTable = new HashTable_ADT();

        OrderBook result = gameTable.getGame("Uno");
        assertNull(result);
    }

    /**
     * Test of getGame_EmptyTable, of class HashTable_ADT.
     */
    @Test
    public void testGetGame_EmptyTable() {
        System.out.println("getGame_EmptyTable");
        gameTable = new HashTable_ADT();

        // try to get a game from an empty table
        OrderBook result = gameTable.getGame("Minecraft");
        assertNull(result);
    }

    /**
     * Test of removeGame_ExistingGame, of class HashTable_ADT.
     */
    @Test
    public void testRemoveGame_ExistingGame() {
        System.out.println("removeGame_ExistingGame");
        gameTable = new HashTable_ADT();

        gameTable.addGame("Overcooked");
        gameTable.addGame("Card2024");

        gameTable.removeGame("Card2024");
        //Removed game
        assertFalse(gameTable.contains("Card2024"));
    }

    /**
     * Test of removeGame_NotExistentGame, of class HashTable_ADT.
     */
    @Test
    public void testRemoveGame_NotExistentGame() {
        System.out.println("removeGame_NotExistentGame");
        gameTable = new HashTable_ADT();

        gameTable.addGame("Overcooked");
        gameTable.addGame("Card2024");

        gameTable.removeGame("Uno");
        assertTrue(gameTable.contains("Overcooked"));
        assertTrue(gameTable.contains("Card2024"));
    }

    /**
     * Test of contains_EmptyTable, of class HashTable_ADT.
     */
    @Test
    public void testContains_EmptyTable() {
        System.out.println("contains_EmptyTable");
        gameTable = new HashTable_ADT();

        boolean result = gameTable.contains("Overcooked");
        assertFalse(result);
    }

    /**
     * Test of contains_ExistingGame, of class HashTable_ADT.
     */
    @Test
    public void testContains_ExistingGame() {
        System.out.println("contains_ExistingGame");
        gameTable = new HashTable_ADT();

        gameTable.addGame("Card2024");
        boolean result = gameTable.contains("Card2024");
        assertTrue(result);
    }

    @Test
    public void testContains_NotExistentGame() {
        System.out.println("contains_NotExistentGame");
        gameTable = new HashTable_ADT();

        gameTable.addGame("Overcooked");
        gameTable.addGame("Card2024");
        boolean result = gameTable.contains("Uno");
        assertFalse(result);
    }

    @Test
    public void testGetSize_EmptyTable() {
        System.out.println("getSize_EmptyTable");
        gameTable = new HashTable_ADT();

        int size = gameTable.getSize();
        assertEquals(0, size);
    }

    @Test
    public void testGetSize_SingleGame() {
        System.out.println("getSize_SingleGame");
        gameTable = new HashTable_ADT();

        gameTable.addGame("Card2024");
        int size = gameTable.getSize();
        assertEquals(1, size);
    }

    @Test
    public void testGetSize_MultipleGames() {
        System.out.println("getSize_MultipleGames");
        gameTable = new HashTable_ADT();

        gameTable.addGame("Overcooked");
        gameTable.addGame("Card2024");
        int size = gameTable.getSize();
        assertEquals(2, size);
    }
}