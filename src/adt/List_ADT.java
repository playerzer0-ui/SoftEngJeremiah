package adt;

import business.Order;

public class List_ADT {
    Order[] array;
    private int count;

    public List_ADT() {
        array = new Order[10];
        count = 0;
    }

    public Order get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        return array[index];
    }

    public void clear() {
        count = 0;
    }

    public boolean add(Order e) {
        if (count >= array.length) {
            resize();
        }
        array[count++] = e;
        return true;
    }

    public Order remove(Order e) {
        int index = -1;
        Order temp = null;
        if(isEmpty()){
            return null;
        }

        for (int i = 0; i < count; i++) {
            if (array[i] == e) {
                index = i;
                temp = array[i];
                break;
            }
        }
        if (index == -1) {
            return null; // Element not found
        }
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
        return temp;
    }

    public boolean remove(int i) {
        if(isEmpty() || i >= count  || i<0) {
            return false;
        }

        for(int j = i; j < count - 1; j++){
            array[j] = array[j + 1];
        }

        count--;
        return true;
    }

    public int indexOf(Order e){
        for(int i = 0; i < count; i++){
            if(array[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean contains(Order e) {
        for (int i = 0; i < count; i++) {
            if (array[i] == e) {
                return true;
            }
        }
        return false;
    }

    public boolean sort() {
        if (isEmpty()) {
            return false;
        }

        // Bubble Sort for integers
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (array[j].getPrice() > array[j + 1].getPrice()) {
                    // Swap array[j] and array[j + 1]
                    Order temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return true;
    }

    public int size() {
        return count;
    }

    private void resize() {
        Order[] newArr = new Order[array.length * 2];

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
                word.append(",");
            }
        }

        word.append("]");
        return word.toString();
    }
}

