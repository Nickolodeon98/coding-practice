package Hash.basicExample;

import java.util.*;
import java.util.stream.Collectors;

public class P92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, String> map = new HashMap<String, String>();

        List<String> idList= new ArrayList<String>();
        Collections.addAll(idList, id_list);
        String s;
        List reportList = Arrays.stream(report).distinct().collect(Collectors.toList());

        for(int i = 0; i < reportList.size(); i++) {
            String reporting = reportList.get(i).toString().split(" ", 2)[0];
            String reported = reportList.get(i).toString().split(" ", 2)[1];

            String reportingMap = map.get(reported);
            if (reportingMap != null) {
                map.put(reported, reportingMap + " " + reporting);
                continue;
            }
            map.put(reported, reporting);
        }
        int index= 0;
        int[] answer = new int[id_list.length];

        for (String element : map.keySet()) {
            String[] arr = map.get(element).split(" ");
            if (arr.length >= k) {
                for (String member : arr) {
                    answer[idList.indexOf(member)]++;
                }
            }
        }

        return answer;
    }
}

