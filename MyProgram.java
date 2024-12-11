import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class MyProgram
{
    public static void main(String[] args)
    {
        JFrame startPage = new JFrame("Start Menu");
        startPage.setSize(400,400);
        startPage.setLayout(null);
        startPage.setVisible(true);
        startPage.setBackground(Color.BLACK);
        //JFrame.setDefaultLookAndFeelDecorated(true);

        // button to start tracking a match
        JButton startMatch = new JButton("Start Match");
        startMatch.setBounds(100, 20, 200, 40);
        startMatch.setBackground(Color.GRAY);

        // adding buttons to the frame
        startPage.add(startMatch);

        // making start match button work
        startMatch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Match.playMatch();
                //startPage.setVisible(false);
            }
        });
    }
}
