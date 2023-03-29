import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LastManStanding implements ActionListener{
    public static void main(String[] args){
        new LastManStanding();
    }

    private JFrame frame;
    private JPanel contentPane, twoPanelContainer, panel1, panel2;
    private JButton end_turn_button, end_game;
    private final JLabel lblPlayer = new JLabel(""), instruction;
    private JCheckBox[] checkboxes = new JCheckBox[10];
    public int iterator = 0, iteration = 0, count = 0;

    public LastManStanding(){
        //prompt mechaniccs before game starts
        instruction = new JLabel("<html><center>Player chooses one, two, or three boxes<br>and then click End Turn to end turn<br>Then computer will randomly select one,<br>two, or three, until the last box is selected");
        JOptionPane.showMessageDialog(frame, instruction, "Last Man Standing Mechanics", JOptionPane.DEFAULT_OPTION);

        //layout
        frame = new JFrame();
        contentPane = new JPanel(new GridLayout(3,1));
        panel1 = new JPanel();

        //loop and create 10 boxes
        setBoxes();

        //loop and validate checkbox status
        validateBoxes();
        
        //status pane
        panel2 = new JPanel();
        panel2.setBackground(Color.DARK_GRAY);
        lblPlayer.setForeground(Color.LIGHT_GRAY);
        panel2.add(lblPlayer);

        //buttons
        twoPanelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        end_turn_button = new JButton("End Turn"); end_turn_button.addActionListener(this);
        end_game = new JButton("Play Again"); end_game.addActionListener(this);
        twoPanelContainer.add(end_turn_button);
        twoPanelContainer.add(end_game);
        twoPanelContainer.setBorder(BorderFactory.createEmptyBorder(20,10,30,10));

        //main display
        contentPane.add(panel1);
        contentPane.add(panel2);
        contentPane.add(twoPanelContainer);

        setConfig();
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == end_game){
            for(int i = 0; i < checkboxes.length; checkboxes[i].setSelected(false), checkboxes[i].setEnabled(true), i++); count = 0;
            lblPlayer.setText("Player's Turn");
        } 
        if(e.getSource() == end_turn_button) {
            if(iterator == 1 && count == checkboxes.length){
                lblPlayer.setText("<html><center>Player Wins!");
            } else if(iterator == 0 && count == checkboxes.length) {
                lblPlayer.setText("<html><center>Computer Wins!");
            } else if(iterator == 0) {
                lblPlayer.setText("<html><center>Player's Turn<br>Boxes Checked: " + Integer.toString(count)); iterator++;
            } else if(iterator == 1) {
                int min = 1, max = 3, iteration = 0;
                int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
                for(int i = 0; i < checkboxes.length;){
                    if(checkboxes[i].isSelected()){ i++; }
                    else {
                        if(iteration != random_int){
                            checkboxes[i].setSelected(true); i++; iteration++; 
                        } else { break; }
                    }
                }
                lblPlayer.setText("<html><center>Computer's Turn<br>Boxes Checked: " + Integer.toString(count));
                iterator--; end_turn_button.doClick(1);
            }
        }
    }//end of action

    public void setBoxes(){
        for(int i = 0; i < checkboxes.length; i++){
            checkboxes[i] = new JCheckBox();
            panel1.add(checkboxes[i]);
        }
    }

    public void validateBoxes(){
        for(int i = 0; i < checkboxes.length; i++){
            checkboxes[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange() == 1 && (e.getSource() instanceof JCheckBox)){
                        count++; ((JCheckBox) e.getSource()).setEnabled(false);
                    }
                }
            });
        }
    }

    public void setConfig(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.setTitle("Last Man Standing");
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}//end of class
