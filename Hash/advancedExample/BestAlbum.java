package Hash.advancedExample;

/* 1. 속한 노래가 많이 재생된 장르: 장르 내에 속한 노래들의 재생 숫자의 합 비교
*  2. 장르 내에서 많이 재생된 노래: 말 그대로 가장 많이 재생한 노래 재생 횟수 비교
*  3. 장르 내에서 고유 번호가 낮은 노래: 오름차순으로 정렬했을 때 가장 앞에 있는 노래*/

import java.util.*;

import static java.util.Arrays.asList;

public class BestAlbum {
    private HashMap<String, Integer> musicPreferenceMap; // 각 노래별로 총 합해서 몇 번의 재생 횟수를 갖는지 저장
    private HashMap<Integer, Integer> musicCodeMap; // 각 코드 별로 몇 번의 재생 횟수를 가지고 있는지를 저장 (중복 없음)
    private HashMap<String, Integer> mappingMax; // 각 노래가 어떤 코드에 매핑되었는지를 저장하는 해시맵 (가장 최근 것만, 중복 있음)
    private HashMap<String, List<Integer>> mappingInOrder; // 각 노래가 어떤 코드에 매핑되었는지를 저장하는 해시맵
    private String[] genres;
    private int[] plays;

    public BestAlbum() {
        this.musicPreferenceMap = new HashMap<>();
        this.musicCodeMap = new HashMap<>();
        this.mappingMax = new HashMap<>();
        this.mappingInOrder = new HashMap<>();
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public void setPlays(int[] plays) {
        this.plays = plays;
    }


    public void register() {
        List<Integer> orderInfo;
        int secondMax;
        for (int i = 0; i < genres.length; i++) { // 모든 속한 노래의 장르들에 대해서
            if (musicPreferenceMap.get(genres[i]) != null) { // 만약 처음 저장하는 노래의 장르가 아닌 경우,
                if (musicCodeMap.get(mappingMax.get(genres[i])) < plays[i]) { // 최대 재생 횟수를 기록하고 있는 노래의 재생 횟수와 비교한다
                    secondMax = mappingMax.get(genres[i]); // 지금까지의 최대는 두번째 가장 많은 재생 횟수의 노래로 저장해 놓는다
                    mappingMax.put(genres[i], i); // 최대값을 업데이트해준다
                } else if (musicCodeMap.get(mappingMax.get(genres[i])) == plays[i]) secondMax = i; // 만일 현재 노래의 재생 횟수가 최대값과 동일할 때는 이미 최대값인 노래가 더 낮은 코드를 갖고 있으므로 현재 노래를 두번째 최대값으로 저장한다
                else if (mappingInOrder.get(genres[i]).size() > 1 && (musicCodeMap.get(mappingInOrder.get(genres[i]).get(1)) < plays[i])) secondMax = i; //이미 두개가 저장되어 있는데 두번째 최대값보다 현재 재생 횟수가 클 때
                else if (mappingInOrder.get(genres[i]).size() == 1) secondMax = i;
                else secondMax = -1;
                if (secondMax != -1) {
                    orderInfo = new ArrayList<>();
                    orderInfo.add(mappingMax.get(genres[i]));
                    orderInfo.add(secondMax);
                    mappingInOrder.put(genres[i], orderInfo);
                }
                musicPreferenceMap.put(genres[i], musicPreferenceMap.get(genres[i]) + plays[i]); // 장르별 노래 재생 횟수의 총 합을 업데이트한다
            } else { // 처음 저장하는 노래의 장르인 경우
                orderInfo = new ArrayList<>();
                orderInfo.add(i);
                mappingInOrder.put(genres[i], orderInfo);
//                secondMax = i;
                mappingMax.put(genres[i], i); // 우선 현재 노래의 코드를 최댓값의 코드로 초기화한다
                musicPreferenceMap.put(genres[i], plays[i]); // 현재 장르 노래의 재생 횟수 총 합을 업데이트한다 (처음이므로 현재 재생 횟수가 총 합과 동일)
            }
            musicCodeMap.put(i, plays[i]); // 각 코드별로 몇 번의 재생횟수가 있는지 저장한다
        }

        /*테스트를 위한 출력*/
        System.out.println(musicPreferenceMap);
        System.out.println(musicCodeMap);
        System.out.println(mappingMax);
        System.out.println(mappingInOrder);
    }

    public int[] leaveValid() {
        String[][] genresArr = new String[musicPreferenceMap.size()][2];

        int i = 0, j = 0;

        for (Map.Entry e : musicPreferenceMap.entrySet()) {
            genresArr[i][0] = e.getKey().toString();
            genresArr[i][1] = e.getValue().toString();
            i++;
        }

        SortTwoDArray sortTool = new SortTwoDArray();
        sortTool.sortTwoDArr(genresArr);

        List<Integer> bestAlbum = new ArrayList<>();

        for (String[] aGenre : genresArr) {
            bestAlbum.add(mappingInOrder.get(aGenre[0]).get(0));
            if (mappingInOrder.get(aGenre[0]).size() > 1) bestAlbum.add(mappingInOrder.get(aGenre[0]).get(1));
        }

        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }

}
