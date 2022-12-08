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

    public static String part2(ArrayList<String> stringArrayList){
        String firstElement = stringArrayList.get(0);
        String secondElement = stringArrayList.get(1);
        String thirdElement = stringArrayList.get(2);

        Set<Character> charactersFirst = new TreeSet<>();
        for(int i = 0; i < firstElement.length(); i++){
            charactersFirst.add(firstElement.charAt(i));
        }

        Set<Character> charactersSecond = new TreeSet<>();
        for(int i = 0; i < secondElement.length(); i++){
            charactersSecond.add(secondElement.charAt(i));
        }

        Set<Character> charactersThird = new TreeSet<>();
        for(int i = 0; i < thirdElement.length(); i++){
            charactersThird.add(thirdElement.charAt(i));
        }

        charactersFirst.retainAll(charactersSecond);
        charactersFirst.retainAll(charactersThird);

        String result = charactersFirst.toString();

        result = result.substring(1,result.length()-1);
        result = result.replace(", ","");
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/home/e2309755/Intellij/adventofcode/adventofcode/day3/src/input.txt");
        Scanner scanner = new Scanner(file);

        int sumOfPriorities = 0;
        int sumOfPriorities2 = 0;
        int counter = 0;

        Map<Character, Integer> lowerCase = new HashMap<>();
        Map<Character, Integer> upperCase = new HashMap<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

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

            String next = scanner.next();

            //part1
            String commonLetters = checkCompartments(next);

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

            //part2
            if(counter == 3){
                counter = 0;
                //call helper

                String commonLetters2 = part2(stringArrayList);

                for(int size = 0; size < commonLetters2.length(); size++){
                    for(Map.Entry<Character, Integer> element : lowerCase.entrySet()){
                        Character c = element.getKey();
                        Integer val = element.getValue();

                        if(c == commonLetters2.charAt(size)){
                            sumOfPriorities2 += val;
                        }
                    }
                    for(Map.Entry<Character, Integer> element : upperCase.entrySet()){
                        Character c = element.getKey();
                        Integer val = element.getValue();

                        if(c == commonLetters2.charAt(size)){
                            sumOfPriorities2 += val;
                        }
                    }
                }

                stringArrayList.clear();
            }else {
                counter++;
                stringArrayList.add(next);
            }
        }
        System.out.println("sumOfPriorities: " + sumOfPriorities);
        System.out.println("sumOfPriorities2: " + sumOfPriorities2);

    }
}
