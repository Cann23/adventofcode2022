import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TreeTopHouse {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day8/src/input.txt");
        Scanner scanner = new Scanner(file);

        int height = 0;
        int width = 0;
        int interior_trees = 0;
        ArrayList<String> stringArrayList = new ArrayList<>();

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            width = line.length();
            height++;
            stringArrayList.add(line);
        }

        // for original grid
        char[][] doubleCharArray = new char[width][height];

        // for swapped grid
        char[][] doubleCharArray2 = new char[height][width];


        // filling 2d array
        for(int i = 0; i < stringArrayList.size(); i++){
            for (int j = 0; j < stringArrayList.get(i).length(); j++) {
                doubleCharArray[i][j] = stringArrayList.get(i).charAt(j);
                doubleCharArray2[j][i] = stringArrayList.get(i).charAt(j);
            }
        }

        for(int i = 1; i < stringArrayList.size() - 1; i++){
            for (int j = 1; j < stringArrayList.get(i).length() - 1; j++) {
                // TODO: call helper to find max of each direction
                int flag = 1;

                for(int k = 0; k < j; k++){
                    if(doubleCharArray[i][j] <= doubleCharArray[i][k]){
                        flag = 0;
                    }
                }

                if(flag == 1){
                    interior_trees++;
                    continue;
                }

                flag = 1;

                for(int k = j; k < stringArrayList.get(i).length(); k++){
                    if(doubleCharArray[i][j] <= doubleCharArray[i][k]){
                        flag = 0;
                    }
                }

                if(flag == 1){
                    interior_trees++;
                    continue;
                }

                flag = 1;

                for(int k = 0; k < i ; k++){
                    if(doubleCharArray[i][j] <= doubleCharArray2[k][j]){
                        flag = 0;
                    }
                }

                if(flag == 1){
                    interior_trees++;
                    continue;
                }

                flag = 1;

                for(int k = i; k < stringArrayList.size() ; k++){
                    if(doubleCharArray[i][j] <= doubleCharArray2[k][j]){
                        flag = 0;
                    }
                }

                if(flag == 1){
                    interior_trees++;
                }
            }
        }


        int edgeTrees = height*2 + width*2 - 4;

        System.out.println(interior_trees);
        System.out.println(edgeTrees);
    }
}
