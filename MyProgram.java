import javax.swing.*;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProgram
{
    public static void main(String[] args)
    {
        System.out.println("hello world");
        
        JFrame f = new JFrame("Button Example");
        JButton button = new JButton("clicker");
        button.setBounds(50,100,95,30);
        JButton button2 = new JButton("test");
        button2.setBounds(250,100,95,30);
        f.add(button);
        f.add(button2);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        JFrame.setDefaultLookAndFeelDecorated(true);

        // button.addActionListener(new ActionListener() {
        //     Scorecard s = new Scorecard();
        //     public void actionPerformed(ActionEvent e){  
        //         button.setText("Yay");
        //         s.setSpeakerScoreNum(s.getSpeakerScoreNum()+1);
        //         System.out.println(s.getSpeakerScoreNum());
        //     }   
        // });
    }
}
