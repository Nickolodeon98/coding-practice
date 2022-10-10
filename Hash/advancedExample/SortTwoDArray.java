package Hash.advancedExample;

public class SortTwoDArray {
    public void findMin(int current, String[][] twoDArray) {
        int max = 0;
        int idx = 0;

        for (int i = current; i < twoDArray.length; i++) {
            int potentialMax = Integer.parseInt(twoDArray[i][1]);
            if (potentialMax > max) {
                max = potentialMax;
                idx = i;
            }
        }

        String temp = twoDArray[current][1];
        twoDArray[current][1] = Integer.toString(max);
        twoDArray[idx][1] = temp;

        String tmp = twoDArray[current][0];
        twoDArray[current][0] = twoDArray[idx][0];
        twoDArray[idx][0] = tmp;
    }

    public void sortTwoDArr(String[][] twoDArray) {
        for (int i = 0; i < twoDArray.length; i++) {
            findMin(i, twoDArray);
        }
    }
}
