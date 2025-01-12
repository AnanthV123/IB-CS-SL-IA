import java.io.*;
import java.util.ArrayList;

public class Team {
    private String name;
    private int num;
    private ArrayList<Scorecard> record = new ArrayList<Scorecard>();
    public File data;
    public static ArrayList<Team> teamList = new ArrayList<Team>();

    public Team(){
        name = "";
        num = 0;
        data = new File(num + "_Data.txt");
    }
    public Team(String s, int n){
        name = s;
        num = n;
        data = new File(num + "_Data.txt");
    }

    // Getters
    public String getName(){
        return name;
    }
    public int getNum(){
        return num;
    }

    public boolean addGame(Scorecard sc) throws IOException{
        record.add(sc);
        updateDataFile(sc);
        return true;
    }
    public String toString(){
        return name + " " + num;
    }
    public void updateDataFile(Scorecard sc) throws IOException{
        FileWriter fw = new FileWriter(data, true);
        fw.write("\nQualification " + sc.getGameNum() + "\nSpeaker Count: " + sc.getSpeakerCount() + "\nAmp Count: " + sc.getAmpCount() + "\nAuton Count: " + sc.getAutonCount() + "\nTrap: " + sc.getTrap() + "\nClimb: " + sc.getClimb() + "\nTotal Score: " + sc.getTotalScore() + "\nComments:\n" + sc.getComments() + System.lineSeparator());
        fw.close();
    }
}
