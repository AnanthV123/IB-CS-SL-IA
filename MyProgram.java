import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyProgram
{
    public static JFrame menu;
    public static void main(String[] args)
    {
        // initializing the start menu
        menu = new JFrame("Start Menu");
        menu.setSize(400,400);
        menu.setLayout(null);
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);
        menu.setVisible(true);

        // declaring and initializing buttons
        // button to start tracking a match
        JButton startMatch = new JButton("Start Match");
        startMatch.setBounds(100, 20, 200, 40);
        startMatch.setBackground(Color.GRAY);

        // button to retrieve info about the team
        JButton teamInfo = new JButton("Retrieve Team Information");
        teamInfo.setBounds(100, 80, 200, 40);
        teamInfo.setBackground(Color.GRAY);

        // adding buttons to the frame
        menu.add(startMatch);
        menu.add(teamInfo);

        // making start match button work
        startMatch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                // creating page to accept user input to declare and initialize a match
                JDialog matchInputPage = new JDialog(menu, "Match Input Page", true);
                matchInputPage.setLayout(null);
                matchInputPage.setSize(400, 400);
                matchInputPage.setResizable(false);
                matchInputPage.setLocationRelativeTo(null);

                // inputs for qual/team details
                JTextField qualNumInput = new JTextField("Qual Number");
                qualNumInput.setBounds(100, 20, 200, 40);
                matchInputPage.add(qualNumInput);

                JTextField teamNameInput = new JTextField("Team Name");
                teamNameInput.setBounds(100, 80, 200, 40);
                matchInputPage.add(teamNameInput);

                JTextField teamNumInput = new JTextField("Team Number");
                teamNumInput.setBounds(100, 140, 200, 40);
                matchInputPage.add(teamNumInput);

                // button to accept the inputs and start the match
                JButton submit = new JButton("Submit");
                submit.setBounds(100, 200, 200, 40);
                submit.setBackground(Color.GRAY);

                // making submit button work
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        try{
                            int qualNum = Integer.parseInt(qualNumInput.getText());
                            String teamName = teamNameInput.getText();
                            int teamNum = Integer.parseInt(teamNumInput.getText());

                            Team team = new Team();
                            boolean check = true;
                            for (int i = 0; i < Team.teamList.size(); i++){
                                if (teamNum == Team.teamList.get(i).getNum()){
                                    team = Team.teamList.get(i);
                                    check = false;
                                }
                            }
                            if (check){
                                team = new Team(teamName, teamNum);
                                Team.teamList.add(team);
                            }

                            Match m = new Match(qualNum, team);
                            m.playMatch();
                            matchInputPage.dispose();
                            menu.setVisible(false);
                        }
                        catch(NumberFormatException ime){
                            JLabel l = new JLabel("Please enter appropriate values.");
                            l.setBounds(100, 260, 200, 40);
                            l.setVisible(true);
                            matchInputPage.add(l);
                            matchInputPage.revalidate();
                            matchInputPage.repaint();
                        }
                    }
                });
                matchInputPage.add(submit);
                matchInputPage.setVisible(true);
            }
        });
        teamInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                JFrame teamInputPage = new JFrame("Team Information Page");
                teamInputPage.setLayout(null);
                teamInputPage.setSize(400, 400);
                teamInputPage.setLocationRelativeTo(null);

                JTextField teamNumInput = new JTextField("Team Number");
                teamNumInput.setBounds(100, 20, 200, 40);
                teamInputPage.add(teamNumInput);

                JButton submit = new JButton("Submit");
                submit.setBounds(100, 80, 200, 40);
                submit.setBackground(Color.GRAY);
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        
                        try{
                            int teamNum = Integer.parseInt(teamNumInput.getText());
                            
                            Team team = new Team();
                            for (int i = 0; i < Team.teamList.size(); i++){
                                if (teamNum == Team.teamList.get(i).getNum()){
                                    team = Team.teamList.get(i);
                                }
                            }

                            JFrame dataDisplay = new JFrame("Data Display");
                            dataDisplay.setSize(2000, 1000);
                            dataDisplay.setLayout(null);
                            
                        }
                        catch(NumberFormatException ime){
                            JLabel l = new JLabel("Please enter appropriate values.\"");
                            l.setBounds(100, 140, 200, 40);
                            teamInputPage.add(l);
                            l.setVisible(true);
                            teamInputPage.revalidate();
                            teamInputPage.repaint();
                        }
                    }
                });

                JButton exitButton = new JButton("Exit");
                exitButton.setBounds(0, 0, 75, 20);
                exitButton.setBackground(Color.GRAY);
                exitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        teamInputPage.dispose();
                    }
                });
                teamInputPage.add(exitButton);
                teamInputPage.add(submit);
                teamInputPage.setVisible(true);
            }
        });
    }
}