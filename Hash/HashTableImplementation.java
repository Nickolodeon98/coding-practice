package Hash;

/* HashTable(혹은 HashMap) 구현
* 상수 크기(128)의 배열을 이용하여 구현
* 간단한 해시 함수와 Linear Probing 적용
* 반복문을 빠져나오지 못할 수도 있다는 버그 존재
* 단순 구현을 위해 삭제는 구현하지 않음
* */

public class HashTableImplementation {
    private final static int TABLE_SIZE = 128;

    private HashEntry[] table;

    public HashTableImplementation() {
        table = new HashEntry[TABLE_SIZE];
        for (HashEntry hashEntry : table) {
            hashEntry = null;
        }
    }

    public int get(int key) {
        int hash = (key % TABLE_SIZE); // 해시 함수로 키 값을 해시 테이블의 크기로 modulo(%) 연산하는 계산식을 사용
        while (table[hash] != null && table[hash].getKey() != key) // 해시 함수로 찾은 저장 위치에 이미 데이터가 존재하긴 하는데 그 위치가 다른 키의 해시 함수 결과인 한 반복
            hash = (hash + 1) % TABLE_SIZE; //선형 조사(Linear Probing) 활용, 현재 저장 위치에 1을 더한 후 위치에 해시 함수를 적용하여 다음 저장 위치를 탐색
        if (table[hash] == null) // 찾은 저장 위치가 비어있을 때
            return -1; // 원하는 값을 못 찾으면 -1을 리턴
        else
            return table[hash].getValue(); // 원하는 값을 찾으면 그 값을 리턴
    }

    public void put(int key, int value) {
        int hash = (key % TABLE_SIZE); // 해시 함수를 적용
        while (table[hash] != null && table[hash].getKey() != key) // 반대: (table[hash] == null || table[hash].getKey() == key)
            hash = (hash + 1) % TABLE_SIZE;
        table[hash] = new HashEntry(key, value); // 즉, 찾은 저장 위치가 비어있거나 이미 한 차례 같은 키로 등록한 적이 있는 곳이면 새로 추가 또는 덮어씀
    }
}
