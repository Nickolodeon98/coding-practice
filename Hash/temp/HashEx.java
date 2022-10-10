package Hash.temp;

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
        ptr++;
    }

    public String get(String key) {
        return ht[Integer.parseInt(key)];
    }

    public void remove(String key) {
        ptr--;
    }

    public boolean contains(String data) {
        for (String str : ht) {
            if (str.equals(data)) return true;
        }
        return false;
    }
}


public class HashEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(">>> ");

        String keyStr = sc.nextLine();
        Hashtable<String, String> ht = new Hashtable<>();

        System.out.println();
    }
}
