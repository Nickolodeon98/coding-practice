package Hash;

public class HashMain {
    public static void main(String[] args) {
        HashTableImplementation test = new HashTableImplementation();

        test.put(3, 10);

        System.out.println(test.get(3));
    }
}
