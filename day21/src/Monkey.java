public class Monkey {
    private String monkeyName;
    private boolean isSpecificNumber;
    private int specificNumber;
    private String firstOperant;
    private String secondOperant;
    private Character operator;

    public Monkey(String monkeyName, boolean isSpecificNumber, int specificNumber, String firstOperant, String secondOperant, Character operator) {
        this.monkeyName = monkeyName;
        this.isSpecificNumber = isSpecificNumber;
        this.specificNumber = specificNumber;
        this.firstOperant = firstOperant;
        this.secondOperant = secondOperant;
        this.operator = operator;
    }

    public String getMonkeyName() {
        return monkeyName;
    }

    public void setMonkeyName(String monkeyName) {
        this.monkeyName = monkeyName;
    }

    public boolean isSpecificNumber() {
        return isSpecificNumber;
    }

    public void setSpecificNumber(boolean specificNumber) {
        isSpecificNumber = specificNumber;
    }

    public int getSpecificNumber() {
        return specificNumber;
    }

    public void setSpecificNumber(int specificNumber) {
        this.specificNumber = specificNumber;
    }

    public String getFirstOperant() {
        return firstOperant;
    }

    public void setFirstOperant(String firstOperant) {
        this.firstOperant = firstOperant;
    }

    public String getSecondOperant() {
        return secondOperant;
    }

    public void setSecondOperant(String secondOperant) {
        this.secondOperant = secondOperant;
    }

    public Character getOperator() {
        return operator;
    }

    public void setOperator(Character operator) {
        this.operator = operator;
    }
}
