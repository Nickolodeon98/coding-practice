package Hash.basicExample.baekjoon7785;

import java.io.IOException;

public class EnterOrLeaveMain {
    public static void main(String[] args) throws IOException {
        EnterOrLeave test = new EnterOrLeave();
        test.readFile("C:\\LikeLion\\Algorithms Study\\Algorithms_list\\coding-practice\\Hash\\basicExample\\EnterOrLeaveTestCases.txt");
        test.judge();
        test.printMap();
    }
}
