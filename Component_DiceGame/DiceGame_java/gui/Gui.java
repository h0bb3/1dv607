package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui implements model.IDiceRolledObserver, ActionListener {

   private JFrame m_mainFrame;
   private JLabel m_statusLabel;
   private JPanel m_dicePanel;
   
   private JButton m_playButton;
   
   private model.DiceGame m_game;

   public Gui() {
     m_game = new model.DiceGame();
     m_game.addSubscriber(this);
     prepareGUI();
   }
   
   public void DiceRolled(int a_faceValue) {
     DiceImage di = new DiceImage();
     m_dicePanel.add(new JLabel(new ImageIcon(di.draw(a_faceValue))));
     m_mainFrame.revalidate();
   }

   public static void main(String[] args){
      Gui gui = new Gui();  
      gui.showEventDemo();
   }
      
   private void prepareGUI(){
      m_mainFrame = new JFrame("Dice Game");
      m_mainFrame.setSize(400,400);
      m_mainFrame.setLayout(new GridLayout(3, 1));

     
      m_playButton = new JButton("Play Game");
      m_playButton.addActionListener(this);
      
      
      m_statusLabel = new JLabel("",JLabel.CENTER);        

      m_statusLabel.setSize(350,100);
      m_mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
         System.exit(0);
         }        
      });    
      m_dicePanel = new JPanel();
      m_dicePanel.setLayout(new FlowLayout());

      m_mainFrame.add(m_playButton);
      m_mainFrame.add(m_dicePanel);
      m_mainFrame.add(m_statusLabel);
      m_mainFrame.setVisible(true);  
   }

   private void showEventDemo(){                  
      m_mainFrame.setVisible(true);  
   }


   public void actionPerformed(ActionEvent e) {
     m_dicePanel.removeAll();
     m_statusLabel.setText("Rolling...");
     m_mainFrame.repaint();
     Runnable r = new Runnable() {
       public void run() {
         if (m_game.play()) {
           m_statusLabel.setText("Yay!!");
         } else {
           m_statusLabel.setText("Sorry...");
         }
       }
     };
     new Thread(r).start();
   }  
}