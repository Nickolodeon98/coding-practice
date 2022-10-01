package Hash;

import java.util.Hashtable;
import java.util.Scanner;

class HashImplementation {
    private String[] ht;
    private int ptr;

    HashImplementation(int size) {
        ht = new String[size];
        ptr = 0;
    }

    public void put(String key, String data) {
        ht[Integer.parseInt(key)] = data;
    }
}


public class HashEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(">>> ");

        String keyStr = sc.nextLine();

        System.out.println();
    }
}
