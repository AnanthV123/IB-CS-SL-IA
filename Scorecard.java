public class Scorecard {
    private int gameNum;
    private int speakerScoreNum;
    private int ampScoreNum;
    private int autonScoreNum;
    private boolean parked;
    private boolean trap;
    private boolean climb;
    private int totalScore;

    // Constructor
    public Scorecard(int g){
        gameNum = g;
        speakerScoreNum = 0;
        ampScoreNum = 0;
        autonScoreNum = 0;
        parked = false;
        trap = false;
        climb = false;
        totalScore = 0;
    }

    // Getters
    public int getGameNum(){
        return gameNum;
    }
    public int getSpeakerScoreNum(){
        return speakerScoreNum;
    }
    public int getAmpScoreNum(){
        return ampScoreNum;
    }
    public int getAutonScoreNum(){
        return autonScoreNum;
    }
    public boolean getParked(){
        return parked;
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
    public void setSpeakerScoreNum(int s){
        speakerScoreNum = s;
    }
    public void setAmpScoreNum(int am){
        ampScoreNum = am;
    }
    public void setAutonScoreNum(int au){
        autonScoreNum = au;
    }
    public void setParked(boolean p){
        parked = p;
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
