import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MonkeyInTheMıddle {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day11/src/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<Monkey> monkeys = new ArrayList<>();

        while (scanner.hasNext()){
            Monkey monkey = new Monkey(scanner.next() + scanner.next()
                                        , scanner.nextLine()
                                        , scanner.nextLine()
                                        , scanner.nextLine()
                                        , scanner.nextLine()
                                        , scanner.nextLine()
                                        , scanner.nextLine());

            monkeys.add(monkey);
        }

        // parse
        for(Monkey monkey : monkeys){
            // parse starting item numbers
            String[] numbers = monkey.getStartingItems().split(":");
            String[] numberStringList = numbers[1].split(", ");
            String[] trimmedNumberStringList = new String[numberStringList.length];

            for(int i = 0; i < numberStringList.length; i++){
                trimmedNumberStringList[i] = numberStringList[i].trim();
                monkey.setStartingItemsNumbers(Integer.parseInt(trimmedNumberStringList[i]));
            }

            // parse operation
            String[] operations = monkey.getOperation().split(" ");
            monkey.setOperationChar(operations[operations.length - 2].charAt(0));
            monkey.setOperationValue(Integer.parseInt(operations[operations.length - 1]));
        }

        // TODO: game loop



        System.out.println("monkey");
    }
}
