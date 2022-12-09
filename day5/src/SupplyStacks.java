import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SupplyStacks {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day5/src/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> lineList = new ArrayList<>();
        int stacks = 0;
        int lineLength = 0; // line length according to stack number : (stackNumber * 3) + (stackNumber-1) - 1
        int lineNumber = 0;
        //TODO: parse Input

        while(scanner.hasNext()){
            // stack parse
            String line = scanner.nextLine();
            if(line.equals("")){
                break;
            }
            else if(line.charAt(1) == '1'){
                lineLength = line.length();
                char temp =  line.charAt(line.length()-1);
                stacks = Character.getNumericValue(temp);
                System.out.println(stacks);
            }
            else{
                lineNumber++;
                lineList.add(line);
            }
        }


        // TODO: create stacks

        ArrayList<ArrayList<Character>> stacksLists = new ArrayList<>();
        for(int i = 0; i < stacks; i++){
            stacksLists.add(new ArrayList<Character>());
        }

        // TODO: fill the stacks
        for(int l = 0; l < lineNumber; l++){
            int index = 1;
            int stackNum = 0;
            while(index < lineList.get(l).length()){
                if(lineList.get(l).charAt(index) != ' '){
                    stacksLists.get(stackNum).add(lineList.get(l).charAt(index));
                }

                if(stackNum < stacks){
                    stackNum++;
                }
                else{
                    break;
                }
                index += 4;
            }
        }

        // TODO: parse commands

        ArrayList<String> commandList = new ArrayList<>();

        while (scanner.hasNext()){
            String command = scanner.nextLine();
            commandList.add(command);
        }


        ArrayList<String[]> parsedList = new ArrayList<>();

        for(int i = 0; i < commandList.size(); i++){
            String[] commandParsed = commandList.get(i).split(" ");
            parsedList.add(commandParsed);
        }

        // TODO: apply commands

        // TODO: find the top elements of stacks

        System.out.println("hey");
    }
}
