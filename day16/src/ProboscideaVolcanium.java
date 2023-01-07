import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProboscideaVolcanium {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day16/src/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<Valves> valves = new ArrayList<>();

        while(scanner.hasNext()){
            String temp = scanner.nextLine();

            String[] words = temp.split(" ");
            String rate = words[4].substring(5, words[4].length() - 1);
            ArrayList<String> leadToValves = new ArrayList<>();

            for(int i = 0; i < words.length - 9; i++){
                leadToValves.add(words[i+9].substring(0,2));
            }

            Valves valve = new Valves(words[1], Integer.parseInt(rate), leadToValves);
            valves.add(valve);

        }

        System.out.println("hello !!!");

    }
}
