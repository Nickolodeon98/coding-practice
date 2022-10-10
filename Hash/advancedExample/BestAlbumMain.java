package Hash.advancedExample;

import java.util.Arrays;

public class BestAlbumMain {

    public static void main(String[] args) {
        BestAlbum test = new BestAlbum();
        String[] genresTest = {"classic", "pop", "classic", "classic", "pop", "pop", "classic", "rock", "rock", "rock"};
        int[] playsTest = {500, 600, 150, 800, 2500, 2500, 600, 700, 500, 400};

        test.setGenres(genresTest);
        test.setPlays(playsTest);

        test.register();

        System.out.println(Arrays.toString(test.leaveValid()));
    }
}
