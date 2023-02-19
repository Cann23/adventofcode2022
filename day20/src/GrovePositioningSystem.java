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

    public static void lookingNumbers(int tempIndex, ArrayList<Integer> list){
        int _1000th = (tempIndex + 1000) % list.size();
        int _2000th = (tempIndex + 2000) % list.size();
        int _3000th = (tempIndex + 3000) % list.size();

        System.out.println("1000: " + _1000th);
        System.out.println("2000: " + _2000th);
        System.out.println("3000: " + _3000th);
        System.out.println("The result: " + (_1000th + _2000th + _3000th));
    }

    public static ArrayList<Integer> decrypting(int value, int tempIndex, ArrayList<Integer> list){
        if(value > 0){
            if(tempIndex + value >= list.size()){
                int modulo = tempIndex + value - list.size();
                for(int i = 0; i < modulo; i++){
                    int tempValue = list.get(tempIndex);
                    list.set(tempIndex, list.get(tempIndex - 1));
                    list.set(tempIndex - 1, tempValue);
                    tempIndex--;
                }
            }
            else{
                for(int i = 0; i < value; i++){
                    int tempValue = list.get(tempIndex);
                    list.set(tempIndex, list.get(tempIndex + 1));
                    list.set(tempIndex + 1, tempValue);
                    tempIndex++;
                }
            }
        }
        else if(value < 0){
            if(tempIndex < Math.abs(value)){
                int modulo = list.size() - tempIndex - Math.abs(value);
                for(int i = 0; i < modulo; i++){
                    int tempValue = list.get(tempIndex);
                    list.set(tempIndex, list.get(tempIndex + 1));
                    list.set(tempIndex + 1, tempValue);
                    tempIndex++;
                }
            }
            else{
                for(int i = 0; i < Math.abs(value); i++){
                    int tempValue = list.get(tempIndex);
                    list.set(tempIndex, list.get(tempIndex - 1));
                    list.set(tempIndex - 1, tempValue);
                    tempIndex--;
                }
            }
        }

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

            // find numbers after "zero"
            int afterZero = findIndex(0, currentCircularList);
            lookingNumbers(afterZero, currentCircularList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
