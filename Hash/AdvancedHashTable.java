package Hash;

/*Remove 를 추가하고, initialHash 변수를 통해 반복을 통제함*/
public class AdvancedHashTable {
    private final static int TABLE_SIZE = 128;

    private HashEntry[] table;

    public AdvancedHashTable() {
        table = new HashEntry[TABLE_SIZE];
        for (HashEntry hashEntry : table) {
            hashEntry = null;
        }
    }

    public int get(int key) {
        int hash = (key % TABLE_SIZE);
        int initialHash = -1;

        // 만일 initialHash 이면 모두 통과 -> 만약 계속 반복하다가 결국 최초와 똑같은 Hash 가 나오면 모두 돌았기 때문에 반복 중단
        // DELETED 엔트리도 데이터가 존재하는 것으로 취급
        while (hash != initialHash && (table[hash] == DeletedEntry.getUniqueDeletedEntry() ||
        table[hash] != null && table[hash].getKey() != key)) {
            if (initialHash == -1) initialHash = hash; // 처음 탐색을 시작하는 것이라면 우선 첫 해시값을 저장해서 나중에 불필요한 탐색을 줄임
            hash = (hash + 1) % TABLE_SIZE;
        }
        if (table[hash] == null || hash == initialHash) // 찾은 저장 위치가 비어있을 때 (최초 해시값으로 찾은 저장 위치일 때)
            return -1; // 원하는 값을 못 찾으면 -1을 리턴
        else
            return table[hash].getValue(); // 원하는 값을 찾으면 그 값을 리턴
    }

    public void put(int key, int value) {
        int hash = (key % TABLE_SIZE); // 해시 함수를 적용
        int initialHash = -1;
        int indexOfDeletedEntry = -1;

        while (hash != initialHash && (table[hash] == DeletedEntry.getUniqueDeletedEntry() ||
        table[hash] != null && table[hash].getKey() != key)) {
            if (initialHash == -1) initialHash = hash;
            if (table[hash] == DeletedEntry.getUniqueDeletedEntry()) indexOfDeletedEntry = hash; // 만약 이미 DELETED 가 저장되어 있을 시 그 위치를 변수로 저장해 이후에 삽입 가능하게 함
            hash = (hash + 1) % TABLE_SIZE;
        }
        if ((table[hash] == null || hash == initialHash) && indexOfDeletedEntry != -1) // 찾은 저장 위치에 DELETED 로 채워져 있을 때
            table[indexOfDeletedEntry] = new HashEntry(key, value);
        else if (initialHash != hash) // linear probing 을 적용해서 다른 저장 위치를 찾은 상태일 때
            if (table[hash] != DeletedEntry.getUniqueDeletedEntry() && table[hash] != null && table[hash].getKey() == key)
                table[hash].setValue(value); // 동일한 키로 이미 한 차례 데이터를 저장한 적이 있을 때 덮어씀
            else table[hash] = new HashEntry(key, value);
    }

    /*기본적으로 get 과 put 의 처음 부분과 같으며, 지우는 개념이 아니라 DELETED 표시를 하는 개념 */
    public void remove(int key) {
        int hash = (key % TABLE_SIZE);
        int initialHash = -1;

        while (hash != initialHash && (table[hash] == DeletedEntry.getUniqueDeletedEntry() ||
                table[hash] != null && table[hash].getKey() != key)) {
            if (initialHash == -1) initialHash = hash;
            hash = (hash + 1) % TABLE_SIZE;
        }
        if (hash != initialHash && table[hash] != null)
            table[hash] = DeletedEntry.getUniqueDeletedEntry(); // 객체가 들어 있다면 DELETED 표시를 대신 넣음으로서 삭제
    }
}
