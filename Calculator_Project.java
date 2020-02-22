package com.Leonid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    class Calculator_Project extends JFrame implements ActionListener
    {
        JLabel [] n=new JLabel[1];
        JPanel[] main = new JPanel[6];
        JButton[] button = new JButton[21];
        String[] buttons = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                ".", "/", "C", "root",
                "+/-", "=", "0",};
    /*int[] dim1 = {350,45,100,190};
    int[] dim2 = {35, 40};*/

        boolean[] oper = new boolean[4];
        int [] num = {0, 0};
        JTextArea display = new JTextArea(2,16);
        Font type = new Font("arial", Font.HANGING_BASELINE, 18);

        Calculator_Project() {
            super("Calculator");
            GridLayout grid = new GridLayout(6, 4);
            setLayout(grid);
            setBackground(Color.orange);


            for (int i = 0; i < 4; i++)
                oper[i] = false;
            FlowLayout f1 = new FlowLayout(FlowLayout.RIGHT);
            FlowLayout f2 = new FlowLayout(FlowLayout.LEFT, 1, 1);
            for (int i = 0; i < 5; i++)
                main[i] = new JPanel();
            main[0].setLayout(f1);
            for (int i = 1; i < 5; i++)
                main[i].setLayout(f2);
            for (int i = 0; i < 19; i++) {
                button[i] = new JButton();
                button[i].setText(buttons[i]);
                button[i].setFont(type);
                button[i].addActionListener(this);
            }

            display.setFont(type);
            display.setEditable(false);
            display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

            main[0].add(display);
            add(main[0]);
            for (int i = 0; i < 4; i++)
                main[1].add(button[i]);
            main[1].add(button[14]);
            add(main[1]);
            for (int i = 4; i < 8; i++)
                main[2].add(button[i]);
            main[2].add(button[15]);
            add(main[2]);
            for (int i = 8; i < 12; i++)
                main[3].add(button[i]);
            main[3].add(button[16]);
            add(main[3]);
            main[4].add(button[18]);
            for (int i = 12; i < 14; i++)
                main[4].add(button[i]);
            main[4].add(button[17]);
            add(main[4]);
            setVisible(true);

        }

        public void clearScreen()
        {
            try
            {
                display.setText("");
                for(int i = 0; i < 4; i++)
                    oper[i] = false;
                for(int i = 0; i < 2; i++)
                    num[i] = 0;
            }
            catch(NullPointerException e) {
            }
        }
        public void getSqrt()
        {
            try
            { Double  value = Math.sqrt(Integer.parseInt(display.getText()));
                display.setText(Double.toString(value));
            }
            catch(NumberFormatException e) {
            }
        }
        public void getResult()
        {
            Integer result = 0;
            num[1] = Integer.parseInt(display.getText());
            String temp1 = Integer.toString(num[0]);
            String temp2 = Integer.toString(num[1]);
            try
            {
                if(temp1.contains("-"))
                {
                    String[] temp = temp1.split("-", 9);
                    num[0] = (Integer.parseInt(temp[1]) * -1);
                }
                if(temp2.contains("-"))
                {
                    String[] temp = temp2.split("-", 9);
                    num[1] = (Integer.parseInt(temp[1]) * -1);
                }
            }
            catch(ArrayIndexOutOfBoundsException e) {
            }
            try
            {
                if(oper[2] == true)
                    result = num[0] * num[1];

                else if(oper[3] == true)
                    result = num[0] / num[1];
                else if(oper[0] == true)
                    result = num[0] + num[1];
                else if(oper[1] == true)
                    result = num[0] - num[1];

                display.setText(Double.toString(result));
                for(int i = 0; i < 4; i++)
                    oper[i] = false;
            }
            catch(NumberFormatException e)
            {
            }
        }
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource() == button[0])
                display.append("7");
            if(ae.getSource() == button[1])
                display.append("8");
            if(ae.getSource() == button[2])
                display.append("9");
            if(ae.getSource() == button[3])
            {
                num[0] = Integer.parseInt(display.getText());
                oper[0] = true;
                display.setText("");
            }
            if(ae.getSource() == button[4])
                display.append("4");
            if(ae.getSource() == button[5])
                display.append("5");
            if(ae.getSource() == button[6])
                display.append("6");
            if(ae.getSource() == button[7])
            {
                num[0] = Integer.parseInt(display.getText());
                oper[1] = true;
                display.setText("");
            }
            if(ae.getSource() == button[8])
                display.append("1");
            if(ae.getSource() == button[9])
                display.append("2");
            if(ae.getSource() == button[10])
                display.append("3");
            if(ae.getSource() == button[11])
            {
                num[0] = Integer.parseInt(display.getText());
                oper[2] = true;
                display.setText("");
            }
            if(ae.getSource() == button[12])
                display.append(".");
            if(ae.getSource() == button[13])
            {
                num[0] = Integer.parseInt(display.getText());
                oper[3] = true;
                display.setText("");
            }
            if(ae.getSource() == button[14])
                clearScreen();
            if(ae.getSource() == button[15])
                getSqrt();
            if(ae.getSource() == button[17])
                getResult();
            if(ae.getSource() == button[18])
                display.append("0");
        }
        public static void main(String[] arguments)
        {
            Calculator_Project o= new Calculator_Project();
            o.setSize(300, 300);
            o.setResizable(false);
            o.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }
