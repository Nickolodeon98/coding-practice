package Hash.basic;

public class HashMain {
    public static void main(String[] args) {
        HashTableImplementation test = new HashTableImplementation();

        test.put(3, 10);

        System.out.println(test.get(3));

        AdvancedHashTable test2 = new AdvancedHashTable();

        test2.put(20, 100);
        test2.put(30, 120);
        test2.remove(30);

        System.out.println(test2.get(30));
    }
}
