import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HillClimbingAlgorithm {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day12/src/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> lines = new ArrayList<>();

        // reading input
        while (scanner.hasNext()){
            String line = scanner.next();
            lines.add(line);
        }

        // creating grid
        char[][] grid = new char[lines.size()][lines.get(0).length()];

        // filling grid
        for(int i = 0; i < lines.size(); i++){
            for(int j = 0; j < lines.get(i).length(); j++){
                grid[i][j] = lines.get(i).charAt(j);
            }
        }

        System.out.println('a' + 1 == 'b');
    }
}
