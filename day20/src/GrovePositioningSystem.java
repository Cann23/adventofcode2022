import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GrovePositioningSystem {
    public static int findIndex(int value, ArrayList<Integer> list){
        for(int i = 0 ; i < list.size(); i++){
            if(value == list.get(i)){
                return i;
            }
        }

        return -1;
    }

    public static ArrayList<Integer> decrypting(int value, int tempIndex, ArrayList<Integer> list){
        if(value > 0){
            //TODO: out of size will be added
            for(int i = 0; i < value; i++){
                int tempValue = list.get(tempIndex);
                list.set(tempIndex, list.get(tempIndex + 1));
                list.set(tempIndex + 1, tempValue);
                tempIndex++;
            }
        }
        // other cases will be added

        return list;
    }

    public static void main(String[] args) {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day20/src/input.txt");
        ArrayList<Integer> initialcircularList = new ArrayList<>();

        int tempIndex;

        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()){
                String line = scanner.nextLine();
                initialcircularList.add(Integer.parseInt(line));
            }

            ArrayList<Integer> currentCircularList = new ArrayList<>();

            for(int i = 0; i < initialcircularList.size(); i++){
                currentCircularList.add(initialcircularList.get(i));
            }

            System.out.println("Initial arrangement:");
            System.out.println(currentCircularList);

            for(int element : initialcircularList){
                tempIndex = findIndex(element, currentCircularList);
                decrypting(element, tempIndex, currentCircularList);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
