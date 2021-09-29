package view.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui implements view.View, ActionListener {

   private JFrame m_mainFrame;
   private JLabel m_statusLabel;
   private JPanel m_dicePanel;
   
   private JButton m_playButton;
   
    private boolean m_doPlay;
    private boolean m_doQuit;

   public Gui() {
     prepareGUI();
   }
   
   public void DiceRolled(int a_faceValue) {
     DiceImage di = new DiceImage();
     m_dicePanel.add(new JLabel(new ImageIcon(di.draw(a_faceValue))));
     m_mainFrame.revalidate();
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
          m_doQuit = true;
         }        
      });    
      m_dicePanel = new JPanel();
      m_dicePanel.setLayout(new FlowLayout());

      m_mainFrame.add(m_playButton);
      m_mainFrame.add(m_dicePanel);
      m_mainFrame.add(m_statusLabel);
      m_mainFrame.setVisible(true);

      m_doPlay = true;
   }


   public void actionPerformed(ActionEvent e) {
     m_dicePanel.removeAll();
     m_mainFrame.repaint();
     m_doPlay = true;
   }

  @Override
  public void showWelcomeMessage() {
    m_doPlay = false;
    m_dicePanel.removeAll();
    m_statusLabel.setText("Rolling....");
    
  }

  @Override
  public void showWinningMessage() {
    m_statusLabel.setText("Yay!!");
    
  }

  @Override
  public void showLoosingMessage() {
    m_statusLabel.setText("Sorry...");
    
  }

  @Override
  public boolean promptQuitMessage() {
    // sleep the main thread until player has decided on an action
    m_doQuit = false;
    m_doPlay = false;
    while (m_doQuit == false && m_doPlay == false) {
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
      }
    }
    m_doPlay = false;
    if (m_doQuit) {
      m_mainFrame.dispose();
    }
    return m_doQuit;
  }

  @Override
  public void showDiceRolledMessage(int diceValue) {
    DiceImage di = new DiceImage();
    m_dicePanel.add(new JLabel(new ImageIcon(di.draw(diceValue))));
    m_mainFrame.revalidate();
  }  
}