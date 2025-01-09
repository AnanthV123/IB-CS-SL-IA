import java.util.ArrayList;

public class Team {
    private String name;
    private int num;
    ArrayList<Scorecard> record = new ArrayList<Scorecard>();

    public Team(String s, int n){
        name = s;
        num = n;
    }

    // Getters
    public String getName(){
        return name;
    }
    public int getNum(){
        return num;
    }

    public boolean addGame(Scorecard sc){
        record.add(sc);
        return true;
    }
}
