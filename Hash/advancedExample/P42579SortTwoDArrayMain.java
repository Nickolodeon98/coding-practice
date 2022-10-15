package Hash.advancedExample;

public class P42579SortTwoDArrayMain {
    public static void main(String[] args) {
        String[][] testArr = {{"pop", "3100"}, {"classic", "1450"}, {"rock", "350"}, {"ballad", "2050"}, {"ccm", "850"}};
        P42579SortTwoDArray test = new P42579SortTwoDArray();

        test.sortTwoDArr(testArr);

        for (String[] strings : testArr) {
            System.out.println(strings[0] + " " + strings[1]);
        }
    }
}
