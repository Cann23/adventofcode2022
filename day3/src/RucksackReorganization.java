import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RucksackReorganization {

    public static String checkCompartments(String str){
        String strFirstHalf = str.substring(0, str.length()/2);
        String strSecondHalf = str.substring(str.length()/2,str.length());

        Set common = new HashSet();
        for(int k = 0; k < strFirstHalf.length(); k++){
            for( int j = 0; j < strSecondHalf.length(); j++){
                if(strFirstHalf.charAt(k) == strSecondHalf.charAt(j)){
                    common.add(strFirstHalf.charAt(k));
                }
            }
        }


        String result = common.toString();

        result = result.substring(1,result.length()-1);
        result = result.replace(", ","");
        return result;

    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day3/src/input2.txt");
        Scanner scanner = new Scanner(file);

        int sumOfPriorities = 0;

        Map<Character, Integer> lowerCase = new HashMap<>();
        Map<Character, Integer> upperCase = new HashMap<>();

        // loading lowercase
        int value = 1;
        for(char i = 'a'; i <= 'z'; i++){
            lowerCase.put(i, value);
            value++;
        }

        // loading uppercase
        int value2 = 27;
        for(char i = 'A'; i <= 'Z'; i++){
            upperCase.put(i, value2);
            value2++;
        }

        while(scanner.hasNext()){
            String commonLetters = checkCompartments(scanner.next());

            for(int size = 0; size < commonLetters.length(); size++){
                for(Map.Entry<Character, Integer> element : lowerCase.entrySet()){
                    Character c = element.getKey();
                    Integer val = element.getValue();

                    if(c == commonLetters.charAt(size)){
                        sumOfPriorities += val;
                    }
                }
                for(Map.Entry<Character, Integer> element : upperCase.entrySet()){
                    Character c = element.getKey();
                    Integer val = element.getValue();

                    if(c == commonLetters.charAt(size)){
                        sumOfPriorities += val;
                    }
                }
            }
        }
        System.out.println("sumOfPriorities: " + sumOfPriorities);

    }
}
