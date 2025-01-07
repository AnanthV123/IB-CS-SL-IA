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
                System.out.println("hit");
                startMatch.setVisible(false);
                startPage.getContentPane().removeAll();

                // transition buttons
                JTextField qualNumInput = new JTextField("Qual Number");
                qualNumInput.setBounds(100, 20, 200, 40);
                startPage.add(qualNumInput);
                JTextField teamNameInput = new JTextField("Team Name");
                teamNameInput.setBounds(100, 80, 200, 40);
                startPage.add(teamNameInput);
                JTextField teamNumInput = new JTextField("Team Number");
                teamNumInput.setBounds(100, 140, 200, 40);
                startPage.add(teamNumInput);
                JButton submit = new JButton("Submit");
                submit.setBounds(100, 200, 200, 40);
                submit.setBackground(Color.GRAY);
                startPage.add(submit);
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        int x = Integer.parseInt(qualNumInput.getText());
                        System.out.println(x);
                    }
                });
            }
        });
    }
}