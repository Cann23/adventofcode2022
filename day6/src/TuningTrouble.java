import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TuningTrouble {

    public static boolean fourCharacters(Character character1
                                        , Character character2
                                        , Character character3
                                        , Character character4){
        return character1 != character2
                && character1 != character3
                && character1 != character4
                && character2 != character3
                && character2 != character4
                && character3 != character4;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day6/src/input.txt");
        Scanner scanner = new Scanner(file);

        String stream = scanner.next();

        Character[] characters = new Character[stream.length()];

        for(int i = 0; i < stream.length(); i++){
            characters[i] = stream.charAt(i);
        }

        for(int i = 0; i < stream.length() - 4; i++){
            if (fourCharacters(characters[i], characters[i + 1], characters[i + 2], characters[i + 3])) {
                System.out.println("First Part: " + (i + 4));
                break;
            }
        }
    }
}
