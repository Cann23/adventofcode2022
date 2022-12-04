import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> caloriesList = new ArrayList<>();

        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day1/src/input.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextInt()){
            Integer a = scanner.nextInt();
            caloriesList.add(a);
        }

        System.out.println(caloriesList);
    }
}
