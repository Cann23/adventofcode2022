import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SupplyStacks {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day5/src/input2.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> lineList = new ArrayList<>();
        int stacks = 0;
        int lineLength = 0; // line length according to stack number : (stackNumber * 3) + (stackNumber-1) - 1
        int lineNumber = 0;
        // parse Input

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
                //System.out.println(stacks);
            }
            else{
                lineNumber++;
                lineList.add(line);
            }
        }


        //  create stacks

        ArrayList<ArrayList<Character>> stacksLists = new ArrayList<>();
        for(int i = 0; i < stacks; i++){
            stacksLists.add(new ArrayList<Character>());
        }

        // fill the stacks
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

        // parse commands

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

        // apply commands

        for(int i = 0; i < commandList.size(); i++){
            for(int j = 0; j < Integer.parseInt(parsedList.get(i)[1]); j++){
                stacksLists.get(Integer.parseInt(parsedList.get(i)[5]) - 1)
                        .add(0, stacksLists.get(Integer.parseInt(parsedList.get(i)[3]) - 1).get(0));
                stacksLists.get(Integer.parseInt(parsedList.get(i)[3]) - 1).remove(0);
            }
        }

        //  find the top elements of stacks
        System.out.print("The answer of part 1 --> ");
        for(int i = 0; i < stacks; i++){
            System.out.print(stacksLists.get(i).get(0));
        }

    }
}
