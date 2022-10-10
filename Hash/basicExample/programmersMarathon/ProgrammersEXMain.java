package Hash.basicExample.programmersMarathon;

public class ProgrammersEXMain {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        ProgrammersEX test = new ProgrammersEX();

        System.out.println(test.solution(participant, completion));
    }
}
