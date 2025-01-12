public class Scorecard {
    private int gameNum;
    private int speakerCount;
    private int ampCount;
    private int autonScoreNum;
    private boolean trap;
    private boolean climb;
    private int totalScore;

    // Constructor
    public Scorecard(int g){
        gameNum = g;
        speakerCount = 0;
        ampCount = 0;
        autonScoreNum = 0;
        trap = false;
        climb = false;
        totalScore = 0;
    }

    public void calcTotal(){
        totalScore += speakerCount*5 + ampCount*2;
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
    public int getAutonScoreNum(){
        return autonScoreNum;
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
    public void setAutonScoreNum(int au){
        autonScoreNum = au;
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
}
