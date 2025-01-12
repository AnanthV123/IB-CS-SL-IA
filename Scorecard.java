public class Scorecard {
    private int gameNum;
    private int speakerCount;
    private int ampCount;
    private int autonCount;
    private boolean trap;
    private boolean climb;
    private int totalScore;
    private String comments;

    // Constructor
    public Scorecard(int g){
        gameNum = g;
        speakerCount = 0;
        ampCount = 0;
        autonCount = 0;
        trap = false;
        climb = false;
        totalScore = 0;
        comments = "";
    }

    // calculates total score
    public void calcTotal(){
        totalScore += speakerCount*2 + ampCount*1 + autonCount*5;
        if(trap){totalScore += 5;}
        if(climb){totalScore += 3;}
    }

    // Getters
    public int getGameNum(){
        return gameNum;
    }
    public int getSpeakerCount(){
        return speakerCount;
    }
    public int getAmpCount(){
        return ampCount;
    }
    public int getAutonCount(){
        return autonCount;
    }
    public boolean getTrap(){
        return trap;
    }
    public boolean getClimb(){
        return climb;
    }
    public int getTotalScore(){
        return totalScore;
    }
    public String getComments(){
        return comments;
    }

    // Setters
    public void setGameNum(int g){
        gameNum = g;
    }
    public void setSpeakerCount(int s){
        speakerCount = s;
    }
    public void setAmpCount(int am){
        ampCount = am;
    }
    public void setAutonCount(int au){
        autonCount = au;
    }
    public void setTrap(boolean t){
        trap = t;
    }
    public void setClimb(boolean c){
        climb = c;
    }
    public void setTotalScore(int ts){
        totalScore = ts;
    }
    public void setComments(String s){
        comments = s;
    }
}
