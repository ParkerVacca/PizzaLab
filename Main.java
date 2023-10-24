import javax.swing.ButtonGroup;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JFrame;

import javax.swing.JButton;

import javax.swing.JRadioButton;

import javax.swing.JCheckBox;

import javax.swing.JTextArea;

import javax.swing.JTextField;

import javax.swing.JPanel;

import javax.swing.JComboBox;

import javax.swing.JScrollPane;

import javax.swing.BorderFactory;

import java.awt.Container;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import java.awt.Color;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;


public class Main{



    public static void main (String[] args) {

// TODO Auto-generated method stub



        PizzaUI frame=new PizzaUI();



        frame.setTitle("Pizza House");

        frame.setResizable(false);

        frame.setVisible(true);

        frame.setSize(650,600);



        frame.setLocationRelativeTo(null);

    }

}
