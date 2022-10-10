package Hash.intermediateExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpyClothes {
    private String[][] clothes;
    private HashMap<String, Integer> clothesCnt;

    public SpyClothes() {
        this.clothesCnt = new HashMap<>();
    }

    public void setClothes(String[][] clothes) {
        this.clothes = clothes;
    }

    public void countTypes() {
        for (String[] clothesType : clothes) {
            if (clothesCnt.get(clothesType[1]) != null) clothesCnt.put(clothesType[1], clothesCnt.get(clothesType[1]) + 1);
            else clothesCnt.put(clothesType[1], 1);
        }
    }

    public int numberOfCombinations() {
        List<Integer> clothesCntList = new ArrayList<>();

        for (Map.Entry numOfEachType : clothesCnt.entrySet()) {
            clothesCntList.add((Integer)numOfEachType.getValue());
        }
        int computed = 1;
        for (int i = 0; i < clothesCntList.size(); i++) {
            computed *= clothesCntList.get(i) + 1;
        }

        return computed -= 1;
    }

    public List<String> readFile(String filename) {
        List<String> readList = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
            String line;
            while ((line = reader.readLine()) != null) {
                readList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return readList;
    }
}
