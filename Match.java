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
        JFrame field = new JFrame("Field");
        field.setSize(750,400);
        field.setLayout(null);
        field.setVisible(true);
        field.setBackground(Color.BLACK);
        
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
        trapButton.setBounds(200, 125, 100, 40);
        trapButton.setBackground(Color.GRAY);

        // button for climb
        JButton climbButton = new JButton("Climb");
        climbButton.setBounds(200, 185, 100, 40);
        climbButton.setBackground(Color.GRAY);

        // button for auton
        JButton autonButton = new JButton("Auton");
        autonButton.setBounds(200, 245, 100, 40);
        autonButton.setBackground(Color.GRAY);

        // text field for comments
        JTextArea commentInput = new JTextArea("Comments");
        commentInput.setBounds(350, 50, 200, 300);

        // button for ending the match
        JButton endButton = new JButton("End Match");
        endButton.setBounds(650, 300, 100, 100);
        endButton.setBackground(Color.GRAY);

        // adding the buttons to the frame
        field.add(speakerButton);
        field.add(ampButton);
        field.add(trapButton);
        field.add(climbButton);
        field.add(commentInput);
        field.add(autonButton);
        field.add(endButton);

        // initializing speaker button (making it work)
        speakerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual.setSpeakerCount(qual.getSpeakerCount()+1);
            }   
        });

        // initializing amp button (making it work)
        ampButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual.setAmpCount(qual.getAmpCount()+1);
            }
        });

        // initializing trap button (making it work)
        trapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual.setTrap(!qual.getTrap());
            }
        });

        // initializing climb button (making it work)
        climbButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual.setClimb(!qual.getClimb());
                System.out.println(qual.getClimb());
            }
        });

        // initializing auton button (making it work)
        autonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual.setAutonCount(qual.getAutonCount()+1);
            }
        });

        // making end button work
        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                field.dispose(); // getting rid of tracking page
                qual.setComments(commentInput.getText()); // accepting input for comments
                qual.calcTotal(); // calculating total score at the end of the game
                MyProgram.menu.setVisible(true); // making main menu visible
                try{
                    team.addGame(qual);
                }
                catch(IOException ee){}
            }
        });
    }
}