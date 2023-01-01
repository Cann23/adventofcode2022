import java.util.ArrayList;
public class Monkey{
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

    public void setStartingItemsNumbers(Integer value) {
        this.startingItemsNumbers.add(value);
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