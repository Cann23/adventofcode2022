import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MonkeyMath {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day21/src/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<Monkey> monkeys = new ArrayList<>();

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] opearations = line.split(":");

            // parsing input
            if(opearations[1].split("\\+").length == 2){
                monkeys.add(new Monkey(opearations[0],
                        false,
                        -1,
                        opearations[1].trim().split("\\+")[0].trim(),
                        opearations[1].trim().split("\\+")[1].trim(),
                        '+'));
            }
            else if(opearations[1].split("-").length == 2){
                monkeys.add(new Monkey(opearations[0],
                        false,
                        -1,
                        opearations[1].trim().split("-")[0].trim(),
                        opearations[1].trim().split("-")[1].trim(),
                        '-'));
            }
            else if(opearations[1].split("\\*").length == 2){
                monkeys.add(new Monkey(opearations[0],
                        false,
                        -1,
                        opearations[1].trim().split("\\*")[0].trim(),
                        opearations[1].trim().split("\\*")[1].trim(),
                        '*'));
            }
            else if(opearations[1].split("/").length == 2){
                monkeys.add(new Monkey(opearations[0],
                        false,
                        -1,
                        opearations[1].trim().split("/")[0].trim(),
                        opearations[1].trim().split("/")[1].trim(),
                        '/'));
            }
            else {
                monkeys.add(new Monkey(opearations[0],
                        true,
                        Integer.parseInt(opearations[1].trim()),
                        null,
                        null,
                        null));
            }
        }

        for(Monkey monkeyCycle : monkeys) {
            if(monkeyCycle.allMonkeysHasSpecificNumber(monkeys)){
                break;
            }

            for (Monkey monkey : monkeys) {
                if (!monkey.isSpecificNumber()) {
                    int a = monkey.findNumberGivenMonkeyNameAndMonkeysList(monkey.getFirstOperant(), monkeys);
                    int b = monkey.findNumberGivenMonkeyNameAndMonkeysList(monkey.getSecondOperant(), monkeys);

                    if (a != -1 && b != -1) {
                        switch (monkey.getOperator()) {
                            case '-':
                                monkey.setSpecificNumber(a - b);
                                break;
                            case '+':
                                monkey.setSpecificNumber(a + b);
                                break;
                            case '/':
                                monkey.setSpecificNumber(a / b);
                                break;
                            case '*':
                                monkey.setSpecificNumber(a * b);
                                break;
                        }
                    }
                }
                System.out.println(monkey.getMonkeyName() + "-->" + monkey.getSpecificNumber());
            }
            System.out.println("------------------------------------------------------------");
        }

        for(Monkey m : monkeys){
            if(m.getMonkeyName().equals("root")){
                System.out.println("The specific number of root : " + m.getSpecificNumber());
                break;
            }
        }
    }
}
