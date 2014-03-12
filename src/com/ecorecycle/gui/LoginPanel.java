package com.ecorecycle.gui;


import javax.swing.JPanel;

import com.ecorecycle.control.RecycleMonitorController;
import com.ecorecycle.gui.RmosMainMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import javax.swing.*;
 
public class LoginPanel {
	
   public static void createAndShowUI() {
      LoginPanell login = new LoginPanell();
      int response = JOptionPane.showConfirmDialog(null, login, "Recycle Monitoring System", 
               JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
       
      if (response == JOptionPane.OK_OPTION) {
         String name = login.getName();
         String pWord = login.getPassword();
          
         if (name.equals("admin") && pWord.equals("pass")) {
        	 	RmosMainMenu rmosView = new RmosMainMenu("Recycle Monitoring System");
				RecycleMonitorController rmosCntrl = new RecycleMonitorController(rmosView); 
				rmosCntrl.control();
         }
          
         else {
            String msg = "Incorrect name and password. ";
            JOptionPane.showMessageDialog(null, msg);
         }
      }
       
   }

public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}
 
class LoginPanell extends JPanel {
   private JTextField nameField = new JTextField(10);
   private JPasswordField passwordField = new JPasswordField(10);
    
   public LoginPanell() {
      setLayout(new GridLayout(2, 2, 5, 5)); // change to GridBagLayout later
      add(new JLabel("Name:"));
      add(nameField);
      add(new JLabel("Password:"));
      add(passwordField);
   }
    
   public String getName() {
      return nameField.getText();
   }
    
   public String getPassword() {
      return new String(passwordField.getPassword()); // shouldn't do this!
   }
}