package Hash.basicExample.baekjoon7785;

import java.util.*;

public class Main {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int cnt = 0;
        HashMap<String, Integer> whoRemains = new HashMap<>();
        List<String> toPrint = new ArrayList<>();
        while (cnt < num) {
            String s = sc.nextLine();
            String[] info = s.split(" ");
            if (info[1].equals("enter")) whoRemains.put(info[0], 1);
            else whoRemains.put(info[0], 0);
            cnt++;
        }

        for (Map.Entry<String, Integer> personalRecord : whoRemains.entrySet()) {
            if (personalRecord.getValue() == 1) toPrint.add(personalRecord.getKey());
        }

        Collections.sort(toPrint, Collections.reverseOrder());

        for (String s : toPrint) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.solution();
    }
}
