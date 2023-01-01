import java.util.ArrayList;
public class Monkey{
    public String getNumber() {
        return number;
    }

    private String number;
    private String emptyLine;

    private String startingItems;

    private String operation;
    private String test;

    private String ifTrue;
    private String ifFalse;
    private ArrayList<Integer> startingItemsNumbers = new ArrayList<>();

    private Character operationChar;
    private int operationValue;

    private int testValue;

    private int ifTrueValue;
    private int ifFalseValue;

    public int getIfTrueValue() {
        return ifTrueValue;
    }

    public void setIfTrueValue(int ifTrueValue) {
        this.ifTrueValue = ifTrueValue;
    }

    public int getIfFalseValue() {
        return ifFalseValue;
    }

    public void setIfFalseValue(int ifFalseValue) {
        this.ifFalseValue = ifFalseValue;
    }

    public int getTestValue() {
        return testValue;
    }

    public void setTestValue(int testValue) {
        this.testValue = testValue;
    }

    public Character getOperationChar() {
        return operationChar;
    }

    public void setOperationChar(Character operationChar) {
        this.operationChar = operationChar;
    }

    public int getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(int operationValue) {
        this.operationValue = operationValue;
    }

    public String getIfTrue() {
        return ifTrue;
    }

    public void setIfTrue(String ifTrue) {
        this.ifTrue = ifTrue;
    }

    public String getIfFalse() {
        return ifFalse;
    }

    public void setIfFalse(String ifFalse) {
        this.ifFalse = ifFalse;
    }

    public void setStartingItemsNumbers(Integer value) {
        this.startingItemsNumbers.add(value);
    }

    public void clearStartingItemNumbers(){
        this.startingItemsNumbers.clear();
    }

    public String getTest() {
        return test;
    }

    public ArrayList<Integer> getStartingItemsNumbers() {
        return startingItemsNumbers;
    }

    public String getStartingItems() {
        return startingItems;
    }

    public String getOperation() {
        return operation;
    }

    public Monkey(String number, String emptyLine
            , String startingItems, String operation
            , String test, String ifTrue, String ifFalse) {
        this.number = number;
        this.emptyLine = emptyLine;
        this.startingItems = startingItems;
        this.operation = operation;
        this.test = test;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }
}