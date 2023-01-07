import java.util.ArrayList;

public class Valves {
    private String valveName;
    private int rate;

    private ArrayList<String> leadToValvesList;

    public Valves(String valveName, int rate, ArrayList<String> leadToValvesList) {
        this.valveName = valveName;
        this.rate = rate;
        this.leadToValvesList = leadToValvesList;
    }

    public String getValveName() {
        return valveName;
    }

    public void setValveName(String valveName) {
        this.valveName = valveName;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public ArrayList<String> getLeadToValvesList() {
        return leadToValvesList;
    }

    public void setLeadToValvesList(ArrayList<String> leadToValvesList) {
        this.leadToValvesList = leadToValvesList;
    }


}
