package Hash.intermediateExample;

import java.util.List;

public class P42578Main {
    public static void main(String[] args) {

        P42578 test = new P42578();
        String fName = "C:\\LikeLion\\Algorithms Study\\Algorithms_list\\coding-practice\\Hash\\intermediateExample\\SpyClothesTestCases.txt";
        List<String> testcases = test.readFile(fName);

        String[][] testArr = new String[testcases.size()][2];
        int i = 0;
        for (String testcase : testcases) {
            String[] nameAndType = testcase.split(", ");
            testArr[i][0] = nameAndType[0];
            testArr[i][1] = nameAndType[1];
            i++;
        }

        test.setClothes(testArr);

        test.countTypes();
        System.out.println(test.numberOfCombinations());
    }
}
