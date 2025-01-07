import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Match {
    private Scorecard qual;
    private Team team;

    public Match(int matchNum, String teamName, int teamNum){
        qual = new Scorecard(matchNum);
        team = new Team(teamName, teamNum);
    }

    public void playMatch(){
        // creating the frame
        JFrame f = new JFrame("Field");
        f.setSize(750,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setBackground(Color.BLACK);
        //JFrame.setDefaultLookAndFeelDecorated(true);
        
        // button for when the team shoots speaker
        JButton speakerButton = new JButton("Speaker");
        speakerButton.setBounds(0,90,95,200);
        speakerButton.setBackground(Color.GRAY);
        // button for when the team shoots amp
        JButton ampButton = new JButton("Amp");
        ampButton.setBounds(200,0,100,60);
        ampButton.setBackground(Color.GRAY);
        // button for trap
        JButton trapButton = new JButton("Trap");
        trapButton.setBounds(200, 125, 100, 100);
        trapButton.setBackground(Color.GRAY);
        // button for ending the match
        JButton endButton = new JButton("End Match");
        endButton.setBounds(650, 300, 100, 100);
        endButton.setBackground(Color.GRAY);

        // adding the buttons to the frame
        f.add(speakerButton);
        f.add(ampButton);
        f.add(trapButton);
        f.add(endButton);

        // making speaker button work
        speakerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual.setSpeakerScoreNum(qual.getSpeakerScoreNum()+1);
                System.out.println("Speaker Score: " + qual.getSpeakerScoreNum());
            }   
        });
        // making amp button work
        ampButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual.setAmpScoreNum(qual1.getAmpScoreNum()+1);
                System.out.println("Amp Score: " + qual.getAmpScoreNum());
            }
        });
        // making trap button work
        trapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual1.setTrap(!qual1.getTrap());
                System.out.println("Trap: " + qual1.getTrap());
            }
        });
        // making end button work
        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f.dispose();
            }
        });
    }
}