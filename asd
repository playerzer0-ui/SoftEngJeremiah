public static void main(String[] args) {
        List_ADT list = new List_ADT();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(4);

        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.println(list.size());
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(4);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains(1000));
        System.out.println(list.contains(1));

        list.sort();
        System.out.println(list);
    }