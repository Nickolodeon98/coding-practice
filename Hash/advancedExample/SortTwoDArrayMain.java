package Hash.advancedExample;

public class SortTwoDArrayMain {
    public static void main(String[] args) {
        String[][] testArr = {{"pop", "3100"}, {"classic", "1450"}, {"rock", "350"}, {"ballad", "2050"}, {"ccm", "850"}};
        SortTwoDArray test = new SortTwoDArray();

        test.sortTwoDArr(testArr);

        for (String[] strings : testArr) {
            System.out.println(strings[0] + " " + strings[1]);
        }
    }
}
