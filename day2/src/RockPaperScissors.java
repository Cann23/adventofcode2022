import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Character> roundLists = new ArrayList<>();

        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day2/src/input2.txt");
        Scanner scanner = new Scanner(file);

        int score = 0;
        int score2 = 0;

        while(scanner.hasNext()){
            String opponentChoose = scanner.next();
            String myChoose = scanner.next();

            switch (opponentChoose.charAt(0)){
                case 'A':
                    switch (myChoose.charAt(0)){
                        case 'X':
                            score += 4;
                            score2 += 3;
                            break;
                        case 'Y':
                            score += 8;
                            score2 += 4;
                            break;
                        case 'Z':
                            score += 3;
                            score2 += 8;
                            break;
                    }
                    break;
                case 'B':
                    switch (myChoose.charAt(0)){
                        case 'X':
                            score += 1;
                            score2 += 1;
                            break;
                        case 'Y':
                            score += 5;
                            score2 += 5;
                            break;
                        case 'Z':
                            score += 9;
                            score2 += 9;
                            break;
                    }
                    break;
                case 'C':
                    switch (myChoose.charAt(0)){
                        case 'X':
                            score += 7;
                            score2 += 2;
                            break;
                        case 'Y':
                            score += 2;
                            score2 += 6;
                            break;
                        case 'Z':
                            score += 6;
                            score2 += 7;
                            break;
                    }
                    break;
            }
        }

        System.out.println("Score: " + score);
        System.out.println("Score2: " + score2);
    }
}
