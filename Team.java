import java.util.ArrayList;

public class Team {
    public String name;
    public int num;
    ArrayList<Scorecard> record;

    public Team(String s, int n){
        name = s;
        num = n;
        record = new ArrayList<Scorecard>();
    }

    public boolean addGame(Scorecard sc){
        record.add(sc);
        return true;
    }
    
    public ArrayList<Scorecard> getRecord(){
        return record;
    }

}
