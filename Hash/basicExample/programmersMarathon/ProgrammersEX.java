package Hash.basicExample.programmersMarathon;

import java.util.*;
/*참가자 명단을 먼저 해시 테이블에 등록한 후, 완주자 명단에서 그 이름을 찾으면 그 참가자 인원수를 1을 빼서
* 마지막에 0이 아니라 1로 남아있는 참가자가 결국 완주하지 못한 참가자 (완주자 명단에 있다면 인원수는 0이 되었을 것)*/
public class ProgrammersEX {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> info = new HashMap<>(); // HashTable 을 저장하는 변수 info 선언 - 키는 참가자 이름, 값은 인원수

        /*참가자 명단과 각 참가자의 인원수를 저장하는 Hashtable 구현*/
        for (int i = 0; i < participant.length; i++) { // 참가자 명단을 for loop 으로 탐색
            if (info.get(participant[i]) != null) { // 만약 현재 찾는 참가자 이름이 이미 존재하면 인원수에 1을 더함
                info.put(participant[i], info.get(participant[i]) + 1);
            } else {
                info.put(participant[i], 1); // 없다면 1로 인원수 등록
            }
        }

        for (int j = 0; j < completion.length; j++) {
            info.put(completion[j], info.get(completion[j]) - 1); // 완주한 사람의 명단을 돌면서 참가자 이름을 찾을 때마다 인원수에서 1씩 소거
        }

        for (Map.Entry ent : info.entrySet()) {
            System.out.println(ent);
            if (Integer.parseInt(ent.getValue().toString()) > 0) { // 완주자 명단을 이용해 인원수를 제했는데 0보다 많은 인원이 있다면 그 참가자가 완주하지 못한 선수
                answer = ent.getKey().toString();
            }
        }
        return answer;
    }
}
