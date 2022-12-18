import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CathodeRayTube {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day10/src/input2.txt");
        Scanner scanner = new Scanner(file);

        int registerX = 1;
        int cycleNumber = 0;
        int total = 0;

        int[] strength = {20,60,100,140,180,220};

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String[] strings = line.split(" ");
            if(strings.length == 1){        // noop, 1 cycle
                cycleNumber++;

                for(int element : strength){
                    if(cycleNumber == element){
                        total = total + cycleNumber * registerX;
                    }
                }
            }
            else{       // addx V , 2 cycles
                cycleNumber++;

                for(int element : strength){
                    if(cycleNumber == element){
                        total = total + cycleNumber * registerX;
                    }
                }

                cycleNumber++;

                for(int element : strength){
                    if(cycleNumber == element){
                        total = total + cycleNumber * registerX;
                    }
                }

                registerX += Integer.parseInt(strings[1]);
            }
        }

        System.out.println("total: " + total);
    }
}
