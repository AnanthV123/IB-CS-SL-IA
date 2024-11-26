import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProgram
{
    public static void main(String[] args)
    {
        // creating the frame
        JFrame f = new JFrame("Field");
        f.setSize(750,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setBackground(Color.BLACK);
        JFrame.setDefaultLookAndFeelDecorated(true);
        
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

        // adding the buttons to the frame
        f.add(speakerButton);
        f.add(ampButton);
        f.add(trapButton);

        // declaring team and scorecard
        Scorecard qual1 = new Scorecard(1);
        Team  infuzed = new Team("Infuzed", 6908);

        // making speaker button work
        speakerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual1.setSpeakerScoreNum(qual1.getSpeakerScoreNum()+1);
                System.out.println("Speaker Score: " + qual1.getSpeakerScoreNum());
            }   
        });

        // making amp button work
        ampButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual1.setAmpScoreNum(qual1.getAmpScoreNum()+1);
                System.out.println("Amp Score: " + qual1.getAmpScoreNum());
            }
        });

        // making trap button work
        trapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                qual1.setTrap(!qual1.getTrap());
                System.out.println("Trap: " + qual1.getTrap());
            }
        });
    }
}
