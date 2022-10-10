package Hash.basic;

/*배열로 구현된 해시 테이블 내의 key-value 원소를 나타내는 클래스*/

public class HashEntry {
    private int key; // 키를 저장하는 변수
    private int value; // 데이터를 저장하는 변수

    public HashEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
