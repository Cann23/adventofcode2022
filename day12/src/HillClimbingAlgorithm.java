import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HillClimbingAlgorithm {

    public static void calculate(char[][] grid, int startX, int startY, int endX, int endY, int gridX, int gridY){
        //TODO: recursion
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day12/src/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> lines = new ArrayList<>();

        int sx = 0; // current position x
        int sy = 0; // current position y
        int ex = 0; // best signal x
        int ey = 0; // best signal y
        int currentX = 0;
        int currentY = 0;

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

                if(grid[i][j] == 'S'){
//                    System.out.println("i: " + i + " ||| j: " + j);
                    sx = i;
                    sy = j;
                }

                if(grid[i][j] == 'E'){
//                    System.out.println("i: " + i + " ||| j: " + j);
                    ex = i;
                    ey = j;
                }
            }
        }

        currentX = sx;
        currentY = sy;

        calculate(grid, sx, sy, ex, ey, lines.size(), lines.get(0).length());


        System.out.println('a' + 1 == 'b');
    }
}
