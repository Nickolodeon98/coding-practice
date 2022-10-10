package Hash.basic;

public class DeletedEntry extends HashEntry{
    private static DeletedEntry entry = null;

    public DeletedEntry() {
        super(-1, -1);
    }

    public static DeletedEntry getUniqueDeletedEntry() {
        if (entry == null) // 만약 지워지고 난 후 이전에 아무 Entry 도 채워지지 않았다면, 새롭게 DELETED 를 표시
            entry = new DeletedEntry();
        return entry;
    }
}
