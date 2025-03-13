package adt;

import business.User;

public class UserList_ADT {
    private User[] array;
    private int count;

    public UserList_ADT() {
        array = new User[10]; // Initial size
        count = 0;
    }

    public User get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        return array[index];
    }

    public void clear() {
        count = 0;
    }

    public boolean add(User e) {
        if (count >= array.length) {
            resize();
        }
        array[count++] = e;
        return true;
    }

    public boolean remove(User e) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (array[i].equals(e)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false; // Element not found
        }
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
        return true;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean contains(User e) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return count;
    }

    private void resize() {
        User[] newArr = new User[array.length * 2];

        for (int i = 0; i < count; i++) {
            newArr[i] = array[i];
        }

        array = newArr;
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        word.append("[");

        for (int i = 0; i < count; i++) {
            word.append(array[i]);
            if (i < count - 1) {
                word.append(", ");
            }
        }

        word.append("]");
        return word.toString();
    }
}
