import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Match {
    private Scorecard qual;
    private Team team;

    public Match(int matchNum, Team t){
        qual = new Scorecard(matchNum);
        team = t;
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
        // button for climb
        JButton climbButton = new JButton("Climb");
        climbButton.setBounds(200, 250, 100, 40);
        climbButton.setBackground(Color.GRAY);
        // text field for comments
        JTextArea commentInput = new JTextArea("Comments");
        commentInput.setBounds(350, 50, 200, 300);
        // button for ending the match
        JButton endButton = new JButton("End Match");
        endButton.setBounds(650, 300, 100, 100);
        endButton.setBackground(Color.GRAY);

        // adding the buttons to the frame
        f.add(speakerButton);
        f.add(ampButton);
        f.add(trapButton);
        f.add(endButton);
        f.add(climbButton);
        f.add(commentInput);

        // making speaker button work
        speakerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual.setSpeakerCount(qual.getSpeakerCount()+1);
                System.out.println("Speaker Score: " + qual.getSpeakerCount());
            }   
        });
        // making amp button work
        ampButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual.setAmpCount(qual.getAmpCount()+1);
                System.out.println("Amp Score: " + qual.getAmpCount());
            }
        });
        // making trap button work
        trapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual.setTrap(!qual.getTrap());
                System.out.println("Trap: " + qual.getTrap());
            }
        });
        // making end button work
        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                qual.setComments(commentInput.getText());
                MyProgram.menu.setVisible(true);
                try{
                    team.addGame(qual);
                }
                catch(IOException ee){
                    System.out.println("oopsies");
                }
            }
        });
        climbButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual.setClimb(!qual.getClimb());
                System.out.println(qual.getClimb());
            }
        });
    }
}
