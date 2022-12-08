import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CampCleanup {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day4/src/input2.txt");
        Scanner scanner = new Scanner(file);

        int fullyContainNumber = 0;
        int fullyContainNumber2 = 0;

        while(scanner.hasNext()){
            String nextLine = scanner.next();
            String[] pairs = nextLine.split(",");
            String[] firstElementOfPairs = pairs[0].split("-");
            String[] secondElementOfPairs = pairs[1].split("-");

            // part1
            if( (Integer.parseInt(firstElementOfPairs[0]) >= Integer.parseInt(secondElementOfPairs[0])
                    && Integer.parseInt(firstElementOfPairs[1]) <= Integer.parseInt(secondElementOfPairs[1]))
                    || (Integer.parseInt(firstElementOfPairs[0]) <= Integer.parseInt(secondElementOfPairs[0])
                        && Integer.parseInt(firstElementOfPairs[1]) >= Integer.parseInt(secondElementOfPairs[1]))){
                            fullyContainNumber++;
            }

            // part2
            if((Integer.parseInt(firstElementOfPairs[1]) >= Integer.parseInt(secondElementOfPairs[0]))
                     ){
                fullyContainNumber2++;
            }


        }
        System.out.println(fullyContainNumber);
        System.out.println(fullyContainNumber2);
    }
}
