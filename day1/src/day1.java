import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class day1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> caloriesList = new ArrayList<>();

        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day1/src/input2.txt");
        Scanner scanner = new Scanner(file);
        int total = 0;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            if(line.equals("")){
                caloriesList.add(total);
                total = 0;
            }
            else{
                total += Integer.parseInt(line);
            }

        }

        System.out.println(caloriesList.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax());
    }
}
