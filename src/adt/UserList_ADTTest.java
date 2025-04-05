package adt;

import business.Order;
import business.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserList_ADTTest {
    public UserList_ADTTest() {
    }

    User u1 = new User("Ken");
    User u2 = new User("Olive");
    User u3 = new User("Sean");
    User u4 = new User("Amy");

    /**
     * Test of get_ValidIndex, of class UserList_ADT.
     */
    @Test
    public void testGet_ValidIndex() {
        System.out.println("get_ValidIndex");
        UserList_ADT instance = new UserList_ADT();

        instance.add(u1);
        instance.add(u2);
        instance.add(u3);

        User result = instance.get(0);
        assertEquals(u1, result);
    }

    /**
     * Test of clear method, of class UserList_ADT.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        UserList_ADT instance = new UserList_ADT();
        instance.clear();
    }

    /**
     * Test of add_OneElement , of class UserList_ADT.
     */
    @Test
    public void testAdd_OneElement() {
        System.out.println("add_OneElement");
        UserList_ADT instance = new UserList_ADT();

        User user = u1;
        boolean result = instance.add(user);
        assertTrue(result);

        // Verify that the element is added correctly
        assertEquals( 1, instance.size());
        assertEquals(user, instance.get(0));
    }

    /**
     * Test of add_MultipleElements , of class UserList_ADT.
     */
    @Test
    public void testAdd_MultipleElements() {
        System.out.println("add_MultipleElements");
        UserList_ADT instance = new UserList_ADT();

        instance.add(u1);
        instance.add(u2);
        instance.add(u3);
        instance.add(u4);

        assertEquals( 4, instance.size());

        // Verify that the elements were added correctly
        assertEquals(u1, instance.get(0));
        assertEquals(u2, instance.get(1));
        assertEquals(u3, instance.get(2));
        assertEquals(u4, instance.get(3));
    }

    /**
     * Test of remove_ElementRemoved , of class UserList_ADT.
     */
    @Test
    public void testRemove_ElementRemoved() {
        System.out.println("remove_ElementRemoved");
        UserList_ADT instance = new UserList_ADT();

        instance.add(u1);
        instance.add(u2);
        instance.add(u3);
        boolean result = instance.remove(u1);
        assertTrue(result);

        // Verify the count is reduced by 1
        assertEquals(2,instance.size());

        // Verify the correct element was removed
        assertEquals(u2, instance.get(0));
        assertEquals(u3, instance.get(1));
    }

    /**
     * Test of isEmpty_EmptyList, of class UserList_ADT.
     */
    @Test
    public void testIsEmpty_EmptyList() {
        System.out.println("isEmpty_EmptyList");
        UserList_ADT instance = new UserList_ADT();

        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty_PopulatedList, of class UserList_ADT.
     */
    @Test
    public void testIsEmpty_PopulatedList() {
        System.out.println("isEmpty_PopulatedList");
        UserList_ADT instance = new UserList_ADT();

        instance.add(u1);
        instance.add(u2);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of contains_UserExistsInList, of class UserList_ADT.
     */
    @Test
    public void testContains_UserExistsInList() {
        System.out.println("contains_UserExistsInList");
        UserList_ADT instance = new UserList_ADT();

        instance.add(u1);
        instance.add(u2);
        boolean result = instance.contains(u1);
        assertTrue(result);
    }

    /**
     * Test of contains_UserDoesNotExistInList, of class UserList_ADT.
     */
    @Test
    public void testContains_UserDoesNotExistInList() {
        System.out.println("contains_UserDoesNotExistInList");
        UserList_ADT instance = new UserList_ADT();

        instance.add(u1);
        instance.add(u2);
        boolean result = instance.contains(u3);
        assertFalse(result);
    }

    /**
     * Test of size_EmptyList, of class UserList_ADT.
     */
    @Test
    public void testSize_EmptyList() {
        System.out.println("size_EmptyList");
        UserList_ADT instance = new UserList_ADT();

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
        UserList_ADT instance = new UserList_ADT();

        instance.add(u1);
        instance.add(u2);
        instance.add(u3);
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }
}