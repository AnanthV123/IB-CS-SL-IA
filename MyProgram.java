import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

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

        // declaring buttons
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

        // initializing start match button (making it work)
        startMatch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                // creating page to accept user input to declare and initialize a match
                JDialog matchInputPage = new JDialog(menu, "Match Input Page", true);
                matchInputPage.setLayout(null);
                matchInputPage.setSize(400, 400);
                matchInputPage.setResizable(false);
                matchInputPage.setLocationRelativeTo(null);

                // inputs for qual/team details
                // match number input
                JTextField qualNumInput = new JTextField("Qual Number");
                qualNumInput.setBounds(100, 20, 200, 40);

                // team name input
                JTextField teamNameInput = new JTextField("Team Name");
                teamNameInput.setBounds(100, 80, 200, 40);

                // team number input
                JTextField teamNumInput = new JTextField("Team Number");
                teamNumInput.setBounds(100, 140, 200, 40);

                // adding inputs to the input page
                matchInputPage.add(qualNumInput);
                matchInputPage.add(teamNameInput);
                matchInputPage.add(teamNumInput);

                // button to accept the inputs and start the match
                JButton submitButton = new JButton("Submit");
                submitButton.setBounds(100, 200, 200, 40);
                submitButton.setBackground(Color.GRAY);
                matchInputPage.add(submitButton);

                // initializing submit button (making it work)
                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        try{
                            // taking in inputs
                            int qualNum = Integer.parseInt(qualNumInput.getText()); // accepting match number input
                            String teamName = teamNameInput.getText(); // accepting team name input
                            int teamNum = Integer.parseInt(teamNumInput.getText()); // accepting team number input

                            // checking if there is already a team with the same team number
                            // if there is, it equates the team variable to the pre-existing team
                            // if not, it creates a new team
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

                            // initializing match (setting up page to start the match data collection)
                            Match m = new Match(qualNum, team);
                            m.playMatch();
                            matchInputPage.dispose();
                            menu.setVisible(false);
                        }
                        catch(NumberFormatException ime){
                            // displays error message for the user in case they input incorrectly
                            JLabel errorMsg = new JLabel("Please enter appropriate values.");
                            errorMsg.setBounds(100, 260, 200, 40);
                            errorMsg.setVisible(true);
                            matchInputPage.add(errorMsg);
                            matchInputPage.revalidate();
                            matchInputPage.repaint();
                        }
                    }
                });

                // button to exit from the information page
                JButton exitButton = new JButton("Exit");
                exitButton.setBounds(0, 0, 75, 20);
                exitButton.setBackground(Color.GRAY);
                matchInputPage.add(exitButton);

                // initializing exit button (making it work)
                exitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        matchInputPage.dispose();
                    }
                });

                matchInputPage.setVisible(true);
            }
        });

        // initializing retrieve information button (making it work)
        teamInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // creating page to accept input for which team to choose
                JFrame teamInputPage = new JFrame("Team Information Page");
                teamInputPage.setLayout(null);
                teamInputPage.setSize(400, 400);
                teamInputPage.setLocationRelativeTo(null);

                // team number input
                JTextField teamNumInput = new JTextField("Team Number");
                teamNumInput.setBounds(100, 20, 200, 40);
                teamInputPage.add(teamNumInput);

                // button to accept the input and return the information
                JButton submitButton = new JButton("Submit");
                submitButton.setBounds(100, 80, 200, 40);
                submitButton.setBackground(Color.GRAY);
                teamInputPage.add(submitButton);

                // initializing submit button (making it work)
                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        try{
                            int teamNum = Integer.parseInt(teamNumInput.getText()); // accepting team number input
                        
                            // retrieving the necessary file and displaying it
                            final File innerData = new File(teamNum + "_Data.txt");
                            SwingUtilities.invokeLater(() -> {
                                JFrame dataDisplay = new JFrame(teamNum + " Data");
                                JTextArea textArea = new JTextArea(20, 40);
                                JScrollPane scrollPane = new JScrollPane(textArea);
                                try (BufferedReader reader = new BufferedReader(new FileReader(innerData))) {
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        textArea.append(line + "\n");
                                    }
                                } catch (IOException ee) {
                                    textArea.setText("No current information on team " + teamNum);
                                }
                                dataDisplay.add(scrollPane);
                                dataDisplay.pack();
                                dataDisplay.setLocationRelativeTo(null);
                                dataDisplay.setVisible(true);
                            });
                        }
                        catch(NumberFormatException ime){
                            // displays error message for the user in case they input incorrectly
                            JLabel errorMsg = new JLabel("Please enter appropriate values.\"");
                            errorMsg.setBounds(100, 140, 200, 40);
                            errorMsg.setVisible(true);
                            teamInputPage.add(errorMsg);
                            teamInputPage.revalidate();
                            teamInputPage.repaint();
                        }
                    }
                });

                // button to exit from the information page
                JButton exitButton = new JButton("Exit");
                exitButton.setBounds(0, 0, 75, 20);
                exitButton.setBackground(Color.GRAY);
                teamInputPage.add(exitButton);

                // initializing exit button (making it work)
                exitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        teamInputPage.dispose();
                    }
                });

                teamInputPage.setVisible(true);
            }
        });
    }
}