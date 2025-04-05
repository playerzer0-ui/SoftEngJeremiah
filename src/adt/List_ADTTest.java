package adt;

import business.Order;
import business.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class List_ADTTest {

    User u1 = new User("Ken");
    Order o1 = new Order(u1,100,5);
    User u2 = new User("Olive");
    Order o2 = new Order(u2,110,2);
    User u3 = new User("Sean");
    Order o3 = new Order(u3,95,10);
    User u4 = new User("Amy");
    Order o4 = new Order(u4,156,4);

    public List_ADTTest() {
    }

    /**
     * Test of isEmpty_EmptyList, of class List_ADT.
     */
    @Test
    public void testIsEmpty_EmptyList() {
        System.out.println("isEmpty_EmptyList");
        List_ADT instance = new List_ADT();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty_PopulatedList, of class List_ADT.
     */
    @Test
    public void testIsEmpty_PopulatedList() {
        System.out.println("isEmpty_PopulatedList");
        List_ADT instance = new List_ADT();
        instance.add(o1);
        instance.add(o2);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of size_EmptyList, of class List_ADT.
     */
    @Test
    public void testSize_EmptyList() {
        System.out.println("size_EmptyList");
        List_ADT instance = new List_ADT();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of size_PopulatedList, of class List_ADT, with 3 elements in list.
     */
    @Test
    public void testSize_PopulatedList() {
        System.out.println("size_PopulatedList");
        List_ADT instance = new List_ADT();
        instance.add(o1);
        instance.add(o2);
        instance.add(o3);
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOf_ElementFound, of class List_ADT.
     */
    @Test
    public void testIndexOf_ElementFound() {
        System.out.println("indexOf_ElementFound");
        List_ADT instance = new List_ADT();
        instance.add(o1);  // index 0
        instance.add(o2);  // index 1
        instance.add(o3);  // index 2

        //Order to search for
        Order orderToFind = o2;

        int expected = 1;
        int result = instance.indexOf(orderToFind);
        assertEquals(expected, result);
    }

    /**
     * Test of indexOf_ElementNotFound, of class List_ADT.
     */
    @Test
    public void testIndexOf_ElementNotFound() {
        System.out.println("indexOf_ElementNotFound");
        List_ADT instance = new List_ADT();
        instance.add(o1);  // index 0
        instance.add(o2);  // index 1

        // Create the order to search for
        Order orderNotFound =  new Order(u3,200,50);

        int expected = -1;
        int result = instance.indexOf(orderNotFound);
        assertEquals(expected, result);
    }

    /**
     * Test of get_ValidIndex, of class List_ADT.
     */
    @Test
    public void testGet_ValidIndex() {
        System.out.println("get_ValidIndex");
        List_ADT instance = new List_ADT();

        instance.add(o1);
        instance.add(o2);
        instance.add(o3);

        Order result = instance.get(1);
        assertEquals(o2, result);
    }

    /**
     * Test of sort_SortOrdersByPrice, of class List_ADT.
     */
    @Test
    public void testSort_SortOrdersByPrice() {
        System.out.println("sort_SortOrdersByPrice");
        List_ADT instance = new List_ADT();

        instance.add(o4);
        instance.add(o2);
        instance.add(o1);
        boolean result = instance.sort();
        assertTrue(result);

        // Verify the orders are sorted by price
        assertEquals(100, instance.get(0).getPrice(), 0.01);
        assertEquals(110, instance.get(1).getPrice(), 0.01);
        assertEquals(156, instance.get(2).getPrice(), 0.01);
    }

    /**
     * Test of sort_SortOrdersBySamePrice , of class List_ADT.
     */
    @Test
    public void testSort_SortOrdersBySamePrice() {
        System.out.println("sort_SortOrdersBySamePrice");
        List_ADT instance = new List_ADT();

        instance.add(new Order(u1,100,5));
        instance.add(new Order(u2,100,8));
        instance.add(new Order(u3,100,3));
        boolean result = instance.sort();
        assertTrue(result);

        // Verify the orders are sorted by price
        assertEquals(u1, instance.get(0).getUser());
        assertEquals(u2, instance.get(1).getUser());
        assertEquals(u3, instance.get(2).getUser());
    }

    /**
     * Test of add_OneElement , of class List_ADT.
     */
    @Test
    public void testAdd_OneElement() {
        System.out.println("add_OneElement");
        List_ADT instance = new List_ADT();

        Order order = o1;
        boolean result = instance.add(order);
        assertTrue(result);

        // Verify that the element is added correctly
        assertEquals( 1, instance.size());
        assertEquals(order, instance.get(0));
    }

    /**
     * Test of add_MultipleElements , of class List_ADT.
     */
    @Test
    public void testAdd_MultipleElements() {
        System.out.println("add_MultipleElements");
        List_ADT instance = new List_ADT();

        instance.add(o1);
        instance.add(o2);
        instance.add(o3);
        assertEquals( 3, instance.size());

        // Verify that the elements were added correctly
        assertEquals(o1, instance.get(0));
        assertEquals(o2, instance.get(1));
        assertEquals(o3, instance.get(2));
    }

    /**
     * Test of remove_ElementRemoved , of class List_ADT.
     */
    @Test
    public void testRemove_ElementRemoved() {
        System.out.println("remove_ElementRemoved");
        List_ADT instance = new List_ADT();

        instance.add(o1);
        instance.add(o2);
        instance.add(o3);
        boolean result = instance.remove(1);
        assertTrue(result);

        // Verify the count is reduced by 1
        assertEquals(2,instance.size());

        // Verify the correct element was removed
        assertEquals(o1, instance.get(0));
        assertEquals(o3, instance.get(1));
    }

}