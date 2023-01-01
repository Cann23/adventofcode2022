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
            if(operations[operations.length - 1].equals("old")){
                monkey.setOperationValue(-1);
            }
            else{
                monkey.setOperationValue(Integer.parseInt(operations[operations.length - 1]));
            }

            // parse test
            String[] tests = monkey.getTest().split(" ");
            monkey.setTestValue(Integer.parseInt(tests[tests.length - 1]));

            // parse ifTrue
            String[] ifTrues = monkey.getIfTrue().split(" ");
            monkey.setIfTrueValue(Integer.parseInt(ifTrues[ifTrues.length - 1]));

            // parse ifFalse
            String[] ifFalses = monkey.getIfFalse().split(" ");
            monkey.setIfFalseValue(Integer.parseInt(ifFalses[ifFalses.length - 1]));
        }

        // game loop
        for(Monkey monkey : monkeys){
            for(int i = 0 ; i < monkey.getStartingItemsNumbers().size(); i++){
                int itemWorryLevel = monkey.getStartingItemsNumbers().get(i);
                int operatedValue = itemWorryLevel;
                switch (monkey.getOperationChar()){
                    case '-':
                        if(monkey.getOperationValue() == -1){
                            operatedValue -= operatedValue;
                        }
                        else{
                            operatedValue -= monkey.getOperationValue();
                        }
                        break;
                    case '+':
                        if(monkey.getOperationValue() == -1){
                            operatedValue += operatedValue;
                        }
                        else{
                            operatedValue += monkey.getOperationValue();
                        }
                        break;
                    case '*':
                        if(monkey.getOperationValue() == -1){
                            operatedValue *= operatedValue;
                        }
                        else{
                            operatedValue *= monkey.getOperationValue();
                        }
                        break;
                    case '/':
                        if(monkey.getOperationValue() == -1){
                            operatedValue /= operatedValue;
                        }
                        else{
                            operatedValue /= monkey.getOperationValue();
                        }
                        break;
                }

                // Monkey gets bored with item. Worry level is divided by 3
                operatedValue = Math.round(operatedValue / 3);

                // whether Current worry level TEST field
                if(operatedValue % monkey.getTestValue() == 0){
                    // ifTrue
                    monkeys.get(monkey.getIfTrueValue()).setStartingItemsNumbers(operatedValue);
                }
                else{
                    // ifFalse
                    monkeys.get(monkey.getIfFalseValue()).setStartingItemsNumbers(operatedValue);
                }
            }
            monkey.clearStartingItemNumbers();
        }



        System.out.println("monkey");
    }
}
