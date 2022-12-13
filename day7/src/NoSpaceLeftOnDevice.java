import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NoSpaceLeftOnDevice {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day7/src/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<Integer> fileSize = new ArrayList<>();

        while(scanner.hasNext()){
            stringArrayList.add(scanner.nextLine());
        }




        System.out.println("Hello World!");
    }
}
