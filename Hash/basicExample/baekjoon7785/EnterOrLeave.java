package Hash.basicExample.baekjoon7785;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class EnterOrLeave {
    private HashMap<String, Integer> enterOrLeave;
    private List<String> readInfo;

    public EnterOrLeave() {
        this.enterOrLeave = new HashMap<>();
        this.readInfo = new ArrayList<>();
    }

    public void readFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename), 16 * 1024);

        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            readInfo.add(line);
        }
    }

    public void judge() {
        for (String s : readInfo) {
            String[] sentence = s.split(" ");
            if (sentence[1].equals("enter")) {
                if (enterOrLeave.get(sentence[0]) != null) {
                    System.out.println("잘못된 로그 기록입니다. 이미 출근 상태입니다.");
                    continue;
                }
                enterOrLeave.put(sentence[0], 1);
            } else if (sentence[1].equals("leave")) enterOrLeave.put(sentence[0], 0);
        }
    }

    public void printMap() {
        List<String> toPrint = new ArrayList<>();
        for (Map.Entry<String, Integer> remaining : enterOrLeave.entrySet()) {
            if (remaining.getValue() == 1) toPrint.add(remaining.getKey());
        }
        Collections.sort(toPrint, Comparator.reverseOrder());
        for (String s : toPrint) {
            System.out.println(s);
        }
    }
}
