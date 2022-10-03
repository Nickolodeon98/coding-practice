package Hash;

/*Quoted from Hash_Table_Interviews_In_Java.pdf*/
class RollingHash {
    public static int stringHash(String str, int modulus) { //str is a given string to be hashed
        int kMult = 997;

        int val = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            val = (val * kMult + c) % modulus;
        }
        return val;
    }
}

public class HashEX2 {
    public static void main(String[] args) {
        int ret = RollingHash.stringHash("ABC", 3);

        System.out.println(ret);
    }
}
