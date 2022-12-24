import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class DistressSignal {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day13/src/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> lines = new ArrayList<>();

        // reading input
        while (scanner.hasNext()){
            String line = scanner.next();
            lines.add(line);
        }

        // creating pairs
        LinkedHashMap<String, String> pairs = new LinkedHashMap<>();

        for(int i = 0; i < lines.size();){
            pairs.put(lines.get(i), lines.get(i + 1));
            i +=2;
        }

        System.out.println("DistressSignal");
    }
}
