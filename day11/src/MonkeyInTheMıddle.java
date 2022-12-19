import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Monkey{
    private String number;
    private String emptyLine;
    private String startingItems;
    private String operation;
    private String test;
    private String ifTrue;
    private String ifFalse;

    public Monkey(String number, String emptyLine
            , String startingItems, String operation
            , String test, String ifTrue, String ifFalse) {
        this.number = number;
        this.emptyLine = emptyLine;
        this.startingItems = startingItems;
        this.operation = operation;
        this.test = test;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }
}

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

        System.out.println("monkey");
    }
}
