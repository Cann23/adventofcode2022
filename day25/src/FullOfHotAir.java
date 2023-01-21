import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FullOfHotAir {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day25/src/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList SNAFUlist = new ArrayList<>();
        int sum = 0;

        while(scanner.hasNext()){
            String line = scanner.nextLine();

            SNAFUlist.add(line);
            sum += SNAFU.getINSTANCE().SNAFUtoDIGIT(line);
        }

        String snafu = SNAFU.getINSTANCE().DIGITtoSNAFU(sum);

        System.out.println(sum);
        System.out.println(snafu);
    }
}
