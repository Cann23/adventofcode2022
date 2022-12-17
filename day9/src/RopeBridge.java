import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RopeBridge {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day9/src/input2.txt");
        Scanner scanner = new Scanner(file);

        Set<String> path = new HashSet<>();
        //HashMap<Character, Integer> commands = new HashMap<>();

        int verticalT = 0;
        int horizontalT = 0;
        int verticalH = 0;
        int horizontalH = 0;
        String horizontalLocation = "x";
        String verticalLocation = "y";


        // initial point. x and y
        path.add(horizontalLocation + horizontalT + verticalLocation + verticalT);

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] command = line.split(" ");
            //commands.put(command[0].charAt(0), Integer.parseInt(command[1]));

            for(int i = 0; i < Integer.parseInt(command[1]); i++){
                switch (command[0].charAt(0)){
                    case 'R':
                        horizontalH++;
                        if(horizontalH > horizontalT + 1){
                            if(verticalH == verticalT){
                                horizontalT++;
                            }
                            else if(verticalH > verticalT){
                                horizontalT++;
                                verticalT++;
                            }
                            else if(verticalH < verticalT){
                                horizontalT++;
                                verticalT--;
                            }
                        }
                        break;
                    case 'L':
                        horizontalH--;
                        if(horizontalH < horizontalT - 1){
                            if(verticalH == verticalT){
                                horizontalT--;
                            }
                            else if(verticalH > verticalT){
                                horizontalT--;
                                verticalT++;
                            }
                            else if(verticalH < verticalT){
                                horizontalT--;
                                verticalT--;
                            }
                        }
                        break;
                    case 'U':
                        verticalH++;
                        if(verticalH > verticalT + 1){
                            if(horizontalH == horizontalT){
                                verticalT++;
                            }
                            else if(horizontalH > horizontalT){
                                verticalT++;
                                horizontalT++;
                            }
                            else if(horizontalH < horizontalT){
                                verticalT++;
                                horizontalT--;
                            }
                        }
                        break;
                    case 'D':
                        verticalH--;
                        if(verticalH < verticalT - 1){
                            if(horizontalH == horizontalT){
                                verticalT--;
                            }
                            else if(horizontalH > horizontalT){
                                verticalT--;
                                horizontalT++;
                            }
                            else if(horizontalH < horizontalT){
                                verticalT--;
                                horizontalT--;
                            }
                        }
                        break;
                }
                path.add(horizontalLocation + horizontalT + verticalLocation + verticalT);
            }

            System.out.println(path);
        }

        System.out.println(path.size());

    }
}
